package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/climate";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    private ConnessioneDB() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la connessione al database", e);
        }
    }

    // Metodo pubblico per ottenere l'istanza della connessione
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (ConnessioneDB.class) {
                if (connection == null) {
                    new ConnessioneDB();
                }
            }
        }
        return connection;
    }
}