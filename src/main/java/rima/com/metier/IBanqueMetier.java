package rima.com.metier;

import rima.com.entities.Client;
import rima.com.entities.Compte;
import rima.com.entities.Employe;

public interface IBanqueMetier {
    Client addClient(Client c);
    Employe addEmploye(Employe e, Long codeSup);
    Compte addCompte(Compte cp, Long codeCli, Long codeEmp);
}
