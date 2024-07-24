package server.serverrmi;

import static commons.connessione.ImpostazioniConnessione.*;
import commons.servizio.Autenticazione;
import commons.servizio.GestioneCentriMonitoraggio;
import commons.servizio.GestioneMisurazioni;
import commons.servizio.RicercaPuntiInteresse;
import server.servizio.misurazioni.GestoreMisurazioni;
import server.servizio.autenticazione.Autenticatore;
import server.servizio.centrimonitoraggio.GestoreCentriMonitoraggio;
import server.servizio.ricercapoi.RepositoryPuntiInteresse;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Runnable {
    private Thread threadServer;
    private Registry registroRMI;
    private Autenticatore autenticatore;
    private GestoreCentriMonitoraggio gestoreCentriMonitoraggio;
    private GestoreMisurazioni gestoreMisurazioni;
    private RepositoryPuntiInteresse repositoryPuntiInteresse;

    private volatile boolean running = false;

    private Server() {
        inizializzaServer();
    }

    private static class ContenitoreSingletonServer{
        // Static to ensure one instance and final to ensure that it cannot be reassigned
        private static final Server singleton = new Server();
    }

    // Public method to provide access to the instance
    public static Server ottieniIstanzaServer() {
        return ContenitoreSingletonServer.singleton;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void inizializzaServer() {
        //creare registro rmi
        try {
            registroRMI = LocateRegistry.createRegistry(PORTA);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        //inizializzare servizi remoti
        autenticatore = new Autenticatore();
        gestoreMisurazioni = new GestoreMisurazioni();
        gestoreCentriMonitoraggio = new GestoreCentriMonitoraggio();
        repositoryPuntiInteresse = new RepositoryPuntiInteresse();

    }

    public void start() {
        //ottenere stub oggetti remoti
        try {
            RicercaPuntiInteresse stubRicercaPuntiInteresse = (RicercaPuntiInteresse) UnicastRemoteObject.exportObject(repositoryPuntiInteresse, PORTA);
            Autenticazione stubAutenticazione = (Autenticazione) UnicastRemoteObject.exportObject(autenticatore, PORTA);
            GestioneMisurazioni stubGestioneMisurazioni = (GestioneMisurazioni) UnicastRemoteObject.exportObject(gestoreMisurazioni, PORTA);
            GestioneCentriMonitoraggio stubGestioneCentriMonitoraggio = (GestioneCentriMonitoraggio) UnicastRemoteObject.exportObject(gestoreCentriMonitoraggio, PORTA);



            //fare binding oggetti remoti a registro RMI
            registroRMI.rebind(RMI_GestioneCentriMonitoraggio, stubGestioneCentriMonitoraggio);
            registroRMI.rebind(RMI_RicercaPuntiInteresse, stubRicercaPuntiInteresse);
            registroRMI.rebind(RMI_GestioneMisurazioni, stubGestioneMisurazioni);
            registroRMI.rebind(RMI_Autenticazione, stubAutenticazione);
        } catch (RemoteException e) {
            System.err.println("Errore nell'inizializzazione del server RMI");
            e.printStackTrace();
        }



        threadServer = new Thread(this); //inizializzazione thread per il server
        threadServer.start();
        System.out.println("Start...");
    }

    public void stop() {
        running = false;
        if (threadServer != null) {
            threadServer.interrupt();
        }
        try {
            if (registroRMI != null) {
                registroRMI.unbind(RMI_GestioneCentriMonitoraggio);
                registroRMI.unbind(RMI_RicercaPuntiInteresse);
                registroRMI.unbind(RMI_GestioneMisurazioni);
                registroRMI.unbind(RMI_Autenticazione);
            }
            UnicastRemoteObject.unexportObject(registroRMI, true);
            registroRMI = null;
        } catch (RemoteException | java.rmi.NotBoundException e) {
            System.err.println("Errore durante lo stop del server RMI");
            e.printStackTrace();
        }
    }

}