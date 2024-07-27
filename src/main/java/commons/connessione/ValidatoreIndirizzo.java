package commons.connessione;

import java.util.regex.Pattern;

public class ValidatoreIndirizzo {
    private static String REGEX_IPv4 = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
    private static int PORTA_MIN = 0;
    private static int PORTA_MAX = 65535;

    public static boolean indirizzoIpValido(String indirizzo) {
        if (indirizzo == null)
            return false;
        return Pattern.compile(REGEX_IPv4).matcher(indirizzo).matches();
    }

    public static boolean portaValida(int porta) {
        return porta >= PORTA_MIN & porta <= PORTA_MAX;
    }

}
