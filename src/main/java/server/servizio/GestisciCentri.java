package server.servizio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.OperatoriClimatici;
import commons.oggetti.PuntoInteresse;
import server.database.ConnettoreDatabase;
import server.servizio.ricercapoi.RepositoryPuntiInteresse;

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
    
    //TODO rmi
    public void registraCentroMonitoraggio(CentroMonitoraggio centro, ArrayList<PuntoInteresse> aree){
        Connection connessione = null;
        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            
            String query1 = "INSERT INTO CentriMonitoraggio(nomeCentro, indirizzo, numerocivico, cap, comune, provincia) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement esegui1 = connessione.prepareStatement(query1);
            esegui1.setString(1, centro.getNome());
            esegui1.setString(2, centro.getIndirizzo());
            esegui1.setInt(3, centro.getNumCivico());
            esegui1.setString(4, centro.getCap());
            esegui1.setString(5, centro.getComune());
            esegui1.setString(6, centro.getProvincia());
            esegui1.executeUpdate();
            
            for(PuntoInteresse p: aree){
                String query2 = "INSERT INTO areemonitoratedacentri(centro, geonameid) VALUES (?, ?)";
                PreparedStatement esegui2 = connessione.prepareStatement(query2);
                esegui2.setString(1, centro.getNome());
                esegui2.setInt(2, p.getIdPuntoInteresse());
                esegui2.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestisciCentri.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (connessione != null) {
                    connessione.close(); // Chiusura della connessione nel blocco finally
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO rmi
    public PuntoInteresse trovaAreaAssociata(String nomeP, String code, String centroOp){
        ResultSet set = null;
        PuntoInteresse paese = null;
        code = code.toUpperCase();
        String areeArray;
        StringTokenizer token = null;
        
        try {
            Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            
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

                paese = new PuntoInteresse(geonameID, name, asname, cc, cname, lat, lon);
            }
            
            /*try{
                while(set.next()){
                    areeArray = set.getString("areeDiInteresse");
                    areeArray = areeArray.substring(2, areeArray.length());
                    token = new StringTokenizer(areeArray, "\",\"");

                    while(token.hasMoreTokens()){
                        String asname = token.nextToken();
                        String cc = token.nextToken();    
                        double lat = Double.parseDouble(token.nextToken());
                        double lon = Double.parseDouble(token.nextToken());
                        if(asname.equals(nomeP) && cc.equals(code)){
                            //paese = new Paese(asname, cc, lat, lon);
                            break;
                        }
                    }   
                }
            }catch(NoSuchElementException e){
                System.err.println("Quest'area non esiste nel centro \n");
            }*/
            
        } catch (SQLException ex) {
            Logger.getLogger(GestisciCentri.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return paese;
    }

    //TODO rmi
    public void associaCentroMonitoraggio(OperatoriClimatici operatore, String nuovoCentro) throws SQLException {
        Connection connessione = null;
        PreparedStatement esegui = null;

        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            String query = "UPDATE OperatoriRegistrati SET centro = ? WHERE userid = ?";
            esegui = connessione.prepareStatement(query);
            esegui.setString(1, nuovoCentro);
            esegui.setInt(2, operatore.getUserID());
            esegui.executeUpdate();
        } finally {
            // Chiudi le risorse in modo sicuro
            if (esegui != null) {
                esegui.close();
            }
            if (connessione != null) {
                connessione.close();
            }
        }
    }

    //TODO rmi
    public boolean centroMonitoraggioAssociato(OperatoriClimatici operatore) throws SQLException {
        Connection connessione = null;
        PreparedStatement esegui = null;
        ResultSet set = null;

        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            String query = "SELECT centro FROM OperatoriRegistrati WHERE userid = ?";
            esegui = connessione.prepareStatement(query);
            esegui.setInt(1, operatore.getUserID());
            set = esegui.executeQuery();

            if (set.next()) {
                String centro = set.getString("centro");
                if (centro != null) {
                    return true;
                }
            }
        } finally {
            // Chiudi le risorse in modo sicuro
            if (set != null) {
                set.close();
            }
            if (esegui != null) {
                esegui.close();
            }
            if (connessione != null) {
                connessione.close();
            }
        }
        return false;
    }

    //TODO rmi
    public PuntoInteresse ricercaPuntiInteresseAssociati(String scelta1, String scelta2){
        scelta2 = scelta2.toUpperCase();
        Connection connessione = null;
        try {
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
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

                    return new PuntoInteresse(geonameID, name, asname, cc, cname, lat, lon);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RepositoryPuntiInteresse.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (set != null) {
                    try {
                        set.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepositoryPuntiInteresse.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return null;
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
