/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.database;

import java.sql.*;

/**
 * Questa classe fornisce connessioni con il database
 */
public class ConnettoreDatabase {
    private static final int PORTA_DEFAULT_POSTGRESQL = 5432;
    private static final String DRIVER_JDBC = "org.postgresql.Driver";
    private static final String NOME_DATABASE = "climate";
    private static final String URL = "jdbc:postgresql://localhost:" + PORTA_DEFAULT_POSTGRESQL + "/" + NOME_DATABASE;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

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