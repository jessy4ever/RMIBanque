package rmiService;


import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BanqueImpl extends UnicastRemoteObject implements IBanque {
	private static final long serialVersionUID = 1L;
	private Map<Integer, Compte> comptes;
	
	
	public BanqueImpl() throws RemoteException {
		super();
		comptes = new ConcurrentHashMap<>();
	}
	
	
	@Override
	public String creerCompte(Compte c) throws RemoteException {
		if (comptes.containsKey(c.getCode())) {
			return "Erreur : code de compte déjà existant.";
		}else {
            comptes.put(c.getCode(), c);
            return "Compte créé avec succès ! " + c.toString();
        }
	}
	
	
	@Override
	public String getInfoCompte(int code) throws RemoteException {
		Compte c = comptes.get(code);
		if(c != null) {
            return c.toString();
        } else {
            return "Erreur : compte introuvable pour le code " + code;
        }
	}
}
