/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.serverrmi;

import commons.oggetti.ValidatorePassword;

/**
 * La classe {@code ImpostazioniServer} gestisce le credenziali del server,
 * inclusi username e password.
 * <p>
 * La password è memorizzata come un hash per motivi di sicurezza.
 * La classe fornisce metodi per impostare, ottenere e verificare le credenziali.
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
class ImpostazioniServer {

    /** Lo username per l'accesso al server. */
    private static String USERNAME;

    /** La password hashata per l'accesso al server. */
    private static String PASSWORD;

    /**
     * Imposta lo username per l'accesso al server.
     *
     * @param username lo username da impostare
     */
    static void impostaUsername(String username) {
        USERNAME = username;
    }

    /**
     * Imposta la password per l'accesso al server.
     * <p>
     * La password è hashata prima di essere memorizzata utilizzando il metodo
     * {@link ValidatorePassword#ottieniHashPassword(String)}.
     *
     * @param password la password in chiaro da impostare
     */
    static void impostaPassword(String password) {
        PASSWORD = ValidatorePassword.ottieniHashPassword(password);
    }

    /**
     * Imposta sia lo username che la password per l'accesso al server.
     *
     * @param username lo username da impostare
     * @param password la password in chiaro da impostare, che verrà hashata
     */
    static void impostaCredenziali(String username, String password) {
        impostaUsername(username);
        impostaPassword(password);
    }

    /**
     * Restituisce lo username attualmente impostato.
     *
     * @return lo username impostato
     */
    static String ottieniUsername() {
        return USERNAME;
    }

    /**
     * Restituisce la password hashata attualmente impostata.
     *
     * @return la password hashata impostata
     */
    static String ottieniPassword() {
        return PASSWORD;
    }

    /**
     * Controlla se le credenziali fornite corrispondono a quelle memorizzate.
     * <p>
     * Verifica sia lo username che la password hashata.
     *
     * @param username lo username da verificare
     * @param password la password in chiaro da verificare
     * @return {@code true} se le credenziali corrispondono, altrimenti {@code false}
     */
    static boolean controlloCredenziali(String username, String password) {
        return ottieniUsername().equals(username) && ValidatorePassword.passwordHashCorretto(ottieniPassword(), password);
    }
}