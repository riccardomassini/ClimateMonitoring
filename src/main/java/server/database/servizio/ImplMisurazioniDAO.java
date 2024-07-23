package server.database.servizio;

import commons.oggetti.misurazioni.CategorieParametriClimatici;
import commons.oggetti.misurazioni.Misurazione;
import commons.oggetti.misurazioni.ValutazioneParametro;
import server.database.ConnettoreDatabase;
import server.database.dao.MisurazioniDAO;

import java.sql.*;
import java.util.ArrayList;

import static server.database.DizionarioDatabase.*;

public class ImplMisurazioniDAO implements MisurazioniDAO {
    private static final String QUERY_INSERIMENTO_NUOVA_MISURAZIONE = "INSERT INTO " +  MISURAZIONI_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_ELENCO_MISURAZIONI_PUNTO_INTERESSE = "SELECT * FROM " + MISURAZIONI_RELAZIONE + " NATURAL JOIN " + PUNTIINTERESSEASSOCIATI_RELAZIONE + " WHERE " + MISURAZIONI_ATTRIBUTO_IDPUNTOINTERESSE + " = ?";

    @Override
    public void inserisciNuovaMisurazione(Misurazione nuovaMisurazione) {
        int i = 1;
        try (
                Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
                PreparedStatement stmt = connessione.prepareStatement(QUERY_INSERIMENTO_NUOVA_MISURAZIONE)
        ) {
            stmt.setInt(i++, nuovaMisurazione.getIdPuntoInteresse());
            stmt.setString(i++, nuovaMisurazione.getNomeCentro());
            stmt.setTimestamp(i++, nuovaMisurazione.getTimestampMisurazione());
            for(CategorieParametriClimatici categoria : CategorieParametriClimatici.values()) {
                stmt.setInt(i++, nuovaMisurazione.getValutazioneParametroConCategoria(categoria));
                stmt.setString(i++, nuovaMisurazione.getCommentoParametroConCategoria(categoria));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Impossibile inserire una nuova misurazione");
            e.printStackTrace();
        }
    }

    @Override
    public Misurazione[] ottieniMisurazioniPuntoInteresse(int idPuntoInteresse) {
        ArrayList<Misurazione> elencoMisurazioni = new ArrayList<>();
        Misurazione misurazione;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_ELENCO_MISURAZIONI_PUNTO_INTERESSE);
        ) {
            stmt.setString(1, "" + idPuntoInteresse);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    misurazione = new Misurazione();
                    misurazione.setIdPuntoInteresse(idPuntoInteresse);
                    misurazione.setNomeCentro(rs.getString(MISURAZIONI_ATTRIBUTO_IDCENTROMONITORAGGIO));
                    misurazione.setTimestampMisurazione(rs.getTimestamp(MISURAZIONI_ATTRIBUTO_TIMESTAMP));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.VENTO, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_VENTO), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_VENTO)));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.TEMPERATURA, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_TEMPERATURA), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_TEMPERATURA)));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.PRESSIONE, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRESSIONE), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_PRESSIONE)));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.UMIDITA, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_UMIDITA), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_UMIDITA)));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.PRECIPITAZIONI, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRECIPITAZIONI), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_PRECIPITAZIONI)));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.ALTITUDINE_GHIACCIAI, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_ALTEZZAGHIACCIAI), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_ALTEZZAGHIACCIAI)));
                    misurazione.setParametroConCategoria(CategorieParametriClimatici.MASSA_GHIACCIAI, new ValutazioneParametro(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_MASSAGHIACCIAI), rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_MASSAGHIACCIAI)));
                    elencoMisurazioni.add(misurazione);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Impossibile recuperare le misurazioni associate al punto di interesse fornito");
            ex.printStackTrace();
        }
        return elencoMisurazioni.toArray(new Misurazione[elencoMisurazioni.size()]);

    }


}
