package commons.oggetti;

import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Pattern;

public class ValidatorePassword {
    private static final int FATTORE_COSTO_HASH_BCRYPT = 15;
    public static final int LUNGHEZZA_MINIMA = 8;
    public static final char[] caratteriSpecialiAmmessi = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=', '[', ']', '{', '}', ';', ':', '\'', '\"', '\\', '|', ',', '.', '<', '>', '/', '?'};
    private static final String caratteriSpecialiConEscape = "\\.^$|()[]*+?{}";
    private static final String REGEX_LETTERE_MAIUSCOLE = ".*[A-Z].*";
    private static final String REGEX_LETTERE_MINUSCOLE = ".*[a-z].*";
    private static final String REGEX_CIFRE = ".*\\d.*";

    public static String ottieniHashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(FATTORE_COSTO_HASH_BCRYPT));
    }

    public static boolean passwordHashCorretto(String hash, String password) {
        return BCrypt.checkpw(password, hash);
    }

    private static String costruttoreRegexCaratteriSpeciali() {
        StringBuilder regex = new StringBuilder("[");
        for (char c : caratteriSpecialiAmmessi) {
            if (caratteriSpecialiConEscape.indexOf(c) != -1)
                regex.append("\\");
            regex.append(c);
        }
        regex.append("]");
        return regex.toString();
    }

    public static boolean rispettaLunghezzaMinima(String password) {
        return password.length() >= LUNGHEZZA_MINIMA;
    }

    public static boolean contieneCarattereSpeciale(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(costruttoreRegexCaratteriSpeciali()).matcher(password).find();
    }

    public static boolean contieneCifra(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_CIFRE).matcher(password).find();
    }

    public static boolean contieneLetteraMaiuscola(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_LETTERE_MAIUSCOLE).matcher(password).find();
    }

    public static boolean contieneLetteraMinuscola(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_LETTERE_MINUSCOLE).matcher(password).find();
    }

    public static boolean formatValido(String password) {
        return contieneCifra(password) && contieneLetteraMaiuscola(password) && contieneLetteraMinuscola(password);
    }

}
