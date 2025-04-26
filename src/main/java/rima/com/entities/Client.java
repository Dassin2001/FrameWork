package rima.com.entities;

public class Client {
    private Long id;
    private String nom;

    public Client(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
