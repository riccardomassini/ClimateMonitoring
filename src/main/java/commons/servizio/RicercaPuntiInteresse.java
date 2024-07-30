/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.servizio;

import commons.oggetti.PuntoInteresse;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaccia {@code RicercaPuntiInteresse} per la ricerca e ottenimento di punti di interesse.
 * <p>
 * Questa interfaccia definisce i metodi per ottenere un elenco di punti di interesse e per cercare punti di
 * interesse basati su diversi criteri, come nome, nazione e coordinate.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface RicercaPuntiInteresse extends Remote {

    /**
     * Ottiene un elenco di tutti i punti di interesse disponibili.
     *
     * @return un array di {@code PuntoInteresse} contenente tutti i punti di interesse
     * @throws RemoteException se si verifica un errore di comunicazione durante il recupero dei punti di interesse
     */
    PuntoInteresse[] ottieniElencoPuntiInteresse() throws RemoteException;

    /**
     * Cerca i punti di interesse per nome.
     *
     * @param nome il nome del punto di interesse da cercare
     * @return un array di {@code PuntoInteresse} che corrispondono al nome specificato
     * @throws RemoteException se si verifica un errore di comunicazione durante la ricerca
     */
    PuntoInteresse[] ricercaPerNome(String nome) throws RemoteException;

    /**
     * Cerca i punti di interesse per codice nazione.
     *
     * @param codiceNazione il codice della nazione per cui cercare i punti di interesse
     * @return un array di {@code PuntoInteresse} che appartengono alla nazione specificata
     * @throws RemoteException se si verifica un errore di comunicazione durante la ricerca
     */
    PuntoInteresse[] ricercaPerNazione(String codiceNazione) throws RemoteException;

    /**
     * Cerca i punti di interesse per coordinate geografiche.
     *
     * @param latitudine la latitudine del punto di interesse da cercare
     * @param longitudine la longitudine del punto di interesse da cercare
     * @return un array di {@code PuntoInteresse} che si trovano nelle coordinate specificate
     * @throws RemoteException se si verifica un errore di comunicazione durante la ricerca
     */
    PuntoInteresse[] ricercaPerCoordinate(double latitudine, double longitudine) throws RemoteException;

    /**
     * Cerca un punto di interesse per nome e codice nazione.
     *
     * @param nomePuntoInteresse il nome del punto di interesse da cercare
     * @param codiceNazione il codice della nazione del punto di interesse
     * @return il {@code PuntoInteresse} che corrisponde ai criteri di ricerca, o {@code null} se non viene trovato
     * @throws RemoteException se si verifica un errore di comunicazione durante la ricerca
     */
    PuntoInteresse ricercaPerNomeENazione(String nomePuntoInteresse, String codiceNazione) throws RemoteException;
}