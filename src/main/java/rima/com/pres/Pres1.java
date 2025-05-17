package rima.com.pres;

import rima.com.dao.IBanqueDao;
import rima.com.dao.BanqueDaoImpl;
import rima.com.entities.Client;
import rima.com.metier.IBanqueMetier;

import java.lang.reflect.Field;

public class Pres1 {

    public static void main(String[] args) throws Exception {
        Class<?> daoClass = Class.forName("rima.com.dao.BanqueDaoImpl");
        IBanqueDao dao = (IBanqueDao) daoClass.getDeclaredConstructor().newInstance();
        Class<?> metierClass = Class.forName("rima.com.metier.BanqueMetierImplementation");
        Object metier = metierClass.getDeclaredConstructor().newInstance();
        Field field = metierClass.getDeclaredField("dao");
        field.setAccessible(true); // autorise accès à un champ privé
        field.set(metier, dao);    // injection directe
        ((IBanqueMetier) metier).addClient(new Client(1L, "Rima"));
    }
}
