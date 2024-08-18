/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.dao;

import commons.oggetti.Operatore;

/**
 * Interfaccia {@code OperatoriDAO} per la gestione degli operatori nel database.
 * <p>
 * Questa interfaccia definisce i metodi per inserire e recuperare le informazioni sugli operatori nel database.
 * I metodi sono destinati a operare con i dati persistenti nel database.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface OperatoriDAO {

    /**
     * Inserisce un nuovo operatore nel database.
     *
     * @param nuovoOperatore l'oggetto {@code Operatore} da inserire
     * @return {@code true} se l'inserimento è avvenuto con successo, {@code false} altrimenti
     */
    boolean inserisciNuovoOperatore(Operatore nuovoOperatore);

    /**
     * Recupera un operatore dal database utilizzando il nome utente.
     *
     * @param username l'identificativo dell'operatore (username) per recuperare l'oggetto {@code Operatore}
     * @return l'oggetto {@code Operatore} associato all'username specificato, oppure {@code null} se non esiste
     */
    Operatore ottieniOperatoreDaUsername(int username);
}