package server.serverrmi;

import commons.oggetti.ValidatorePassword;

class ImpostazioniServer {
    private static String USERNAME = "";
    private static String PASSWORD = "";

    static void impostaUsername(String username) {
        USERNAME = username;
    }

    static void impostaPassword(String password) {
        PASSWORD = ValidatorePassword.ottieniHashPassword(password);
    }

    static void impostaCredenziali(String username, String password) {
        impostaUsername(username);
        impostaPassword(password);
    }

    static String ottieniUsername() {
        return USERNAME;
    }

    static String ottieniPassword() {
        return PASSWORD;
    }

    static boolean controlloCredenziali(String username, String password) {
        return ottieniUsername().equals(username) && ValidatorePassword.passwordCorretta(ottieniPassword(), password);
    }



}
