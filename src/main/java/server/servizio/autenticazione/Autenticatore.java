
package server.servizio.autenticazione;

import commons.oggetti.Operatore;

import commons.oggetti.ValidatorePassword;
import commons.servizio.Autenticazione;
import org.mindrot.jbcrypt.BCrypt;
import server.database.dao.OperatoriDAO;
import server.database.servizio.ImplOperatoriDAO;

import java.rmi.RemoteException;

/**
 * Classe utilizza una struttura dati di tipo Operatore per gestire,
 * per organizzare e salvare in un file tutti i parametri inseriti dall'utente
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class Autenticatore implements Autenticazione {

    private OperatoriDAO operatoriDAO;
    private Sessione sessione;

    public Autenticatore() {
        this.sessione = Sessione.ottieniSessione();
        operatoriDAO = new ImplOperatoriDAO();
    }
    
    @Override
    public synchronized boolean registrazione(Operatore operatore) throws RemoteException {
        operatore.setPassword(ValidatorePassword.ottieniHashPassword(operatore.getPassword()));
        return operatoriDAO.inserisciNuovoOperatore(operatore);
    }

    @Override
    public synchronized boolean login(int username, String password) throws RemoteException {
        Operatore operatore = operatoriDAO.ottieniOperatoreDaUsername(username);
        if(operatore == null || ValidatorePassword.passwordCorretta(operatore.getPassword(), password))
            return false;
        this.sessione.setOperatore(operatore);
        return true;
    }

    @Override
    public synchronized Operatore ottieniOperatoreAutenticato() throws RemoteException {
        return sessione.getOperatore();
    }

}
