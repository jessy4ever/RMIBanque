# RMIBanque

## Description
Ce projet est une application Java répartie qui utilise **RMI et JNDI** pour gérer des comptes bancaires.  
Il comporte deux sous-projets :  

1. **RMIBanque_Server** : serveur RMI qui gère les comptes bancaires et expose les méthodes distantes.  
2. **RMIBanque_Client** : client RMI qui invoque les méthodes distantes pour créer et consulter des comptes.  

---

## Structure du projet

RMIBanque/
├── RMIBanque_Server/
│ ├── src/metier/Compte.java
│ ├── src/rmiService/IBanque.java
│ ├── src/rmiService/BanqueImpl.java
│ ├── src/rmiServer/BanqueServer.java
│ └── src/jndi.properties
└── RMIBanque_Client/
├── src/rmiClient/BanqueClient.java
└── banqueClient.jar


---

## Prérequis

- Java JDK >= 1.8  
- Eclipse IDE for Java Developers  
- Git / GitHub (pour le dépôt)

---

## Instructions pour exécuter le projet

### 1. Lancer le serveur

1. Ouvrir `RMIBanque_Server` dans Eclipse.  
2. Exécuter la classe `BanqueServer`.  
3. Vérifier dans la console que le registre RMI est démarré et que l’objet BanqueImpl est enregistré via JNDI.  

### 2. Lancer le client

1. Ouvrir `RMIBanque_Client` dans Eclipse.  
2. Vérifier que le fichier `banqueClient.jar` est ajouté au Build Path.  
3. Exécuter la classe `BanqueClient`.  
4. Vérifier les messages de création et consultation de comptes dans la console.

---

## Fonctionnalités

- Création d’un compte bancaire avec un code et un solde initial.  
- Consultation des informations d’un compte à partir de son code.  
- Communication client/serveur via RMI et JNDI.  

---

## Exemple de sortie console

### Serveur

Registre RMI démarré sur le port 1099.
Serveur RMI prêt et BanqueImpl enregistré via JNDI.


### Client

Compte créé avec succès ! Compte { code=1, solde=500.0, dateCreation=... }
Compte { code=1, solde=500.0, dateCreation=... }


## Notes personnelles

Ce TP m’a permis de mieux comprendre :  

- La communication RMI en Java  
- L’utilisation de JNDI pour rechercher des objets distants  
- La gestion serveur/client et la création de comptes distants
