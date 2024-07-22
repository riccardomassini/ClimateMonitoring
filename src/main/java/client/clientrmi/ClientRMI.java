package client.clientrmi;

import static commons.connessione.ImpostazioniConnessione.*;
import commons.servizio.Autenticazione;
import commons.servizio.GestioneCentriMonitoraggio;
import commons.servizio.GestioneMisurazioni;
import commons.servizio.RicercaPuntiInteresse;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    private Autenticazione stubAutenticazione;
    private RicercaPuntiInteresse stubRicercaPuntiInteresse;
    private GestioneCentriMonitoraggio stubGestioneCentriMonitoraggio;
    private GestioneMisurazioni stubGestioneMisurazioni;
    private Registry registroRMI;

    private ClientRMI() {
        try {
            registroRMI = LocateRegistry.getRegistry(HOST, PORTA);
            stubAutenticazione = (Autenticazione) registroRMI.lookup(RMI_Autenticazione);
            stubGestioneMisurazioni = (GestioneMisurazioni) registroRMI.lookup(RMI_GestioneMisurazioni);
            stubGestioneCentriMonitoraggio = (GestioneCentriMonitoraggio) registroRMI.lookup(RMI_GestioneCentriMonitoraggio);
            stubRicercaPuntiInteresse = (RicercaPuntiInteresse) registroRMI.lookup(RMI_RicercaPuntiInteresse);
        } catch (RemoteException e) {
            System.err.println("Errore di connessione al servizio RMI");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("Errore nel recupero degli oggetti remoti dal registro RMI");
            e.printStackTrace();
        }
    }

    private static class ContenitoreSingletClientRMI {
        private static final ClientRMI singleton = new ClientRMI();
    }

    public static ClientRMI ottieniClientRMI() {
        return ContenitoreSingletClientRMI.singleton;
    }

    public Autenticazione ottieniStubAutenticazione() {
        return stubAutenticazione;
    }

    public RicercaPuntiInteresse ottieniStubRicercaPuntiInteresse() {
        return stubRicercaPuntiInteresse;
    }

    public GestioneMisurazioni ottieniStubGestioneMisurazioni() {
        return stubGestioneMisurazioni;
    }

    public GestioneCentriMonitoraggio ottieniStubGestioneCentriMonitoraggio() {
        return stubGestioneCentriMonitoraggio;
    }

}
