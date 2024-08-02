/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.dao;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import java.util.ArrayList;

/**
 * Interfaccia {@code CentriMonitoraggioDAO} per l'accesso ai dati dei centri di monitoraggio e dei punti di interesse.
 * <p>
 * Questa interfaccia definisce i metodi per inserire, aggiornare e leggere i dati relativi ai centri di monitoraggio e ai
 * punti di interesse monitorati da questi centri. Include metodi per la gestione dei dati persistenti in un database.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface CentriMonitoraggioDAO {

    /**
     * Inserisce un nuovo centro di monitoraggio nel database.
     *
     * @param nuovoCentro il {@code CentroMonitoraggio} da inserire
     */
    void inserisciCentroMonitoraggio(CentroMonitoraggio nuovoCentro);

    /**
     * Inserisce un elenco di punti di interesse monitorati da un centro di monitoraggio specificato.
     *
     * @param nomeCentro il nome del centro di monitoraggio
     * @param elencoPuntiInteresse un array di {@code PuntoInteresse} da inserire
     */
    void inserisciPuntiInteresseMonitoratiDaCentro(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse);

    /**
     * Ottiene l'elenco dei punti di interesse monitorati da un centro di monitoraggio specificato.
     *
     * @param nomeCentro il nome del centro di monitoraggio
     * @return un {@code ArrayList} di {@code PuntoInteresse} monitorati dal centro specificato
     */
    ArrayList<PuntoInteresse> ottieniPuntiInteresseMonitoratiDaCentro(String nomeCentro);

    /**
     * Aggiorna il centro di monitoraggio associato a un operatore specificato.
     *
     * @param username il nome utente dell'operatore
     * @param nomeCentro il nome del nuovo centro di monitoraggio da associare
     */
    void aggiornaCentroMonitoraggioAssociatoOperatore(int username, String nomeCentro);

    /**
     * Ottiene un punto di interesse rappresentante un paese, dato il nome del paese, il codice e il nome del centro di monitoraggio.
     *
     * @param nomePaese il nome del paese
     * @param codice il codice del paese
     * @param nomeCentro il nome del centro di monitoraggio
     * @return il {@code PuntoInteresse} corrispondente, o {@code null} se non trovato
     */
    PuntoInteresse ottieniPaeseDaCentro(String nomePaese, String codice, String nomeCentro);

    /**
     * Legge tutti i centri di monitoraggio presenti nel database.
     *
     * @return un {@code ArrayList} di {@code CentroMonitoraggio} contenente tutti i centri
     */
    ArrayList<CentroMonitoraggio> leggiTuttiCentri();

    /**
     * Verifica se un centro di monitoraggio è già presente nella tabella.
     *
     * @return {@code true} se il centro di monitoraggio non esiste, {@code false} se esiste.
     */
    boolean esisteCentroMonitoraggio(String nomeCentro);
}