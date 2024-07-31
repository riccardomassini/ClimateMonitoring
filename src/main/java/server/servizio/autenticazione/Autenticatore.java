/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.servizio.autenticazione;

import commons.oggetti.Operatore;

import commons.oggetti.ValidatorePassword;
import commons.servizio.Autenticazione;
import server.database.dao.OperatoriDAO;
import server.database.servizio.ImplOperatoriDAO;

import java.rmi.RemoteException;

/**
 * La classe Autenticatore implementa l'interfaccia Autenticazione e fornisce
 * i metodi per la registrazione e l'autenticazione degli operatori.
 * <p>
 * Questa classe gestisce la logica di autenticazione e mantiene lo stato
 * dell'operatore autenticato attraverso la sessione.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Autenticatore implements Autenticazione {

    /** DAO per la gestione delle operazioni sui dati degli operatori. */
    private OperatoriDAO operatoriDAO;

    /** Sessione corrente che mantiene lo stato dell'operatore autenticato. */
    private Sessione sessione;

    /**
     * Costruttore della classe Autenticatore.
     * <p>
     * Inizializza la sessione corrente e il DAO per gli operatori.
     * </p>
     */
    public Autenticatore() {
        this.sessione = Sessione.ottieniSessione();
        operatoriDAO = new ImplOperatoriDAO();
    }

    /**
     * Registra un nuovo operatore nel sistema.
     * <p>
     * La password dell'operatore viene hashata prima di essere memorizzata.
     * </p>
     *
     * @param operatore l'operatore da registrare
     * @return true se la registrazione ha successo, false altrimenti
     * @throws RemoteException in caso di errore durante l'operazione remota
     */
    @Override
    public synchronized boolean registrazione(Operatore operatore) throws RemoteException {
        operatore.setPassword(ValidatorePassword.ottieniHashPassword(operatore.getPassword()));
        return operatoriDAO.inserisciNuovoOperatore(operatore);
    }

    /**
     * Effettua il login di un operatore utilizzando bcrypt per verificare la password.
     * <p>
     * Se l'operatore esiste e la password è corretta, viene salvato nella sessione corrente.
     * </p>
     *
     * @param username l'username dell'operatore
     * @param password la password dell'operatore
     * @return true se il login ha successo, false altrimenti
     * @throws RemoteException in caso di errore durante l'operazione remota
     */
    @Override
    public synchronized boolean login(int username, String password) throws RemoteException {
        Operatore operatore = operatoriDAO.ottieniOperatoreDaUsername(username);
        if(operatore == null || !ValidatorePassword.passwordHashCorretto(operatore.getPassword(), password))
            return false;
        this.sessione.setOperatore(operatore);
        return true;
    }

    /**
     * Effettua il login di un operatore senza utilizzare bcrypt per la verifica della password.
     * <p>
     * Questo metodo può essere utilizzato in situazioni particolari dove non è necessario
     * utilizzare bcrypt per la verifica della password.
     * </p>
     *
     * @param username l'username dell'operatore
     * @param password la password dell'operatore
     * @return true se il login ha successo, false altrimenti
     * @throws RemoteException in caso di errore durante l'operazione remota
     */
    @Override
    public synchronized boolean loginSenzaBcrypt(int username, String password) throws RemoteException {
        Operatore operatore = operatoriDAO.ottieniOperatoreDaUsername(username);
        if(operatore == null)
            return false;
        this.sessione.setOperatore(operatore);
        return true;
    }

    /**
     * Restituisce l'operatore attualmente autenticato nella sessione corrente.
     *
     * @return l'operatore autenticato o null se nessun operatore è autenticato
     * @throws RemoteException in caso di errore durante l'operazione remota
     */
    @Override
    public synchronized Operatore ottieniOperatoreAutenticato() throws RemoteException {
        return sessione.getOperatore();
    }
}