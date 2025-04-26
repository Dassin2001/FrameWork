package rima.com.entities;

public class Compte {
    private String code;
    private double solde;

    public Compte() {}

    public Compte(String code, double solde) {
        this.code = code;
        this.solde = solde;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}
