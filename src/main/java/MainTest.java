import rima.com.dao.*;
import rima.com.entities.*;
import rima.com.metier.*;

public class MainTest {
    public static void main(String[] args) {
        IBanqueDao dao = new BanqueDaoImpl();

        dao.addClient(new Client(1L, "Rania"));
        dao.addEmploye(new Employe(2L, "Ahmed"), null);
        dao.addCompte(new Compte("C123", 5000), 1L, 2L);

       // BanqueDaoImpl dao = new BanqueDaoImpl();
        BanqueMetierImplementation metier = new BanqueMetierImplementation();

        // Injection de dépendance
        metier.setDao(dao);

        metier.addClient(new Client(1L, "Rania"));
        metier.addEmploye(new Employe(2L, "Ahmed"), null);
        metier.addCompte(new Compte("C123", 5000), 1L, 2L);
    }
}
