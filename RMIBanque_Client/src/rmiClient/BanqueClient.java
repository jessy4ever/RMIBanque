package rmiClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;
import rmiService.IBanque;
import metier.Compte;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Configurer l'environnement JNDI
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL, "rmi://localhost:1099");

            Context context = new InitialContext(env);

            // Rechercher l'objet distant via JNDI
            IBanque banque = (IBanque) context.lookup("BANQUE");

            // Tester : créer un compte
            Compte c1 = new Compte(1, 500.0);
            System.out.println(banque.creerCompte(c1));

            // Tester : consulter un compte
            System.out.println(banque.getInfoCompte(1));

        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
