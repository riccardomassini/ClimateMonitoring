package commons.servizio;

import commons.oggetti.PuntoInteresse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RicercaPuntiInteresse extends Remote {
    PuntoInteresse[] ottieniElencoPuntiInteresse() throws RemoteException;
    PuntoInteresse[] ricercaPerNome(String nome) throws RemoteException;
    PuntoInteresse[] ricercaPerNazione(String codiceNazione) throws RemoteException;
    PuntoInteresse[] ricercaPerCoordinate(double latitudine, double longitudine) throws RemoteException;
    PuntoInteresse[] ricercaPerNomeENazione(String nomePuntoInteresse, String codiceNazione) throws RemoteException;
}
