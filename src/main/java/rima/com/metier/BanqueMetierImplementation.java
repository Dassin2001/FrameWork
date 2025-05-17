package rima.com.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rima.com.dao.IBanqueDao;
import rima.com.entities.*;

@Service
public class BanqueMetierImplementation implements IBanqueMetier {

    private final IBanqueDao dao;

    // Injection via constructeur
    @Autowired
    public BanqueMetierImplementation(IBanqueDao dao) {
        this.dao = dao;
    }

    public Client addClient(Client c) {
        return dao.addClient(c);
    }

    public Employe addEmploye(Employe e, Long codeSup) {
        return dao.addEmploye(e, codeSup);
    }

    public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
        return dao.addCompte(cp, codeCli, codeEmp);
    }
}
