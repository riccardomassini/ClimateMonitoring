/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.servizio.autenticazione;

import commons.oggetti.Operatore;

/**
 * La classe Sessione gestisce lo stato della sessione corrente, mantenendo traccia
 * dell'operatore autenticato nel sistema.
 * <p>
 * Questa classe segue il pattern Singleton per garantire che esista solo una
 * singola istanza di Sessione durante l'esecuzione dell'applicazione.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Sessione {

    /** L'operatore attualmente autenticato nella sessione. */
    private Operatore operatore;

    /**
     * Costruttore privato per la classe Sessione.
     * <p>
     * Viene utilizzato solo internamente dalla classe per inizializzare la sessione con un
     * operatore specifico o con null.
     * </p>
     *
     * @param operatore l'operatore autenticato da memorizzare nella sessione
     */
    private Sessione(Operatore operatore) {
        this.operatore = operatore;
    }

    /**
     * Classe statica interna per gestire l'istanza Singleton di Sessione.
     * <p>
     * Questa classe è caricata solo quando è necessario, garantendo il lazy initialization
     * del Singleton.
     * </p>
     */
    private static class contenitoreSingletonSessione {

        /** L'istanza Singleton di Sessione, inizializzata con operatore null. */
        private static final Sessione singleton = new Sessione(null);
    }

    /**
     * Restituisce l'istanza Singleton della classe Sessione.
     * <p>
     * Questo metodo garantisce che vi sia solo una singola istanza di Sessione
     * durante l'intero ciclo di vita dell'applicazione.
     * </p>
     *
     * @return l'istanza Singleton della classe Sessione
     */
    public static Sessione ottieniSessione() {
        return Sessione.contenitoreSingletonSessione.singleton;
    }

    /**
     * Imposta l'operatore autenticato nella sessione.
     * <p>
     * Questo metodo aggiorna l'operatore attualmente memorizzato nella sessione.
     * </p>
     *
     * @param operatore l'operatore da impostare come autenticato nella sessione
     */
    public void setOperatore(Operatore operatore) {
        this.operatore = operatore;
    }

    /**
     * Restituisce l'operatore attualmente autenticato nella sessione.
     * <p>
     * Se nessun operatore è autenticato, il metodo restituisce null.
     * </p>
     *
     * @return l'operatore autenticato nella sessione, o null se nessuno è autenticato
     */
    public Operatore getOperatore() {
        return operatore;
    }
}