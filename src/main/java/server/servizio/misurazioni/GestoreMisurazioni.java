/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.servizio.misurazioni;

import commons.oggetti.misurazioni.Misurazione;
import commons.servizio.GestioneMisurazioni;
import server.database.dao.MisurazioniDAO;
import server.database.servizio.ImplMisurazioniDAO;

import java.rmi.RemoteException;

/**
 * La classe GestoreMisurazioni implementa l'interfaccia GestioneMisurazioni
 * e fornisce metodi per la gestione delle misurazioni nel sistema.
 * <p>
 * Questa classe funge da intermediario tra l'interfaccia utente o altre parti del sistema
 * e il livello di accesso ai dati (DAO) per le operazioni relative alle misurazioni.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class GestoreMisurazioni implements GestioneMisurazioni {

    /** DAO per l'accesso ai dati delle misurazioni. */
    private MisurazioniDAO misurazioniDAO ;

    /**
     * Costruttore della classe GestoreMisurazioni.
     * <p>
     * Inizializza l'istanza del DAO per interagire con il livello di accesso ai dati.
     * </p>
     */
    public GestoreMisurazioni() {
        misurazioniDAO = new ImplMisurazioniDAO();
    }

    /**
     * Inserisce una nuova misurazione nel sistema.
     * <p>
     * Questo metodo delega l'inserimento della nuova misurazione al DAO.
     * </p>
     *
     * @param nuovaMisurazione la nuova misurazione da inserire
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized void inserisciNuovaMisurazione(Misurazione nuovaMisurazione) throws RemoteException {
        misurazioniDAO.inserisciNuovaMisurazione(nuovaMisurazione);
    }

    /**
     * Restituisce un array di misurazioni associate a un punto di interesse specifico.
     * <p>
     * Questo metodo delega il recupero delle misurazioni associate al DAO.
     * </p>
     *
     * @param idPuntoInteresse l'identificatore del punto di interesse per cui ottenere le misurazioni
     * @return un array di misurazioni associate al punto di interesse specificato
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized Misurazione[] ottieniMisurazioniSuPuntoInteresse(int idPuntoInteresse) throws RemoteException {
        return misurazioniDAO.ottieniMisurazioniPuntoInteresse(idPuntoInteresse);
    }
}