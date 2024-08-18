/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.dao;

import commons.oggetti.misurazioni.Misurazione;

/**
 * Interfaccia {@code MisurazioniDAO} per la gestione delle misurazioni nel database.
 * <p>
 * Questa interfaccia definisce i metodi per inserire e recuperare le misurazioni associate ai punti di interesse.
 * I metodi sono destinati a operare con i dati persistenti nel database.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface MisurazioniDAO {

    /**
     * Inserisce una nuova misurazione nel database.
     *
     * @param nuovaMisurazione l'oggetto {@code Misurazione} da inserire
     */
    void inserisciNuovaMisurazione(Misurazione nuovaMisurazione);

    /**
     * Ottiene le misurazioni associate a un punto di interesse specificato.
     *
     * @param idPuntoInteresse l'identificativo del punto di interesse per cui recuperare le misurazioni
     * @return un array di {@code Misurazione} contenente tutte le misurazioni per il punto di interesse specificato
     */
    Misurazione[] ottieniMisurazioniPuntoInteresse(int idPuntoInteresse);
}