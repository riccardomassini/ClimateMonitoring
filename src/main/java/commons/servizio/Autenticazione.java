package commons.servizio;

import commons.oggetti.Operatore;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Autenticazione extends Remote {
    boolean registrazione(Operatore nuovoOperatore) throws RemoteException;
    boolean login(int username, String password) throws RemoteException;
    boolean loginSenzaBcrypt(int username, String password) throws RemoteException;
    Operatore ottieniOperatoreAutenticato() throws RemoteException;

}
