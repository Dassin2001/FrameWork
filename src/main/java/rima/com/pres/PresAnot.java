package rima.com.pres;

import rima.com.entities.*;
import rima.com.metier.*;
import rima.com.dao.*;
import java.util.List;

public class PresAnot {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("rima.com");

        IBanqueMetier metier = context.getBean(IBanqueMetier.class);

        metier.addClient(new Client(1L, "Rima"));
    }
}

