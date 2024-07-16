package gestionefile;

import Database.*;
import oggetti.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che utilizza una struttura dati di tipo CentroMonitoraggio per gestire,
 * per organizzare e salvare in un file tutti i parametri inseriti dall'utente
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class GestisciCentri {
    
    /**
     * Costruttore che scrive e crea il file se non esiste
     */
    public GestisciCentri(){}
    
    
    public void registraCentroAree(CentroMonitoraggio centro, ArrayList<Paese> aree){
        Connection connessione = null;
        try {
            connessione = ConnessioneDB.getConnection();
            
            String query1 = "INSERT INTO CentriMonitoraggio(nomeCentro, indirizzo, numerocivico, cap, comune, provincia) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement esegui1 = connessione.prepareStatement(query1);
            esegui1.setString(1, centro.getNome());
            esegui1.setString(2, centro.getIndirizzo());
            esegui1.setInt(3, centro.getNumCivico());
            esegui1.setString(4, centro.getCap());
            esegui1.setString(5, centro.getComune());
            esegui1.setString(6, centro.getProvincia());
            esegui1.executeUpdate();
            
            for(Paese p: aree){
                String query2 = "INSERT INTO areemonitoratedacentri(centro, geonameid) VALUES (?, ?)";
                PreparedStatement esegui2 = connessione.prepareStatement(query2);
                esegui2.setString(1, centro.getNome());
                esegui2.setInt(2, p.getGeonameID());
                esegui2.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestisciCentri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Paese trovaArea(String nomeP, String code, String centroOp){
        ResultSet set = null;
        Paese paese = null;
        code = code.toUpperCase();
        String areeArray;
        StringTokenizer token = null;
        
        try {
            Connection connessione = ConnessioneDB.getConnection();
            
            String query = "SELECT coordinateMonitoraggio.* " +
                           "FROM areeMonitorateDaCentri NATURAL JOIN coordinateMonitoraggio " +
                           "WHERE areeMonitorateDaCentri.centro = ? AND UPPER(coordinateMonitoraggio.asciipaese) = ? AND coordinateMonitoraggio.codicestato = ?";

            PreparedStatement esegui = connessione.prepareStatement(query);
            esegui.setString(1, centroOp);
            esegui.setString(2, nomeP.toUpperCase());
            esegui.setString(3, code.toUpperCase());
            set = esegui.executeQuery();
            
            while(set.next()){
                int geonameID = set.getInt("geonameid");
                String name = set.getString("nomepaese");
                String asname = set.getString("asciipaese");
                String cc = set.getString("codicestato");
                String cname = set.getString("nomestato");
                double lat = set.getDouble("latitudine");
                double lon = set.getDouble("longitudine");

                paese = new Paese(geonameID, name, asname, cc, cname, lat, lon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestisciCentri.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return paese;
    }

    public boolean centroEsistente(String nomeCentro) {
        Connection connessione = null;
        ResultSet resultSet = null;
        boolean esiste = false;

        try {
            connessione = ConnessioneDB.getConnection();

            String query = "SELECT 1 FROM CentriMonitoraggio WHERE nomeCentro = ?";
            PreparedStatement esegui = connessione.prepareStatement(query);
            esegui.setString(1, nomeCentro);
            resultSet = esegui.executeQuery();

            if (resultSet.next()) {
                esiste = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestisciCentri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return esiste;
    }
    
    /**
     * Metodo controlla se il cap inserito dall'utente è valido
     * @param cap cap del paese/città del nostro centro di monitoraggio
     * @return un valore boolean, true se il cap è valido, false altrimenti
     */
    public boolean controlloCap(String cap){
        if(cap.length() != 5)
            return false;
        
        for(int i=0; i<cap.length(); i++){
            Character c = cap.charAt(i);
            if(c<48 || c>57)
                return false;
        }
        return true;
    }
}
