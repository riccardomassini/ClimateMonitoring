package commons.servizio;

import commons.oggetti.misurazioni.Misurazione;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestioneMisurazioni extends Remote {
    void inserisciNuovaMisurazione(Misurazione nuovaMisurazione) throws RemoteException;
    Misurazione[] ottieniMisurazioniSuPuntoInteresse(int idPuntoInteresse) throws RemoteException;
}
