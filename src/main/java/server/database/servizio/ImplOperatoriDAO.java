/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.servizio;

import commons.oggetti.Operatore;
import org.postgresql.util.PSQLException;
import server.database.ConnettoreDatabase;
import server.database.dao.CentriMonitoraggioDAO;
import server.database.dao.OperatoriDAO;
import server.servizio.autenticazione.Autenticatore;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static server.database.servizio.DizionarioDatabase.*;

/**
 * Classe {@code ImplOperatoriDAO} che implementa l'interfaccia {@link OperatoriDAO}
 * per la gestione delle operazioni di accesso ai dati relativi agli operatori nel database.
 * <p>
 * Questa classe fornisce metodi per inserire nuovi operatori e ottenere operatori esistenti. Utilizza SQL per interagire con il database e gestisce
 * le eccezioni SQL in modo appropriato.
 * </p>
 *
 * <p>
 * La classe è progettata per essere utilizzata come parte di un sistema di gestione di operatori registrati,
 * fornendo un'astrazione per le operazioni di database e facilitando l'integrazione con altre componenti
 * del sistema.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ImplOperatoriDAO implements OperatoriDAO {

    /**
     * Query SQL per inserire un nuovo operatore nel database.
     * La query utilizza i segnaposto per i seguenti valori:
     * <ol>
     *     <li>Username</li>
     *     <li>Nome</li>
     *     <li>Cognome</li>
     *     <li>Codice Fiscale</li>
     *     <li>Email</li>
     *     <li>Password</li>
     *     <li>ID del centro di monitoraggio (null)</li>
     * </ol>
     */
    private static final String QUERY_INSERIMENTO_NUOVO_OPERATORE = "INSERT INTO " + OPERATORI_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?, ?)";

    /**
     * Query SQL per ottenere un operatore dal database in base all'username.
     * La query seleziona tutti i campi dell'operatore dalla tabella degli operatori dove l'username corrisponde al valore specificato.
     */
    private static final String QUERY_OPERATORE_DA_USERNAME = "SELECT " + OPERATORI_RELAZIONE + ".* FROM " + OPERATORI_RELAZIONE + " WHERE " + OPERATORI_ATTRIBUTO_USERNAME + " = ?";

    /** Costruttore vuoto */
    public ImplOperatoriDAO(){}

    /**
     * <p>
     * Questo metodo inserisce un nuovo operatore nel database.
     * Se l'operatore è già presente, viene gestita un'eccezione specifica e il metodo restituisce false.
     * </p>
     *
     * @param nuovoOperatore L'oggetto {@link Operatore} che rappresenta il nuovo operatore da inserire.
     * @return true se l'operatore è stato inserito con successo, false se l'operatore è già presente.
     */
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
            return false;
        }catch (SQLException ex) {
            Logger.getLogger(Autenticatore.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    /**
     * <p>
     * Questo metodo recupera un operatore dal database in base all'username specificato.
     * </p>
     *
     * @param username L'username dell'operatore da recuperare.
     * @return Un oggetto {@link Operatore} che rappresenta l'operatore recuperato, o null se l'operatore non esiste.
     */
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