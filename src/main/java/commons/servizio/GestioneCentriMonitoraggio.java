/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.servizio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Interfaccia {@code GestioneCentriMonitoraggio} per la gestione dei centri di monitoraggio e dei punti di interesse.
 * <p>
 * Questa interfaccia definisce i metodi per registrare centri di monitoraggio, associare punti di interesse a centri,
 * ottenere informazioni sui punti di interesse associati a centri, e associare centri di monitoraggio agli operatori.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface GestioneCentriMonitoraggio extends Remote {

    /**
     * Registra un nuovo centro di monitoraggio nel sistema.
     *
     * @param nuovoCentro il centro di monitoraggio da registrare.
     * @throws RemoteException se si verifica un errore di comunicazione durante la registrazione.
     */
    void registraCentroMonitoraggio(CentroMonitoraggio nuovoCentro) throws RemoteException;

    /**
     * Associa un elenco di punti di interesse a un centro di monitoraggio esistente.
     *
     * @param nomeCentro il nome del centro di monitoraggio a cui è associato il punto di interesse.
     * @param elencoPuntiInteresse l'array di punti di interesse da associare.
     * @throws RemoteException se si verifica un errore di comunicazione durante l'associazione.
     */
    void associaPuntiInteresseCentroMonitoraggio(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse) throws RemoteException;

    /**
     * Ottiene l'elenco dei punti di interesse associati a un centro di monitoraggio.
     *
     * @param nomeCentro il nome del centro di monitoraggio per cui ottenere i punti di interesse associati.
     * @return un {@code ArrayList} di {@code PuntoInteresse} associati al centro di monitoraggio.
     * @throws RemoteException se si verifica un errore di comunicazione durante il recupero dei dati.
     */
    ArrayList<PuntoInteresse> ottieniAreeAssociate(String nomeCentro) throws RemoteException;

    /**
     * Associa un centro di monitoraggio a un operatore specifico.
     *
     * @param usernameOperatore il nome utente dell'operatore a cui associare il centro di monitoraggio.
     * @param nomeNuovoCentro il nome del centro di monitoraggio da associare all'operatore.
     * @throws RemoteException se si verifica un errore di comunicazione durante l'associazione.
     */
    void associaCentroMonitoraggioOperatore(int usernameOperatore, String nomeNuovoCentro) throws RemoteException;

    /**
     * Ottiene un punto di interesse specifico, identificato da nome, codice e nome del centro.
     *
     * @param nomePaese il nome del paese del punto di interesse.
     * @param codice il codice identificativo del punto di interesse.
     * @param nomeCentro il nome del centro di monitoraggio a cui è associato il punto di interesse.
     * @return il {@code PuntoInteresse} corrispondente ai parametri forniti.
     * @throws RemoteException se si verifica un errore di comunicazione durante il recupero del punto di interesse.
     */
    PuntoInteresse ottieniPaese(String nomePaese, String codice, String nomeCentro) throws RemoteException;

    /**
     * Legge e restituisce l'elenco di tutti i centri di monitoraggio registrati.
     *
     * @return un {@code ArrayList} di {@code CentroMonitoraggio} contenente tutti i centri di monitoraggio.
     * @throws RemoteException se si verifica un errore di comunicazione durante la lettura dei dati.
     */
    ArrayList<CentroMonitoraggio> leggiCentri() throws RemoteException;

    /**
     * Verifica se un centro di monitoraggio è già presente nella tabella.
     *
     * @param nomeCentro il nome del centro di monitoraggio a cui è associato il punto di interesse
     * @return {@code true} se il centro di monitoraggio non esiste, {@code false} se esiste.
     * @throws RemoteException se si verifica un errore di comunicazione durante il controllo dell'esistenza di un centro di monitoraggio.
     */
    boolean controllaEsistenzaCentro(String nomeCentro) throws RemoteException;
}