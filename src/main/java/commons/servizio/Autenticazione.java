package commons.servizio;

import commons.oggetti.OperatoriClimatici;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticazione extends Remote {
    boolean registrati(OperatoriClimatici operatore) throws RemoteException;
    boolean login(OperatoriClimatici operatore) throws RemoteException;

    //TODO da rimuovere
    OperatoriClimatici getOperatore() throws RemoteException;
}
