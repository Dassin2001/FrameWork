package rima.com.dao;

import rima.com.entities.Client;
import rima.com.entities.Employe;
import rima.com.entities.Compte;

public interface IBanqueDao {
    Client addClient(Client c);
    Employe addEmploye(Employe e, Long codeSup);
    Compte addCompte(Compte cp, Long codeCli, Long codeEmp);
}
