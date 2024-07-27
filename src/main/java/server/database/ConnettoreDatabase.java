/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.database;

import java.sql.*;

import static server.database.ImpostazioniDatabase.*;

/**
 * Questa classe fornisce connessioni con il database
 */
public class ConnettoreDatabase {

    private ConnettoreDatabase() {
        try {
            Class.forName(DRIVER_JDBC);
        } catch (ClassNotFoundException e) {
            System.err.println("Impossibile caricare il driver di JDBC per PostgreSQL");
        }
    }

    private static class contenitoreSingletonConnettoreDatabase {
        private static final ConnettoreDatabase singleton = new ConnettoreDatabase();
    }

    public static ConnettoreDatabase ottieniConnettore() {
        return contenitoreSingletonConnettoreDatabase.singleton;
    }

    public Connection ottieniConnessioneDatabase() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}