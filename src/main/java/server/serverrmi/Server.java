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

public class Server implements  Runnable {
    private Thread threadServer;
    private Registry registroRMI;
    private Autenticatore autenticatore;
    private GestoreCentriMonitoraggio gestoreCentriMonitoraggio;
    private GestoreMisurazioni gestoreMisurazioni;
    private RepositoryPuntiInteresse repositoryPuntiInteresse;

    public Server() {
        inizializzaServer();
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    @Override
    public void run() {
        System.out.println("Server è partito!");

    }

    public void start() {
        threadServer.start();
    }

    private void inizializzaServer() {
        threadServer = new Thread(this); //inizializzazione thread per il server

        //inizializzare oggetti rmi
        autenticatore = new Autenticatore();
        gestoreMisurazioni = new GestoreMisurazioni();
        gestoreCentriMonitoraggio = new GestoreCentriMonitoraggio();
        repositoryPuntiInteresse = new RepositoryPuntiInteresse();

        //ottenere stub oggetti remoti
        RicercaPuntiInteresse stubRicercaPuntiInteresse = null;
        GestioneMisurazioni stubGestioneMisurazioni = null;
        GestioneCentriMonitoraggio stubGestioneCentriMonitoraggio = null;
        Autenticazione stubAutenticazione = null;

        try {
            stubRicercaPuntiInteresse = (RicercaPuntiInteresse) UnicastRemoteObject.exportObject(repositoryPuntiInteresse, PORTA);
            stubAutenticazione = (Autenticazione) UnicastRemoteObject.exportObject(autenticatore, PORTA);
            stubGestioneMisurazioni= (GestioneMisurazioni) UnicastRemoteObject.exportObject(gestoreMisurazioni, PORTA);
            stubGestioneCentriMonitoraggio = (GestioneCentriMonitoraggio) UnicastRemoteObject.exportObject(gestoreCentriMonitoraggio, PORTA);
        } catch (RemoteException e) {
            System.err.println("Errore nell'esportazione degli oggetti remoti");
            e.printStackTrace();
        }

        //creare registro rmi
        try {
            registroRMI = LocateRegistry.createRegistry(PORTA);
        } catch (RemoteException e) {
            System.err.println("Errore nella creazione del registro RMI");
            e.printStackTrace();
        }

        //fare binding oggetti remoti a registro RMI
        try {
            registroRMI.rebind(RMI_GestioneCentriMonitoraggio, stubGestioneCentriMonitoraggio);
            registroRMI.rebind(RMI_RicercaPuntiInteresse, stubRicercaPuntiInteresse);
            registroRMI.rebind(RMI_GestioneMisurazioni, stubGestioneMisurazioni);
            registroRMI.rebind(RMI_Autenticazione, stubAutenticazione);
        } catch (RemoteException e) {
            System.err.println("Errore nel binding degli oggetti remoti");
            e.printStackTrace();
        }
    }

}
