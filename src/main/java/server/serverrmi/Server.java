/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.serverrmi;

import static commons.connessione.ImpostazioniConnessione.*;

import commons.connessione.ImpostazioniConnessione;
import commons.servizio.Autenticazione;
import commons.servizio.GestioneCentriMonitoraggio;
import commons.servizio.GestioneMisurazioni;
import commons.servizio.RicercaPuntiInteresse;
import server.servizio.misurazioni.GestoreMisurazioni;
import server.servizio.autenticazione.Autenticatore;
import server.servizio.centrimonitoraggio.GestoreCentriMonitoraggio;
import server.servizio.ricercapoi.RepositoryPuntiInteresse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

/**
 * La classe {@code Server} gestisce l'avvio, l'esecuzione e l'arresto di un server RMI.
 * <p>
 * Utilizza il pattern Singleton per garantire che esista una sola istanza del server
 * e implementa l'interfaccia {@code Runnable} per gestire il thread del server.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Server implements Runnable {

    /** Il thread in cui il server è in esecuzione. */
    private Thread threadServer;

    /** Il registro RMI utilizzato per fare il binding degli oggetti remoti. */
    private Registry registroRMI;

    /** Gestore per l'autenticazione degli utenti. */
    private Autenticatore autenticatore;

    /** Gestore per i centri di monitoraggio. */
    private GestoreCentriMonitoraggio gestoreCentriMonitoraggio;

    /** Gestore per le misurazioni. */
    private GestoreMisurazioni gestoreMisurazioni;

    /** Repository per i punti di interesse. */
    private RepositoryPuntiInteresse repositoryPuntiInteresse;

    /** nome del file di configurazione per host e porta del server. */
    private String configFilePath = File.separator + "config.properties";

    /** Oggetto Properties per il file di configurazione. */
    private Properties properties = new Properties();

    /** Variabile di controllo per il ciclo di esecuzione del server. */
    private volatile boolean running = false;

    /**
     * Costruttore privato per impedire l'istanza diretta della classe.
     * Inizializza i componenti del server.
     */
    private Server() {
        inizializzaServer();
    }

    /**
     * Contenitore della classe Singleton. Garantisce la creazione di una sola istanza del server.
     */
    private static class ContenitoreSingletonServer{
        private static final Server singleton = new Server();
    }

    /**
     * Restituisce l'istanza singleton del server.
     *
     * @return l'istanza singleton del server
     */
    public static Server ottieniIstanzaServer() {
        return ContenitoreSingletonServer.singleton;
    }

    /**
     * Metodo eseguito quando il thread del server è avviato.
     * <p>
     * Mantiene il server in esecuzione fino a quando la variabile {@code running} non viene impostata su {@code false}.
     * </p>
     */
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

    /**
     * Inizializza i componenti del server, inclusi gli oggetti remoti.
     */
    private void inizializzaServer() {
        autenticatore = new Autenticatore();
        gestoreMisurazioni = new GestoreMisurazioni();
        gestoreCentriMonitoraggio = new GestoreCentriMonitoraggio();
        repositoryPuntiInteresse = new RepositoryPuntiInteresse();

    }

    /**
     * Avvia il server, crea il registro RMI e associa gli oggetti remoti a esso.
     * Inoltre, avvia il thread del server.
     */
    public void start() {
        String host = null;
        int port = 0;

        String fullPath = System.getProperty("user.dir");
        String resultPath = ImpostazioniConnessione.getPath(fullPath);

        try (FileInputStream input = new FileInputStream(resultPath + configFilePath)) {
            properties.load(input);
            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            registroRMI = LocateRegistry.createRegistry(port);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        try {
            RicercaPuntiInteresse stubRicercaPuntiInteresse = (RicercaPuntiInteresse) UnicastRemoteObject.exportObject(repositoryPuntiInteresse, port);
            Autenticazione stubAutenticazione = (Autenticazione) UnicastRemoteObject.exportObject(autenticatore, port);
            GestioneMisurazioni stubGestioneMisurazioni = (GestioneMisurazioni) UnicastRemoteObject.exportObject(gestoreMisurazioni, port);
            GestioneCentriMonitoraggio stubGestioneCentriMonitoraggio = (GestioneCentriMonitoraggio) UnicastRemoteObject.exportObject(gestoreCentriMonitoraggio, port);

            registroRMI.rebind(RMI_GestioneCentriMonitoraggio, stubGestioneCentriMonitoraggio);
            registroRMI.rebind(RMI_RicercaPuntiInteresse, stubRicercaPuntiInteresse);
            registroRMI.rebind(RMI_GestioneMisurazioni, stubGestioneMisurazioni);
            registroRMI.rebind(RMI_Autenticazione, stubAutenticazione);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        threadServer = new Thread(this);
        threadServer.start();
    }

    /**
     * Arresta il server interrompendo il thread e rimuovendo gli oggetti remoti dal registro RMI.
     * Inoltre, esegue l'unexport degli oggetti remoti e rimuove il registro RMI.
     */
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

            UnicastRemoteObject.unexportObject(repositoryPuntiInteresse, true);
            UnicastRemoteObject.unexportObject(autenticatore, true);
            UnicastRemoteObject.unexportObject(gestoreMisurazioni, true);
            UnicastRemoteObject.unexportObject(gestoreCentriMonitoraggio, true);

            UnicastRemoteObject.unexportObject(registroRMI, true);
            registroRMI = null;
        } catch (RemoteException | java.rmi.NotBoundException e) {
            e.printStackTrace();
        }
    }
}