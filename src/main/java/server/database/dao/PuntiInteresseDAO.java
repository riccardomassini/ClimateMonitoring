/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.dao;

import commons.oggetti.PuntoInteresse;

/**
 * Interfaccia {@code PuntiInteresseDAO} per la gestione dei punti di interesse nel database.
 * <p>
 * Questa interfaccia definisce i metodi per recuperare informazioni sui punti di interesse dal database.
 * I metodi sono destinati a fornire accesso ai dati sui punti di interesse memorizzati nel database.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface PuntiInteresseDAO {

    /**
     * Recupera l'elenco di tutti i punti di interesse memorizzati nel database.
     *
     * @return un array di oggetti {@code PuntoInteresse} che rappresentano tutti i punti di interesse
     */
    PuntoInteresse[] ottieniElencoPuntiInteresse();

    /**
     * Recupera i punti di interesse che corrispondono al nome specificato.
     *
     * @param nome il nome del punto di interesse da cercare
     * @return un array di oggetti {@code PuntoInteresse} che corrispondono al nome specificato,
     *         o un array vuoto se nessun punto di interesse corrisponde
     */
    PuntoInteresse[] ottieniPuntiInteressePerNome(String nome);

    /**
     * Recupera i punti di interesse che corrispondono al codice nazione specificato.
     *
     * @param codiceNazione il codice della nazione dei punti di interesse da cercare
     * @return un array di oggetti {@code PuntoInteresse} che corrispondono al codice nazione specificato,
     *         o un array vuoto se nessun punto di interesse corrisponde
     */
    PuntoInteresse[] ottieniPuntiInteressePerCodiceNazione(String codiceNazione);

    /**
     * Recupera un punto di interesse che corrisponde sia al nome che al codice nazione specificati.
     *
     * @param nomePuntoInteresse il nome del punto di interesse da cercare
     * @param codiceNazione il codice della nazione del punto di interesse da cercare
     * @return un oggetto {@code PuntoInteresse} che corrisponde ai criteri specificati,
     *         oppure {@code null} se nessun punto di interesse corrisponde
     */
    PuntoInteresse ottieniPuntiInteressePerNomeECodiceNazione(String nomePuntoInteresse, String codiceNazione);
}