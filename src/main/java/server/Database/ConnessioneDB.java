/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.Database;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnessioneDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/climate";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Errore durante la connessione al database PostgreSQL: " + e.getMessage());
        }
        return connection;
    }


}