/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.servizio;

import commons.oggetti.misurazioni.CategorieParametriClimatici;
import commons.oggetti.misurazioni.Misurazione;
import commons.oggetti.misurazioni.ValutazioneParametro;
import server.database.ConnettoreDatabase;
import server.database.dao.MisurazioniDAO;

import java.sql.*;
import java.util.ArrayList;

import static server.database.servizio.DizionarioDatabase.*;

/**
 * Classe {@code ImplMisurazioniDAO} che implementa l'interfaccia {@link MisurazioniDAO}
 * per la gestione delle operazioni di accesso ai dati relativi alle misurazioni nel database.
 * <p>
 * Questa classe fornisce metodi per inserire nuove misurazioni e rilevazioni e per ottenere quest'ultime data un'area di interesse.
 * Utilizza SQL per interagire con il database e gestisce
 * le eccezioni SQL in modo appropriato.
 * </p>
 *
 * <p>
 * La classe è progettata per essere utilizzata come parte di un sistema di rilevazioni su aree di interesse,
 * fornendo un'astrazione per le operazioni di database e facilitando l'integrazione con altre componenti
 * del sistema.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ImplMisurazioniDAO implements MisurazioniDAO {

    /**
     * Query SQL per inserire una nuova misurazione nel database.
     * La query utilizza i segnaposto per i seguenti valori:
     * <ol>
     *     <li>ID del punto di interesse</li>
     *     <li>Nome del centro di monitoraggio</li>
     *     <li>Timestamp della misurazione</li>
     *     <li>Valutazione del parametro vento</li>
     *     <li>Commento del parametro vento</li>
     *     <li>Valutazione del parametro temperatura</li>
     *     <li>Commento del parametro temperatura</li>
     *     <li>Valutazione del parametro pressione</li>
     *     <li>Commento del parametro pressione</li>
     *     <li>Valutazione del parametro umidità</li>
     *     <li>Commento del parametro umidità</li>
     *     <li>Valutazione del parametro precipitazioni</li>
     *     <li>Commento del parametro precipitazioni</li>
     *     <li>Valutazione del parametro altitudine ghiacciai</li>
     *     <li>Commento del parametro altitudine ghiacciai</li>
     *     <li>Valutazione del parametro massa ghiacciai</li>
     *     <li>Commento del parametro massa ghiacciai</li>
     * </ol>
     */
    private static final String QUERY_INSERIMENTO_NUOVA_MISURAZIONE = "INSERT INTO " +  MISURAZIONI_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     * Query SQL per recuperare tutte le misurazioni associate a un punto di interesse specificato.
     * La query utilizza un join naturale tra le tabelle delle misurazioni e dei punti di interesse associati,
     * filtrando per l'ID del punto di interesse.
     */
    private static final String QUERY_ELENCO_MISURAZIONI_PUNTO_INTERESSE = "SELECT * FROM " + MISURAZIONI_RELAZIONE + " NATURAL JOIN " + PUNTIINTERESSEASSOCIATI_RELAZIONE + " WHERE " + MISURAZIONI_ATTRIBUTO_IDPUNTOINTERESSE + " = ?";

    /** Costruttore vuoto */
    public ImplMisurazioniDAO(){}

    /**
     * <p>
     * Questo metodo inserisce una nuova misurazione nel database.
     * </p>
     *
     * @param nuovaMisurazione L'oggetto {@link Misurazione} che rappresenta la nuova misurazione da inserire.
     */
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

    /**
     * <p>
     * Questo metodo recupera tutte le misurazioni associate a un punto di interesse specificato.
     * </p>
     *
     * @param idPuntoInteresse L'ID del punto di interesse di cui recuperare le misurazioni.
     * @return Un array di oggetti {@link Misurazione} che rappresentano le misurazioni associate al punto di interesse specificato.
     */
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