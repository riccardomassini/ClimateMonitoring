/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.servizio.ricercapoi;

import commons.oggetti.PuntoInteresse;
import commons.servizio.RicercaPuntiInteresse;
import server.database.servizio.ImplPuntiInteresseDAO;
import server.database.dao.PuntiInteresseDAO;

import java.rmi.RemoteException;
import java.util.TreeMap;

/**
 * La classe {@code RepositoryPuntiInteresse} implementa l'interfaccia {@code RicercaPuntiInteresse}
 * e fornisce metodi per la ricerca e recupero di punti di interesse.
 * <p>
 * Utilizza un'istanza di {@code PuntiInteresseDAO} per accedere ai dati dei punti di interesse
 * e implementa metodi per la ricerca per nome, nazione, coordinate e per combinazione di nome e nazione.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class RepositoryPuntiInteresse implements RicercaPuntiInteresse {

    /** L'oggetto DAO utilizzato per accedere ai dati dei punti di interesse. */
    private final PuntiInteresseDAO puntiInteresseDAO;

    /** Il numero massimo di punti di interesse restituiti dalla ricerca per coordinate. */
    private static final int PUNTI_INTERESSE_MAX_RICERCA_COORDINATE = 100;

    /**
     * Costruttore della classe {@code RepositoryPuntiInteresse}.
     * <p>
     * Inizializza l'istanza di {@code PuntiInteresseDAO} utilizzata per accedere ai dati dei punti di interesse.
     * </p>
     */
    public RepositoryPuntiInteresse() {
        this.puntiInteresseDAO = new ImplPuntiInteresseDAO();
    }

    /**
     * Recupera un elenco di tutti i punti di interesse disponibili.
     *
     * @return un array di {@code PuntoInteresse} contenente tutti i punti di interesse
     * @throws RemoteException se si verifica un errore durante l'accesso ai dati
     */
    @Override
    public synchronized PuntoInteresse[] ottieniElencoPuntiInteresse() throws RemoteException {
        return puntiInteresseDAO.ottieniElencoPuntiInteresse();
    }

    /**
     * Cerca i punti di interesse per nome.
     *
     * @param nome il nome del punto di interesse da cercare
     * @return un array di {@code PuntoInteresse} che corrispondono al nome specificato
     * @throws RemoteException se si verifica un errore durante l'accesso ai dati
     */
    @Override
    public synchronized PuntoInteresse[] ricercaPerNome(String nome) throws RemoteException {
        return puntiInteresseDAO.ottieniPuntiInteressePerNome(nome);
    }

    /**
     * Cerca i punti di interesse per codice nazione.
     *
     * @param codiceNazione il codice della nazione per cui cercare i punti di interesse
     * @return un array di {@code PuntoInteresse} che corrispondono al codice nazione specificato
     * @throws RemoteException se si verifica un errore durante l'accesso ai dati
     */
    @Override
    public synchronized PuntoInteresse[] ricercaPerNazione(String codiceNazione) throws RemoteException {
        return puntiInteresseDAO.ottieniPuntiInteressePerCodiceNazione(codiceNazione);
    }

    /**
     * Cerca i punti di interesse più vicini a una posizione specificata dalle coordinate.
     * <p>
     * Questa ricerca restituisce un array di punti di interesse ordinati per distanza dalla posizione specificata.
     * Il numero massimo di punti di interesse restituiti è definito da {@code PUNTI_INTERESSE_MAX_RICERCA_COORDINATE}.
     * </p>
     *
     * @param latitudine la latitudine della posizione di riferimento
     * @param longitudine la longitudine della posizione di riferimento
     * @return un array di {@code PuntoInteresse} contenente i punti di interesse più vicini alla posizione specificata
     * @throws RemoteException se si verifica un errore durante l'accesso ai dati
     */
    @Override
    public synchronized PuntoInteresse[] ricercaPerCoordinate(double latitudine, double longitudine) throws RemoteException {
        PuntoInteresse[] elencoPuntiInteresse = puntiInteresseDAO.ottieniElencoPuntiInteresse();
        TreeMap<Double, PuntoInteresse> distanze = new TreeMap<>();

        for(PuntoInteresse puntoInteresse : elencoPuntiInteresse)
            distanze.put(CalcoloHaversine.haversine(latitudine, longitudine, puntoInteresse.getLatitudine(), puntoInteresse.getLongitudine()),
                    puntoInteresse);

        elencoPuntiInteresse = new PuntoInteresse[PUNTI_INTERESSE_MAX_RICERCA_COORDINATE];
        for(int i = 0; i < PUNTI_INTERESSE_MAX_RICERCA_COORDINATE; i++)
            elencoPuntiInteresse[i] = distanze.pollFirstEntry().getValue();

        return elencoPuntiInteresse;
    }

    /**
     * Cerca un punto di interesse per nome e codice nazione.
     *
     * @param nomePuntoInteresse il nome del punto di interesse da cercare
     * @param codiceNazione il codice della nazione in cui cercare il punto di interesse
     * @return il {@code PuntoInteresse} che corrisponde al nome e codice nazione specificati,
     *         o {@code null} se non viene trovato alcun punto di interesse corrispondente
     * @throws RemoteException se si verifica un errore durante l'accesso ai dati
     */
     @Override
     public synchronized PuntoInteresse ricercaPerNomeENazione(String nomePuntoInteresse, String codiceNazione) throws RemoteException {
         return puntiInteresseDAO.ottieniPuntiInteressePerNomeECodiceNazione(nomePuntoInteresse, codiceNazione);
     }
}