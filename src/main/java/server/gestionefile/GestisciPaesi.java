 package server.gestionefile;

import commons.oggetti.Paese;
import server.Database.ConnettoreDatabase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che utilizza una struttura dati per gestire,
 * per organizzare e salvare in un file tutti i paesi del mondo
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class GestisciPaesi{

    //FORMULA DI HAVERSINE
    public static double calcolaDistanza(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }
    
    private boolean isAscii(String str) {
        return str.chars().allMatch(c -> c < 128);
    }

    
    public ResultSet leggiPaesi(){
        ResultSet set = null;
        try {
            Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            
            String query = "SELECT * FROM coordinatemonitoraggio";
            PreparedStatement esegui = connessione.prepareStatement(query);
            set = esegui.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GestisciPaesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }
    
    public ResultSet ricercaNome(String scelta) {
        ResultSet set = null;
        Connection connessione = null;
        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
        } catch (SQLException e) {
            System.err.println("Impossibile connettersi al database");
        }

        if (connessione != null) {
            try {
                String query;
                if (isAscii(scelta)) {
                    query = "SELECT * FROM coordinatemonitoraggio WHERE UPPER(asciipaese) LIKE ?";
                } else {
                    query = "SELECT * FROM coordinatemonitoraggio WHERE (nomepaese) LIKE ?";
                }

                PreparedStatement esegui = connessione.prepareStatement(query);
                esegui.setString(1, "%" + scelta.toUpperCase() + "%");

                set = esegui.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(GestisciPaesi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return set;
    }
    
    public ResultSet ricercaStato(String scelta){
        ResultSet set = null;
        Connection connessione = null;

        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
        } catch (SQLException e) {
            System.err.println("Impossibile connettersi al database");
        }

        if(connessione!=null){
            try {
                String query = "SELECT * FROM coordinatemonitoraggio WHERE codicestato = ?";
                PreparedStatement esegui = connessione.prepareStatement(query);
                esegui.setString(1, scelta.toUpperCase());
                
                set = esegui.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(GestisciPaesi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return set;
    }
    
    public ResultSet ricercaCooPlus(double targetLatitudine, double targetLongitudine){
        ResultSet set = null;
        Connection connessione = null;

        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
        } catch (SQLException e) {
            System.err.println("Impossibile connettersi al database");
        }

        if(connessione!=null){
            try {
                
                String query = "SELECT *, (" +
                           "6371 * acos(" +
                           "cos(radians(?)) * cos(radians(latitudine)) * " +
                           "cos(radians(longitudine) - radians(?)) + " +
                           "sin(radians(?)) * sin(radians(latitudine))" +
                           ")) AS distanza " +
                           "FROM coordinatemonitoraggio " +
                           "ORDER BY distanza " +
                           "LIMIT 10";
                
                PreparedStatement esegui = connessione.prepareStatement(query);
                esegui.setDouble(1, targetLatitudine);
                esegui.setDouble(2, targetLongitudine);
                esegui.setDouble(3, targetLatitudine);
                
                set = esegui.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(GestisciPaesi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return set;
    }
    
    
    public Paese ricercaNomeCC(String scelta1, String scelta2){
        scelta2 = scelta2.toUpperCase();
        Connection connessione = null;
        try {
            ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
        } catch (SQLException e) {
            System.err.println("Impossibile connettersi al database");
        }
        ResultSet set = null;
        if(connessione!=null){
            try {
                String query = "SELECT * FROM coordinatemonitoraggio WHERE UPPER(asciipaese) = ? AND codicestato = ?";
                PreparedStatement esegui = connessione.prepareStatement(query);
                esegui.setString(1, scelta1.toUpperCase());
                esegui.setString(2, scelta2.toUpperCase());
                
                set = esegui.executeQuery();
                
                while(set.next()){
                    int geonameID = set.getInt("geonameid");
                    String name = set.getString("nomepaese");
                    String asname = set.getString("asciipaese");
                    String cc = set.getString("codicestato");
                    String cname = set.getString("nomestato");
                    double lat = set.getDouble("latitudine");
                    double lon = set.getDouble("longitudine");
                    
                    return new Paese(geonameID, name, asname, cc, cname, lat, lon);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestisciPaesi.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (set != null) {
                    try {
                        set.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(GestisciPaesi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return null;
    }
}
