package rima.com.metier;

import rima.com.dao.IBanqueDao;
import rima.com.entities.Client;
import rima.com.entities.Compte;
import rima.com.entities.Employe;

public class BanqueMetierImplementation implements IBanqueMetier {

    private IBanqueDao dao; // Couplage faible

    // ✅ Injection via Setter (tu peux aussi faire via constructeur ou attribut direct plus tard)
    public void setDao(IBanqueDao dao) {
        this.dao = dao;
    }

    @Override
    public Client addClient(Client c) {
        System.out.println("METIER: Traitement d'ajout client");
        return dao.addClient(c);
    }

    @Override
    public Employe addEmploye(Employe e, Long codeSup) {
        System.out.println("METIER: Traitement d'ajout employé");
        return dao.addEmploye(e, codeSup);
    }

    @Override
    public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
        System.out.println("METIER: Traitement d'ajout compte");
        return dao.addCompte(cp, codeCli, codeEmp);
    }
}
