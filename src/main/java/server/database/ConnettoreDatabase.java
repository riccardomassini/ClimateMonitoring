/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database;

import java.sql.*;

import static server.database.ImpostazioniDatabase.*;

/**
 * Classe che gestisce la connessione al database utilizzando il pattern Singleton.
 * <p>
 * Questa classe carica il driver JDBC per PostgreSQL e fornisce un metodo per ottenere una connessione al database.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ConnettoreDatabase {

    /**
     * Costruttore privato che carica il driver JDBC per PostgreSQL.
     * <p>
     * Il costruttore tenta di caricare la classe del driver JDBC specificata. Se il driver non può essere caricato,
     * viene stampato un messaggio di errore.
     * </p>
     */
    private ConnettoreDatabase() {
        try {
            Class.forName(DRIVER_JDBC);
        } catch (ClassNotFoundException e) {
            System.err.println("Impossibile caricare il driver di JDBC per PostgreSQL");
        }
    }

    /**
     * Classe interna statica che contiene l'istanza singleton del {@link ConnettoreDatabase}.
     */
    private static class contenitoreSingletonConnettoreDatabase {
        private static final ConnettoreDatabase singleton = new ConnettoreDatabase();
    }

    /**
     * Metodo statico per ottenere l'istanza singleton del {@link ConnettoreDatabase}.
     *
     * @return L'istanza singleton del {@link ConnettoreDatabase}.
     */
    public static ConnettoreDatabase ottieniConnettore() {
        return contenitoreSingletonConnettoreDatabase.singleton;
    }

    /**
     * Ottiene una connessione al database utilizzando le impostazioni di connessione specificate.
     * <p>
     * Questo metodo utilizza le variabili di connessione definite in {@link ImpostazioniDatabase}
     * per stabilire una connessione al database.
     * </p>
     *
     * @return Una connessione al database.
     * @throws SQLException Se si verifica un errore durante il tentativo di connessione al database.
     */
    public Connection ottieniConnessioneDatabase() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}