package server.gestionefile;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.Paese;
import server.Database.ConnettoreDatabase;

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
            
            for(Paese p: aree){
                String query2 = "INSERT INTO areemonitoratedacentri(centro, geonameid) VALUES (?, ?)";
                PreparedStatement esegui2 = connessione.prepareStatement(query2);
                esegui2.setString(1, centro.getNome());
                esegui2.setInt(2, p.getGeonameID());
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
    
    public Paese trovaArea(String nomeP, String code, String centroOp){
        ResultSet set = null;
        Paese paese = null;
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

                paese = new Paese(geonameID, name, asname, cc, cname, lat, lon);
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
