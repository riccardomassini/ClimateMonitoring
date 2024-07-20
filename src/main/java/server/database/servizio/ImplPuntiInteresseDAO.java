package server.database.servizio;

import commons.oggetti.PuntoInteresse;
import server.database.ConnettoreDatabase;
import server.database.dao.PuntiInteresseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static server.database.DizionarioDatabase.*;

public class ImplPuntiInteresseDAO implements PuntiInteresseDAO {
    private static final String QUERY_ELENCO_POI = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE;
    private static final String QUERY_POI_PER_NOME = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " WHERE " + PUNTIINTERESSE_ATTRIBUTO_NOMEASCII + " ILIKE ?";
    private static final String QUERY_POI_PER_CODICE_NAZIONE = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " WHERE " + PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE + " = ?";
    private static final String QUERY_POI_PER_NOME_E_CODICE_NAZIONE = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " WHERE " + PUNTIINTERESSE_ATTRIBUTO_NOMEASCII + " ILIKE ? AND " + PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE + " = ?";


    @Override
    public PuntoInteresse[] ottieniElencoPuntiInteresse() {
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_ELENCO_POI);
             ) {
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
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elencoPuntiInteresse.toArray(new PuntoInteresse[elencoPuntiInteresse.size()]);
    }

    @Override
    public PuntoInteresse[] ottieniPuntiInteressePerNome(String nome) {
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_POI_PER_NOME);
        ) {
            stmt.setString(1, "%" + nome+ "%");
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
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elencoPuntiInteresse.toArray(new PuntoInteresse[elencoPuntiInteresse.size()]);
    }

    @Override
    public PuntoInteresse[] ottieniPuntiInteressePerCodiceNazione(String codiceNazione) {
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_POI_PER_CODICE_NAZIONE);
        ) {
            stmt.setString(1, codiceNazione);
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
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elencoPuntiInteresse.toArray(new PuntoInteresse[elencoPuntiInteresse.size()]);
    }

    @Override
    public PuntoInteresse[] ottieniPuntiInteressePerNomeECodiceNazione(String nomePuntoInteresse, String codiceNazione) {
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_POI_PER_NOME_E_CODICE_NAZIONE);
        ) {
            stmt.setString(1, "%" + nomePuntoInteresse + "%");
            stmt.setString(2, codiceNazione);
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
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elencoPuntiInteresse.toArray(new PuntoInteresse[elencoPuntiInteresse.size()]);
    }

    private int parseInt(String str) {
        StringBuilder t = new StringBuilder();
        int i = 0;
        while(str.charAt(i) != ' ')
            t.append(str.charAt(i++));
        return Integer.parseInt(t.toString());
    }


}
