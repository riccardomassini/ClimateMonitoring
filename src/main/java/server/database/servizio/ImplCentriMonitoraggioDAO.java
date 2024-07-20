package server.database.servizio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import server.database.ConnettoreDatabase;
import server.database.dao.CentriMonitoraggioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static server.database.DizionarioDatabase.*;

public class ImplCentriMonitoraggioDAO  implements CentriMonitoraggioDAO {
    private static final String QUERY_INSERIMENTO_NUOVO_CENTRO = "INSERT INTO " + CENTRIMONITORAGGIO_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String QUERY_INSERIMENTO_NUOVI_PUNTI_INTERESSE_MONITORATI = "INSERT INTO " + PUNTIINTERESSEASSOCIATI_RELAZIONE+ " VALUES (?, ?)";
    private static final String QUERY_OTTIENI_PUNTI_INTERESSE_ASSOCIATI_A_CENTRO_MONITORAGGIO = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " NATURAL JOIN " + PUNTIINTERESSEASSOCIATI_RELAZIONE + " NATURAL JOIN " + CENTRIMONITORAGGIO_RELAZIONE + " WHERE " + CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO + " ILIKE ?";
    private static final String QUERY_AGGIORNA_OPERATORE_CENTRO_ASSOCIATO = "UPDATE " + OPERATORI_RELAZIONE + " SET " + OPERATORI_ATTRIBUTO_IDCENTROMONITORAGGIO + " = ? WHERE " + OPERATORI_ATTRIBUTO_USERNAME + " = ?";
    private static final String QUERY_OTTENI_CENTRO_MONITORAGGIO_ASSOCIATO_A_OPERATORE = "SELECT * FROM " + CENTRIMONITORAGGIO_RELAZIONE + " NATURAL JOIN " + OPERATORI_RELAZIONE + " WHERE " + OPERATORI_ATTRIBUTO_USERNAME + " = ?";


    @Override
    public void inserisciCentroMonitoraggio(CentroMonitoraggio nuovoCentro) {
        try (
                Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
                PreparedStatement stmt = connessione.prepareStatement(QUERY_INSERIMENTO_NUOVO_CENTRO)
        ) {
            stmt.setString(1, nuovoCentro.getNomeCentro());
            stmt.setString(2, nuovoCentro.getIndirizzo());
            stmt.setInt(3, nuovoCentro.getNumeroCivico());
            stmt.setString(4, nuovoCentro.getCAP());
            stmt.setString(5, nuovoCentro.getComune());
            stmt.setString(6, nuovoCentro.getProvincia());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Impossibile inserire un nuovo centro");
            e.printStackTrace();
        }
    }

    @Override
    public void inserisciPuntiInteresseMonitoratiDaCentro(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse) {
        try (
                Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
                PreparedStatement stmt = connessione.prepareStatement(QUERY_INSERIMENTO_NUOVI_PUNTI_INTERESSE_MONITORATI)
        ) {
            for(PuntoInteresse puntiInteresse : elencoPuntiInteresse) {
                stmt.setString(1, nomeCentro);
                stmt.setInt(2, puntiInteresse.getIdPuntoInteresse());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Impossibile inserire nuovi punti di interesse da associare");
            e.printStackTrace();
        }
    }

    @Override
    public PuntoInteresse[] ottieniPuntiInteresseMonitoratiDaCentro(String nomeCentro) {
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_OTTIENI_PUNTI_INTERESSE_ASSOCIATI_A_CENTRO_MONITORAGGIO);
        ) {
            stmt.setString(1, "%" + nomeCentro + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    puntoInteresse = new PuntoInteresse();
                    puntoInteresse.setIdPuntoInteresse(parseInt(rs.getString(PUNTIINTERESSE_ATTRIBUTO_ID)));
                    puntoInteresse.setNomePuntoInteresse(rs.getString(PUNTIINTERESSE_ATTRIBUTO_NOME));
                    puntoInteresse.setNomePuntoInteresseASCII(rs.getString(PUNTIINTERESSE_ATTRIBUTO_NOMEASCII));
                    puntoInteresse.setCodiceNazione(rs.getString(PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE));
                    puntoInteresse.setNomeNazione(rs.getString(PUNTIINTERESSE_ATTRIBUTO_NOMENAZIONE));
                    puntoInteresse.setLatitudine(rs.getFloat(PUNTIINTERESSE_LATITUDINE));
                    puntoInteresse.setLongitudine(rs.getFloat(PUNTIINTERESSE_LONGITUDINE));
                    elencoPuntiInteresse.add(puntoInteresse);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Impossibile recuperare i punti di interesse associati al centri");
            ex.printStackTrace();
        }
        return elencoPuntiInteresse.toArray(new PuntoInteresse[elencoPuntiInteresse.size()]);
    }

    @Override
    public void aggiornaCentroMonitoraggioAssociatoOperatore(int username, String nomeCentro) {
        try (
                Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
                PreparedStatement stmt = connessione.prepareStatement(QUERY_AGGIORNA_OPERATORE_CENTRO_ASSOCIATO)
        ) {
            stmt.setString(1, nomeCentro);
            stmt.setInt(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Impossibile aggiornare l'operatore");
            e.printStackTrace();
        }
    }

    @Override
    public CentroMonitoraggio otteniCentroMonitoraggioAssociatoOperatore(int username) {
        CentroMonitoraggio centro = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_OTTENI_CENTRO_MONITORAGGIO_ASSOCIATO_A_OPERATORE);
        ) {
            stmt.setInt(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    centro = new CentroMonitoraggio();
                    centro.setNomeCentro(rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO));
                    centro.setIndirizzo(rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_INDIRIZZO));
                    centro.setCAP(rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_CAP));
                    centro.setComune(rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_COMUNE));
                    centro.setNumeroCivico(rs.getInt(CENTRIMONITORAGGIO_ATTRIBUTO_NUMEROCIVICO));
                    centro.setProvincia(rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_PROVINCIA));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centro;
    }

    private int parseInt(String str) {
        StringBuilder t = new StringBuilder();
        int i = 0;
        while(str.charAt(i) != ' ')
            t.append(str.charAt(i++));
        return Integer.parseInt(t.toString());
    }


}
