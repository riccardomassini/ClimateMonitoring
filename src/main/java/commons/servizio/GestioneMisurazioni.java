package commons.servizio;

import commons.oggetti.Misurazione;
import commons.oggetti.PuntoInteresse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestioneMisurazioni extends Remote {
    void inserisciNuovaMisurazione(Misurazione parametri) throws RemoteException;
    ArrayList<Misurazione> ottieniMisurazioniSuPuntoInteresse(PuntoInteresse paese) throws RemoteException;
    double[] ottieniMediaMisurazioni() throws RemoteException;
    int[] ottieniModaMisurazioni() throws RemoteException;
}
