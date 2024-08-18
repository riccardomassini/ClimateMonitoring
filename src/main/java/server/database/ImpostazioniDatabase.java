/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database;

/**
 * Classe che contiene le impostazioni di configurazione per la connessione al database PostgreSQL.
 * <p>
 * Questa classe definisce costanti che rappresentano le impostazioni necessarie per stabilire una connessione
 * al database, inclusi il driver JDBC, l'URL del database, il nome utente e la password.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
class ImpostazioniDatabase {

    /**
     * La porta predefinita per il server PostgreSQL.
     */
    static final int PORTA_DEFAULT_POSTGRESQL = 5432;

    /**
     * Il nome completo della classe del driver JDBC per PostgreSQL.
     */
    static final String DRIVER_JDBC = "org.postgresql.Driver";

    /**
     * Il nome del database al quale connettersi.
     */
    static final String NOME_DATABASE = "climatemonitoring";

    /**
     * L'URL di connessione al database, comprensivo della porta e del nome del database.
     * <p>
     * L'URL segue il formato JDBC standard per PostgreSQL e include la porta di default e il nome del database.
     * </p>
     */
    static final String URL = "jdbc:postgresql://localhost:" + PORTA_DEFAULT_POSTGRESQL + "/" + NOME_DATABASE;

    /**
     * Il nome utente utilizzato per l'autenticazione al database.
     */
    static final String USERNAME = "postgres";

    /**
     * La password utilizzata per l'autenticazione al database.
     */
    static final String PASSWORD = "root";
}