package server.database.servizio;

import commons.oggetti.Operatore;
import org.postgresql.util.PSQLException;
import server.database.ConnettoreDatabase;
import server.database.dao.OperatoriDAO;
import server.servizio.autenticazione.Autenticatore;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static server.database.servizio.DizionarioDatabase.*;

public class ImplOperatoriDAO implements OperatoriDAO {
    private static final String QUERY_INSERIMENTO_NUOVO_OPERATORE = "INSERT INTO " + OPERATORI_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_OPERATORE_DA_USERNAME = "SELECT " + OPERATORI_RELAZIONE + ".* FROM " + OPERATORI_RELAZIONE + " WHERE " + OPERATORI_ATTRIBUTO_USERNAME + " = ?";

    @Override
    public boolean inserisciNuovoOperatore(Operatore nuovoOperatore) {
        try (
                Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
                PreparedStatement stmt = connessione.prepareStatement(QUERY_INSERIMENTO_NUOVO_OPERATORE)
        ) {
            stmt.setInt(1, nuovoOperatore.getUsername());
            stmt.setString(2, nuovoOperatore.getNome());
            stmt.setString(3, nuovoOperatore.getCognome());
            stmt.setString(4, nuovoOperatore.getCodiceFiscale());
            stmt.setString(5, nuovoOperatore.getEmail());
            stmt.setString(6, nuovoOperatore.getPassword());
            stmt.setNull(7, Types.VARCHAR);

            stmt.executeUpdate();
        } catch(PSQLException e){
            e.printStackTrace();
            return false; //operatore già presente
        }catch (SQLException ex) {
            Logger.getLogger(Autenticatore.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true; //operatore inserito
    }

    @Override
    public Operatore ottieniOperatoreDaUsername(int username) {
        Operatore operatore = null;
        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_OPERATORE_DA_USERNAME);
        ) {
            stmt.setInt(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    operatore = new Operatore();
                    operatore.setUsername(rs.getInt(OPERATORI_ATTRIBUTO_USERNAME));
                    operatore.setNome(rs.getString(OPERATORI_ATTRIBUTO_NOME));
                    operatore.setCognome(rs.getString(OPERATORI_ATTRIBUTO_COGNOME));
                    operatore.setEmail(rs.getString(OPERATORI_ATTRIBUTO_EMAIL));
                    operatore.setCodiceFiscale(rs.getString(OPERATORI_ATTRIBUTO_CF));
                    operatore.setPassword(rs.getString(OPERATORI_ATTRIBUTO_PASSWORD));
                    operatore.setIdCentroMonitoraggio(rs.getString(OPERATORI_ATTRIBUTO_IDCENTROMONITORAGGIO));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operatore;
    }
}
