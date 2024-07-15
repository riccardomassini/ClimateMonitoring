package commons.servizio;

import commons.oggetti.PuntoInteresse;
import commons.oggetti.ParametriClimatici;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestioneMisurazioni extends Remote {
    void inserisciNuovaMisurazione(ParametriClimatici parametri) throws RemoteException;
    ArrayList<ParametriClimatici> ottieniMisurazioniSuPuntoInteresse(PuntoInteresse paese) throws RemoteException;
    double[] ottieniMediaMisurazioni() throws RemoteException;
    int[] ottieniModaMisurazioni() throws RemoteException;
}
