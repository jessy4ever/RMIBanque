package rmiServer;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;
import java.rmi.registry.LocateRegistry;
import rmiService.BanqueImpl;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            // Démarrer le registre RMI
            LocateRegistry.createRegistry(1099);
            System.out.println("Registre RMI démarré sur le port 1099.");

            // Créer l'objet distant
            BanqueImpl banque = new BanqueImpl();

            // Configurer l'environnement JNDI
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL, "rmi://localhost:1099");

            Context context = new InitialContext(env);

            // Binding via JNDI
            context.rebind("BANQUE", banque);

            System.out.println("Serveur RMI prêt et BanqueImpl enregistré via JNDI.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
