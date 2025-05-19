# Mini Projet – Injection des dépendances  

---

## Objectif du mini-projet

Ce mini-projet a pour but de simuler le fonctionnement d’un conteneur d’injection de dépendances, en s’inspirant de Spring Framework.  
Deux approches sont abordées :

1. Injection des dépendances via **configuration XML** avec JAXB (Jax Binding / OXM)  
2. Injection des dépendances via **annotations Spring** (`@Autowired`, `@Qualifier`, etc.)

---

## Technologies utilisées

- Java 8+
- JAXB (Java Architecture for XML Binding)
- Spring Framework (IOC Container)
- IDE : IntelliJ IDEA

---

## Partie 1 : Injection via XML avec JAXB

Dans cette approche, nous avons simulé Spring à travers un fichier XML. L’objectif est de configurer les objets à injecter et de réaliser l’injection dans la couche métier par trois méthodes :

### a. Injection via le **constructeur**

- Le fichier XML définit un bean métier avec un constructeur recevant le DAO.
- Lors du parsing XML avec JAXB, l’objet DAO est injecté automatiquement dans la classe métier à la création.

### b. Injection via le **setter**

- Le DAO est injecté dans la classe métier après l’instanciation, à l’aide d’une méthode `setDao(...)` configurée dans le XML.
- Cette approche est plus flexible, mais le DAO n’est pas obligatoire à l’instanciation.

### c. Injection par **attribut (field access)**

- L’attribut privé `dao` est défini dans la classe métier.
- La configuration XML permet d’accéder à cet attribut directement sans setter ni constructeur.
- Moins utilisée en entreprise, mais concise.

---

## Partie 2 : Injection via annotations Spring

Spring permet de simplifier l’injection grâce à des annotations. Le conteneur Spring détecte automatiquement les classes concernées dans un package, les instancie, puis injecte les dépendances.

### a. Injection via le **constructeur**

- Annoter la classe métier avec `@Service`
- Définir un constructeur avec un paramètre de type `IBanqueDao`
- Annoter le constructeur avec `@Autowired`

```java
@Service
public class BanqueMetierImpl implements IBanqueMetier {
    private final IBanqueDao dao;

    @Autowired
    public BanqueMetierImpl(IBanqueDao dao) {
        this.dao = dao;
    }
}
```
