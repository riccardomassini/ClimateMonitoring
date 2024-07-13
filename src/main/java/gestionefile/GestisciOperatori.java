
package gestionefile;;

import Database.*;
import oggetti.*;
import java.sql.*;
import RegistraEventi.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;
import Database.*;
import oggetti.*;
import java.sql.*;
import RegistraEventi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilizza una struttura dati di tipo OperatoriClimatici per gestire,
 * per organizzare e salvare in un file tutti i parametri inseriti dall'utente
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class GestisciOperatori{
    
    LoggerEventi logger = LoggerEventi.getInstance();
    
    private OperatoriClimatici operatore = new OperatoriClimatici();
    
    
    public boolean registrazione(OperatoriClimatici operatore){
        Connection connessione = null;
        try {
            connessione = ConnessioneDB.getConnection();
            /*if(verificaDuplicato(connessione, operatore.getUserID())){
                System.out.println("Errore... chiave primaria duplicata");
                return;
            }*/
            String query = "INSERT INTO OperatoriRegistrati(userid, nome, cognome, codfisc, email, password, centro) VALUES (?, ?, ?, ?, ?, ?, NULL)";
            PreparedStatement esegui = connessione.prepareStatement(query);
            
            esegui.setInt(1, operatore.getUserID());
            esegui.setString(2, operatore.getNome());
            esegui.setString(3, operatore.getCognome());
            esegui.setString(4, operatore.getCf());
            esegui.setString(5, operatore.getMail());
            esegui.setString(6, operatore.getPassword());

            esegui.executeUpdate();
        }catch(PSQLException e){
            return false;
        }catch (SQLException ex) {
            Logger.getLogger(GestisciOperatori.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        // Chiudi la connessione nel blocco finally
            if (connessione != null) {
                try {
                    connessione.close();
                } catch (SQLException e) {
                    // Gestisci eventuali eccezioni durante la chiusura della connessione
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    
    /*private boolean verificaDuplicato(Connection connessione, int userID) throws SQLException{
    String query = "SELECT COUNT(*) FROM OperatoriRegistrati WHERE userid = ?";
    try (PreparedStatement esegui = connessione.prepareStatement(query)) {
        esegui.setInt(1, userID);
        try (ResultSet set = esegui.executeQuery()) {
            if (set.next()) {
                int count = set.getInt(1);
                return count > 0; // Restituisce true se l'ID esiste già
            }
        }
    }
    return false;
}*/
    
    public boolean login(OperatoriClimatici operatore){
        ResultSet set = null;
        Connection connessione = null;
        try {
            connessione = ConnessioneDB.getConnection();
            
            String query = "SELECT * FROM OperatoriRegistrati WHERE userid = ? AND password = ? ";
            
            PreparedStatement esegui = connessione.prepareStatement(query);     // PER EVITARE SQL INJECTION
            esegui.setInt(1, operatore.getUserID());
            esegui.setString(2, operatore.getPassword());
            
            set = esegui.executeQuery();
            
            while(set.next()){
                this.operatore = new OperatoriClimatici(set.getString("nome"), set.getString("cognome"), set.getString("codfisc"), set.getString("email"), 
                                                       set.getInt("userid"), set.getString("password"), set.getString("centro"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestisciOperatori.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        // Chiudi la connessione nel blocco finally
            if (connessione != null) {
                try {
                    connessione.close();
                } catch (SQLException e) {
                    // Gestisci eventuali eccezioni durante la chiusura della connessione
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    

    public OperatoriClimatici getOperatore(){
        return this.operatore;
    }
    
    public void setCentro(OperatoriClimatici operatore, String nuovoCentro) throws SQLException {
        Connection connessione = null;
        PreparedStatement esegui = null;

        try {
            connessione = ConnessioneDB.getConnection();
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
    
    public boolean haCentro(OperatoriClimatici operatore) throws SQLException {
        Connection connessione = null;
        PreparedStatement esegui = null;
        ResultSet set = null;

        try {
            connessione = ConnessioneDB.getConnection();
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
    
    /**
     * Metodo che controlla se la mail inserita durante la registrazione è valida
     * @param mail mail dell'operatore
     * @return valore booleano, true se la mail è valida, false altrimenti
     */
    public boolean controlloMail(String mail){
        if(mail.contains("@") && mail.length()>0)
            return true;
        
        return false;
    }
    
    /**
     * Metodo che controlla se il codice fiscale è valido
     * @param codiceFiscale codice fiscale da controllare
     * @return valore booleano, true se il codice fiscale è valido, false altrimenti
     */
    public boolean checkCodiceFiscale(String codiceFiscale){
        int limNum = 7, limChar = 9, contN = 0, contC = 0;        
        if (codiceFiscale == null || codiceFiscale.length() != 16)
            return false;

        for (int i = 0; i < 16; i++){
            char c = Character.toUpperCase(codiceFiscale.charAt(i));
            if (!(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'Z'))
                return false;
            
            if(c >= '0' && c <= '9')
                contN++;
            else
                contC++;
        }
        if(limNum!=contN || limChar!=contC)
            return false;
        
        return true;
    }
}
