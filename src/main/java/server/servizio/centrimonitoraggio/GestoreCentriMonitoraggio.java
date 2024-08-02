/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.servizio.centrimonitoraggio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import commons.servizio.GestioneCentriMonitoraggio;
import server.database.dao.CentriMonitoraggioDAO;
import server.database.servizio.ImplCentriMonitoraggioDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * La classe GestoreCentriMonitoraggio implementa l'interfaccia GestioneCentriMonitoraggio
 * e fornisce metodi per la gestione dei centri di monitoraggio e delle aree di interesse associate.
 * <p>
 * Questa classe funge da intermediario tra l'interfaccia utente
 * e il livello di accesso ai dati (DAO) per le operazioni relative ai centri di monitoraggio.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class GestoreCentriMonitoraggio implements GestioneCentriMonitoraggio {

    /** DAO per l'accesso ai dati dei centri di monitoraggio. */
    private CentriMonitoraggioDAO centriMonitoraggioDAO;

    /**
     * Costruttore della classe GestoreCentriMonitoraggio.
     * <p>
     * Inizializza l'istanza del DAO per interagire con il livello di accesso ai dati.
     * </p>
     */
    public GestoreCentriMonitoraggio() {
        this.centriMonitoraggioDAO = new ImplCentriMonitoraggioDAO();
    }

    /**
     * Registra un nuovo centro di monitoraggio nel sistema.
     * <p>
     * Questo metodo delega l'inserimento del nuovo centro di monitoraggio al DAO.
     * </p>
     *
     * @param nuovoCentro il nuovo centro di monitoraggio da registrare
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized void registraCentroMonitoraggio(CentroMonitoraggio nuovoCentro) throws RemoteException {
        centriMonitoraggioDAO.inserisciCentroMonitoraggio(nuovoCentro);
    }

    /**
     * Associa un elenco di punti di interesse a un centro di monitoraggio specifico.
     * <p>
     * Questo metodo delega l'associazione dei punti di interesse al DAO.
     * </p>
     *
     * @param nomeCentro il nome del centro di monitoraggio
     * @param elencoPuntiInteresse l'elenco dei punti di interesse da associare al centro
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized void associaPuntiInteresseCentroMonitoraggio(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse) throws RemoteException {
        centriMonitoraggioDAO.inserisciPuntiInteresseMonitoratiDaCentro(nomeCentro, elencoPuntiInteresse);
    }

    /**
     * Restituisce un elenco di punti di interesse associati a un centro di monitoraggio specifico.
     * <p>
     * Questo metodo delega il recupero dei punti di interesse associati al DAO.
     * </p>
     *
     * @param nomeCentro il nome del centro di monitoraggio
     * @return un ArrayList di punti di interesse associati al centro specificato
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized ArrayList<PuntoInteresse> ottieniAreeAssociate(String nomeCentro) throws RemoteException{
        return centriMonitoraggioDAO.ottieniPuntiInteresseMonitoratiDaCentro(nomeCentro);
    }

    /**
     * Associa un centro di monitoraggio a un operatore specifico.
     * <p>
     * Questo metodo delega l'aggiornamento del centro di monitoraggio associato all'operatore al DAO.
     * </p>
     *
     * @param usernameOperatore l'username dell'operatore
     * @param nomeNuovoCentro il nome del nuovo centro di monitoraggio da associare
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized void associaCentroMonitoraggioOperatore(int usernameOperatore, String nomeNuovoCentro) throws RemoteException{
        centriMonitoraggioDAO.aggiornaCentroMonitoraggioAssociatoOperatore(usernameOperatore, nomeNuovoCentro);
    }

    /**
     * Restituisce un punto di interesse specifico associato a un centro di monitoraggio.
     * <p>
     * Questo metodo delega il recupero del punto di interesse specifico al DAO.
     * </p>
     *
     * @param nomePaese il nome del paese del punto di interesse
     * @param codice il codice del punto di interesse
     * @param nomeCentro il nome del centro di monitoraggio associato
     * @return il punto di interesse corrispondente
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized PuntoInteresse ottieniPaese(String nomePaese, String codice, String nomeCentro) throws RemoteException{
        return centriMonitoraggioDAO.ottieniPaeseDaCentro(nomePaese, codice, nomeCentro);
    }

    /**
     * Restituisce un elenco di tutti i centri di monitoraggio presenti nel sistema.
     * <p>
     * Questo metodo delega il recupero di tutti i centri di monitoraggio al DAO.
     * </p>
     *
     * @return un ArrayList contenente tutti i centri di monitoraggio
     * @throws RemoteException se si verifica un errore di comunicazione remota
     */
    @Override
    public synchronized ArrayList<CentroMonitoraggio> leggiCentri() throws RemoteException{
        return centriMonitoraggioDAO.leggiTuttiCentri();
    }

    /**
     * Verifica se un centro di monitoraggio è già presente nella tabella.
     *
     * @return {@code true} se il centro di monitoraggio non esiste, {@code false} se esiste.
     */
    @Override
    public boolean controllaEsistenzaCentro(String nomeCentro) throws RemoteException{
        return centriMonitoraggioDAO.esisteCentroMonitoraggio(nomeCentro);
    }
}