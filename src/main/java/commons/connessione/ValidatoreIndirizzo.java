/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.connessione;

import java.util.regex.Pattern;

/**
 * <p>La classe {@code ValidatoreIndirizzo} fornisce metodi statici per la validazione degli indirizzi IP e delle porte.
 * In particolare, verifica se un indirizzo IP è conforme al formato IPv4 e se una porta è compresa all'interno
 * dell'intervallo valido per le porte TCP/UDP.</p>
 *
 * <p>La classe utilizza espressioni regolari per la validazione dell'indirizzo IP e valori predefiniti per l'intervallo
 * delle porte.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ValidatoreIndirizzo {

    /** Costruttore vuoto */
    public ValidatoreIndirizzo(){}

    /**
     * Espressione regolare per il controllo di un indirizzo IPv4.
     * La regex verifica che l'indirizzo IP sia nel formato corretto di IPv4.
     */
    private static String REGEX_IPv4 = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

    /**
     * Il valore minimo valido per una porta TCP/UDP.
     */
    private static int PORTA_MIN = 0;

    /**
     * Il valore massimo valido per una porta TCP/UDP.
     */
    private static int PORTA_MAX = 65535;

    /**
     * Verifica se l'indirizzo IP fornito è valido secondo il formato IPv4.
     *
     * <p>Questo metodo utilizza un'espressione regolare per controllare se l'indirizzo IP
     * è ben formato secondo lo standard IPv4. Restituisce {@code true} se l'indirizzo IP è valido,
     * altrimenti {@code false}.</p>
     *
     * @param indirizzo l'indirizzo IP da verificare. Può essere {@code null}, nel qual caso il metodo
     *                  restituirà {@code false}.
     * @return {@code true} se l'indirizzo IP è valido, {@code false} altrimenti.
     */
    public static boolean indirizzoIpValido(String indirizzo) {
        if (indirizzo == null)
            return false;
        return Pattern.compile(REGEX_IPv4).matcher(indirizzo).matches();
    }

    /**
     * Verifica se il numero di porta fornito è valido.
     *
     * <p>Questo metodo verifica che il numero di porta sia compreso tra {@code PORTA_MIN} e {@code PORTA_MAX},
     * inclusi. Restituisce {@code true} se la porta è valida, altrimenti {@code false}.</p>
     *
     * @param porta il numero di porta da verificare.
     * @return {@code true} se la porta è valida, {@code false} altrimenti.
     */
    public static boolean portaValida(int porta) {
        return porta >= PORTA_MIN & porta <= PORTA_MAX;
    }
}