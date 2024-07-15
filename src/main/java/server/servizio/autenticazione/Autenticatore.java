
package server.servizio.autenticazione;;

import client.registraeventi.LoggerEventi;
import commons.oggetti.Operatore;

import commons.servizio.Autenticazione;
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
    LoggerEventi logger = LoggerEventi.getInstance();
    private Sessione sessione;

    public Autenticatore() {
        operatoriDAO = new ImplOperatoriDAO();
    }
    
    //TODO rmi
    public boolean registrazione(Operatore operatore) throws RemoteException {
        return operatoriDAO.inserisciNuovoOperatore(operatore);
    }

    //TODO rmi
    public boolean login(int username, String password) throws RemoteException {
        Operatore operatore = operatoriDAO.ottieniOperatoreDaUsername(username);
        if(operatore == null || !password.equals(operatore.getPassword()))
            return false;
        this.sessione = new Sessione(operatore);
        return true;
    }

    //TODO rmi
    public Operatore ottieniOperatoreAutenticato() throws RemoteException {
        return sessione.getOperatore();
    }

}
