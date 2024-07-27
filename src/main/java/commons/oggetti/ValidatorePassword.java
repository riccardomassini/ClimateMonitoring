package commons.oggetti;

import org.mindrot.jbcrypt.BCrypt;

public class ValidatorePassword {
    private static final int FATTORE_COSTO_HASH_BCRYPT = 15;

    public static String ottieniHashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(FATTORE_COSTO_HASH_BCRYPT));
    }

    public static boolean passwordCorretta(String hash, String password) {
        return BCrypt.checkpw(password, hash);
    }

}
