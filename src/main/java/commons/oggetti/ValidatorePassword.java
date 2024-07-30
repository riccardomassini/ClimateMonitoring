/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.oggetti;

import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Pattern;

/**
 * La classe {@code ValidatorePassword} fornisce metodi per validare le password in base a criteri specifici
 * e per gestire l'hashing delle password utilizzando l'algoritmo BCrypt.
 * <p>
 * La classe include metodi per verificare la lunghezza minima della password, la presenza di caratteri speciali,
 * lettere maiuscole, lettere minuscole e cifre. Inoltre, consente di generare hash BCrypt e verificarli.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ValidatorePassword {

    /**
     * Il fattore di costo per l'algoritmo BCrypt.
     */
    private static final int FATTORE_COSTO_HASH_BCRYPT = 15;

    /**
     * La lunghezza minima richiesta per una password.
     */
    public static final int LUNGHEZZA_MINIMA = 8;

    /**
     * Espressione regolare per identificare la presenza di caratteri speciali.
     */
    private static final String REGEX_CARATTERI_SPECIALI = "[!@#$%^&*()_+\\-=\\[\\]\\{\\};:'\"\\\\/|,.<>?]";

    /**
     * Espressione regolare per identificare la presenza di lettere maiuscole.
     */
    private static final String REGEX_LETTERE_MAIUSCOLE = ".*[A-Z].*";

    /**
     * Espressione regolare per identificare la presenza di lettere minuscole.
     */
    private static final String REGEX_LETTERE_MINUSCOLE = ".*[a-z].*";

    /**
     * Espressione regolare per identificare la presenza di cifre.
     */
    private static final String REGEX_CIFRE = ".*\\d.*";

    /**
     * Genera l'hash di una password utilizzando l'algoritmo BCrypt.
     *
     * @param password la password da hashare
     * @return l'hash della password
     */
    public static String ottieniHashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(FATTORE_COSTO_HASH_BCRYPT));
    }

    /**
     * Verifica se una password corrisponde a un hash BCrypt.
     *
     * @param hash     l'hash BCrypt della password
     * @param password la password da verificare
     * @return {@code true} se la password corrisponde all'hash, altrimenti {@code false}
     */
    public static boolean passwordHashCorretto(String hash, String password) {
        return BCrypt.checkpw(password, hash);
    }

    /**
     * Verifica se una password rispetta la lunghezza minima.
     *
     * @param password la password da verificare
     * @return {@code true} se la password rispetta la lunghezza minima, altrimenti {@code false}
     */
    public static boolean rispettaLunghezzaMinima(String password) {
        return password.length() >= LUNGHEZZA_MINIMA;
    }

    /**
     * Verifica se una password contiene almeno un carattere speciale.
     *
     * @param password la password da verificare
     * @return {@code true} se la password contiene almeno un carattere speciale, altrimenti {@code false}
     */
    public static boolean contieneCarattereSpeciale(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_CARATTERI_SPECIALI).matcher(password).find();
    }

    /**
     * Verifica se una password contiene almeno una cifra.
     *
     * @param password la password da verificare
     * @return {@code true} se la password contiene almeno una cifra, altrimenti {@code false}
     */
    public static boolean contieneCifra(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_CIFRE).matcher(password).find();
    }

    /**
     * Verifica se una password contiene almeno una lettera maiuscola.
     *
     * @param password la password da verificare
     * @return {@code true} se la password contiene almeno una lettera maiuscola, altrimenti {@code false}
     */
    public static boolean contieneLetteraMaiuscola(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_LETTERE_MAIUSCOLE).matcher(password).find();
    }

    /**
     * Verifica se una password contiene almeno una lettera minuscola.
     *
     * @param password la password da verificare
     * @return {@code true} se la password contiene almeno una lettera minuscola, altrimenti {@code false}
     */
    public static boolean contieneLetteraMinuscola(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_LETTERE_MINUSCOLE).matcher(password).find();
    }
}