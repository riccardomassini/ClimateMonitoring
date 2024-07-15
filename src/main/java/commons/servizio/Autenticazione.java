package commons.servizio;

import commons.oggetti.Operatore;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticazione extends Remote {
    boolean registrati(Operatore operatore) throws RemoteException;
    boolean login(Operatore operatore) throws RemoteException;

    //TODO da rimuovere
    Operatore getOperatore() throws RemoteException;
}
