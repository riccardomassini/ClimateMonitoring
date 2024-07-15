package server.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InserisciCSV {

    public static boolean isTableEmpty(String nomeTabella) {
        boolean isEmpty = true;
        String sql = "SELECT COUNT(*) FROM " + nomeTabella;

        try (Connection conn = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                isEmpty = rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il controllo della tabella: " + e.getMessage());
        }

        return isEmpty;
    }

    public static void inserisciDaCSV(String nomeTabella, String filePath) {
        if (!isTableEmpty(nomeTabella)) {
            return;
        }

        String csvFile = filePath;
        String line;
        String cvsSplitBy = ",";

        try (Connection conn = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line = br.readLine();
            String[] colonne = line.split(cvsSplitBy);

            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("INSERT INTO ").append(nomeTabella).append(" (");
            for (int i = 0; i < colonne.length; i++) {
                sqlBuilder.append(colonne[i]);
                if (i < colonne.length - 1) {
                    sqlBuilder.append(", ");
                }
            }
            sqlBuilder.append(") VALUES (");
            for (int i = 0; i < colonne.length; i++) {
                sqlBuilder.append("?");
                if (i < colonne.length - 1) {
                    sqlBuilder.append(", ");
                }
            }
            sqlBuilder.append(")");
            String sql = sqlBuilder.toString();

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                while ((line = br.readLine()) != null) {
                    String[] valori = line.split(cvsSplitBy);

                    stmt.setInt(1, Integer.parseInt(valori[0]));

                    int length = valori.length;

                    switch (length) {
                        case 7:
                            stmt.setString(2, valori[1]);
                            stmt.setString(3, valori[2]);
                            stmt.setString(4, valori[3]);
                            stmt.setString(5, valori[4]);
                            stmt.setDouble(6, Double.parseDouble(valori[5]));
                            stmt.setDouble(7, Double.parseDouble(valori[6]));
                            break;
                        case 8:
                            stmt.setString(2, valori[1]);
                            stmt.setString(3, valori[2]);
                            stmt.setString(4, valori[3]);
                            stmt.setString(5, valori[4] + " " + valori[5]);
                            stmt.setDouble(6, Double.parseDouble(valori[6]));
                            stmt.setDouble(7, Double.parseDouble(valori[7]));
                            break;
                        case 9:
                            stmt.setString(2, valori[1] + valori[2]);
                            stmt.setString(3, valori[3] + valori[4]);
                            stmt.setString(4, valori[5]);
                            stmt.setString(5, valori[6]);
                            stmt.setDouble(6, Double.parseDouble(valori[7]));
                            stmt.setDouble(7, Double.parseDouble(valori[8]));
                            break;
                        case 11:
                            stmt.setString(2, valori[1] + valori[2] + valori[3]);
                            stmt.setString(3, valori[4] + valori[5] + valori[6]);
                            stmt.setString(4, valori[7]);
                            stmt.setString(5, valori[8]);
                            stmt.setDouble(6, Double.parseDouble(valori[9]));
                            stmt.setDouble(7, Double.parseDouble(valori[10]));
                            break;
                        default:
                            throw new IllegalArgumentException("Unexpected array length: " + length);
                    }

                    stmt.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
