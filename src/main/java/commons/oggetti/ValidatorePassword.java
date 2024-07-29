package commons.oggetti;

import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Pattern;

public class ValidatorePassword {
    private static final int FATTORE_COSTO_HASH_BCRYPT = 15;
    public static final int LUNGHEZZA_MINIMA = 8;
    private static final String REGEX_CARATTERI_SPECIALI = "[!@#$%^&*()_+\\-=\\[\\]\\{\\};:'\"\\\\/|,.<>?]";
    private static final String REGEX_LETTERE_MAIUSCOLE = ".*[A-Z].*";
    private static final String REGEX_LETTERE_MINUSCOLE = ".*[a-z].*";
    private static final String REGEX_CIFRE = ".*\\d.*";

    public static String ottieniHashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(FATTORE_COSTO_HASH_BCRYPT));
    }

    public static boolean passwordHashCorretto(String hash, String password) {
        return BCrypt.checkpw(password, hash);
    }


    public static boolean rispettaLunghezzaMinima(String password) {
        return password.length() >= LUNGHEZZA_MINIMA;
    }

    public static boolean contieneCarattereSpeciale(String password) {
        if (password == null || password.isEmpty())
            return false;
        return Pattern.compile(REGEX_CARATTERI_SPECIALI).matcher(password).find();
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

}