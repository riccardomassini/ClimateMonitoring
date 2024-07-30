/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.servizio;

import commons.oggetti.Operatore;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaccia {@code Autenticazione} per la gestione dell'autenticazione e della registrazione degli operatori
 * attraverso un servizio RMI (Remote Method Invocation).
 * <p>
 * Questa interfaccia definisce i metodi per registrare un nuovo operatore, effettuare il login, e ottenere
 * le informazioni dell'operatore autenticato. Include anche un metodo di login alternativo che non utilizza
 * BCrypt per la verifica della password.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface Autenticazione extends Remote {

    /**
     * Registra un nuovo operatore nel sistema.
     *
     * @param nuovoOperatore l'operatore da registrare
     * @return {@code true} se la registrazione è avvenuta con successo, {@code false} altrimenti
     * @throws RemoteException se si verifica un errore di comunicazione durante la registrazione
     */
    boolean registrazione(Operatore nuovoOperatore) throws RemoteException;

    /**
     * Effettua il login dell'operatore con le credenziali fornite.
     *
     * @param username il nome utente dell'operatore
     * @param password la password dell'operatore
     * @return {@code true} se il login è avvenuto con successo, {@code false} altrimenti
     * @throws RemoteException se si verifica un errore di comunicazione durante il login
     */
    boolean login(int username, String password) throws RemoteException;

    /**
     * Effettua il login dell'operatore utilizzando un metodo alternativo che non fa uso di BCrypt per la
     * verifica della password.
     *
     * @param username il nome utente dell'operatore
     * @param password la password dell'operatore
     * @return {@code true} se il login è avvenuto con successo, {@code false} altrimenti
     * @throws RemoteException se si verifica un errore di comunicazione durante il login
     */
    boolean loginSenzaBcrypt(int username, String password) throws RemoteException;

    /**
     * Ottiene le informazioni dell'operatore attualmente autenticato.
     *
     * @return l'operatore autenticato
     * @throws RemoteException se si verifica un errore di comunicazione durante il recupero delle informazioni
     */
    Operatore ottieniOperatoreAutenticato() throws RemoteException;
}