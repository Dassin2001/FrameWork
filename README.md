# Mini Projet – Injection des dépendances  

---

## Objectif du mini-projet
  
Ce mini-projet Java simule un système de gestion bancaire simplifié basé sur le principe d’injection de dépendances. Il est structuré autour de trois entités principales (Client, Compte et Employe) regroupées dans le package entities. Les opérations métiers sont définies dans une interface IBanqueMetier et implémentées dans une classe BanqueMetierImplementation, tandis que les opérations d’accès aux données sont centralisées dans l’interface IBanqueDao et sa classe d’implémentation BanqueDaoImpl, regroupées dans le package dao. L’objectif du projet est de démontrer différentes techniques d’injection des dépendances (statique, dynamique, XML, annotations) à travers une architecture modulaire et faiblement couplée
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
  ![image](image/p1.png)


### b. Injection via le **setter**

- Le DAO est injecté dans la classe métier après l’instanciation, à l’aide d’une méthode `setDao(...)` configurée dans le XML.
- Cette approche est plus flexible, mais le DAO n’est pas obligatoire à l’instanciation.
  
  ![image](image/p2.png)

### c. Injection par **attribut (field access)**
Cette méthode injecte la dépendance dao directement dans le champ privé de la classe métier, sans passer par un setter ni un constructeur.

- L’attribut privé `dao` est défini dans la classe métier.
- La configuration XML permet d’accéder à cet attribut directement sans setter ni constructeur.
- Moins utilisée en entreprise, mais concise.
  
  ![image](image/p3.png)

---

## Partie 2 : Injection via annotations Spring

Dans cette deuxième approche, on utilise le conteneur Spring et ses annotations pour détecter automatiquement les classes, les instancier, et injecter les dépendances.
On indique à Spring de scanner le package "rima.com". Il va détecter automatiquement les classes annotées, créer les objets nécessaires et injecter les dépendances.

  ![image](image/p4.png)

### a. Injection via le **constructeur**
Dans cette méthode, nous allons injecter la dépendance via un constructeur annoté avec @Autowired. Cette approche est fortement recommandée car elle garantit que la dépendance est obligatoire pour le bon fonctionnement de l’objet.
 	Pour cela, on doit :
•	Annoter la classe métier avec @Service pour la rendre visible à Spring.
•	Déclarer un constructeur qui accepte la dépendance en paramètre.
•	Annoter ce constructeur avec @Autowired. 

- Annoter la classe métier avec `@Service`
- Définir un constructeur avec un paramètre de type `IBanqueDao`
- Annoter le constructeur avec `@Autowired`

 ![image](image/p5.png)



### b. Injection via le setter
Nous allons maintenant injecter la dépendance en utilisant une méthode setter annotée avec @Autowired. Cette technique est plus flexible car la dépendance peut être définie ou modifiée après la création de l’objet.
 	Pour cela, on doit :
•	Fournir un constructeur vide (ou ne rien déclarer si aucun constructeur n'est défini).
•	Définir un setter public pour la dépendance.
•	Annoter ce setter avec @Autowired.



 ![image](image/p6.png)
Avec cette approche, Spring crée l’objet sans paramètre, puis appelle la méthode setDao() en lui injectant une instance de IBanqueDao.
### c. Injection par champ (field)
Enfin, nous allons réaliser l’injection de dépendance directement dans un attribut privé, sans utiliser ni setter ni constructeur. Cette méthode est la plus concise, mais elle est moins adaptée au test unitaire car les champs sont généralement inaccessibles sans réflexion.
Pour cela, on doit :
•	Déclarer un champ privé de type IBanqueDao.
•	Annoter ce champ avec @Autowired.


Spring identifie le champ annoté et lui affecte automatiquement une instance du bean adéquat lors de l’instanciation de l’objet métier.
 	Pour permettre à Spring d’injecter automatiquement l’implémentation de l’interface IBanqueDao, nous devons également annoter la classe DAO avec @Repository. Cela permet à Spring de reconnaître cette classe comme un composant de la couche d’accès aux données.
 ![image](image/p6.png)
 	Dans le cas où plusieurs classes implémentent la même interface, Spring ne peut pas savoir laquelle injecter. Pour résoudre ce problème, on utilise l’annotation @Qualifier afin de préciser le nom du bean à injecter

 ![image](image/p8.png)
 
 
