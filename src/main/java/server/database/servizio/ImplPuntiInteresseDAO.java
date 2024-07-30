/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.servizio;

import commons.oggetti.PuntoInteresse;
import server.database.ConnettoreDatabase;
import server.database.dao.CentriMonitoraggioDAO;
import server.database.dao.PuntiInteresseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static server.database.servizio.DizionarioDatabase.*;

/**
 * Classe {@code ImplPuntiInteresseDAO} che implementa l'interfaccia {@link PuntiInteresseDAO}
 * per la gestione delle operazioni di accesso ai dati relativi ai punti di interesse nel database.
 * <p>
 * Questa classe fornisce metodi per ottere l'elenco di tutti i punti di interesse, ottenere i punti di interesse dato il nome, il codice dello stato o le coordinate.
 * Utilizza SQL per interagire con il database e gestisce
 * le eccezioni SQL in modo appropriato.
 * </p>
 *
 * <p>
 * La classe è progettata per essere utilizzata come parte di un sistema di gestione di aree di interesse,
 * fornendo un'astrazione per le operazioni di database e facilitando l'integrazione con altre componenti
 * del sistema.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ImplPuntiInteresseDAO implements PuntiInteresseDAO {

    /**
     * Query SQL per ottenere l'elenco di tutti i punti di interesse dal database.
     * La query seleziona tutti i campi dalla tabella dei punti di interesse.
     */
    private static final String QUERY_ELENCO_POI = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE;

    /**
     * Query SQL per ottenere i punti di interesse dal database in base al nome.
     * La query utilizza il parametro `ILIKE` per effettuare una ricerca case-insensitive con pattern matching.
     */
    private static final String QUERY_POI_PER_NOME = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " WHERE " + PUNTIINTERESSE_ATTRIBUTO_NOMEASCII + " ILIKE ?";

    /**
     * Query SQL per ottenere i punti di interesse dal database in base al codice della nazione.
     * La query seleziona tutti i campi dalla tabella dei punti di interesse dove il codice della nazione corrisponde al valore specificato.
     */
    private static final String QUERY_POI_PER_CODICE_NAZIONE = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " WHERE " + PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE + " = ?";

    /**
     * Query SQL per ottenere i punti di interesse dal database in base al nome e al codice della nazione.
     * La query seleziona tutti i campi dalla tabella dei punti di interesse dove il nome e il codice della nazione corrispondono ai valori specificati.
     * La ricerca del nome è case-insensitive.
     */
    private static final String QUERY_POI_PER_NOME_E_CODICE_NAZIONE = "SELECT * FROM " + PUNTIINTERESSE_RELAZIONE + " WHERE UPPER(" + PUNTIINTERESSE_ATTRIBUTO_NOMEASCII + ") = ? AND " + PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE + " = ?";

    /**
     * Recupera l'elenco di tutti i punti di interesse dal database.
     *
     * @return Un array di oggetti {@link PuntoInteresse} che rappresentano tutti i punti di interesse.
     */
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

    /**
     * Recupera i punti di interesse dal database in base al nome specificato.
     *
     * @param nome Il nome del punto di interesse da cercare.
     * @return Un array di oggetti {@link PuntoInteresse} che rappresentano i punti di interesse trovati.
     */
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

    /**
     * Recupera i punti di interesse dal database in base al codice della nazione specificato.
     *
     * @param codiceNazione Il codice della nazione dei punti di interesse da cercare.
     * @return Un array di oggetti {@link PuntoInteresse} che rappresentano i punti di interesse trovati.
     */
    @Override
    public PuntoInteresse[] ottieniPuntiInteressePerCodiceNazione(String codiceNazione) {
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_POI_PER_CODICE_NAZIONE);
        ) {
            stmt.setString(1, codiceNazione.toUpperCase());
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

    /**
     * Recupera un punto di interesse dal database in base al nome e al codice della nazione specificati.
     *
     * @param nomePuntoInteresse Il nome del punto di interesse da cercare.
     * @param codiceNazione Il codice della nazione del punto di interesse da cercare.
     * @return Un oggetto {@link PuntoInteresse} che rappresenta il punto di interesse trovato, o null se non viene trovato alcun punto di interesse.
     */
    @Override
    public PuntoInteresse ottieniPuntiInteressePerNomeECodiceNazione(String nomePuntoInteresse, String codiceNazione) {
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_POI_PER_NOME_E_CODICE_NAZIONE);
        ) {
            stmt.setString(1,  nomePuntoInteresse.toUpperCase());
            stmt.setString(2, codiceNazione.toUpperCase());
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
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPuntiInteresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puntoInteresse;
    }

    /**
     * Metodo di utilità per convertire una stringa in un intero, fermandosi al primo spazio.
     * <p>
     * Questo metodo prende una stringa e ritorna il suo valore intero, considerandolo fino al primo spazio.
     * </p>
     *
     * @param str La stringa da convertire.
     * @return L'intero risultante dalla conversione della stringa.
     */
    private int parseInt(String str) {
        StringBuilder t = new StringBuilder();
        int i = 0;
        while(str.charAt(i) != ' ')
            t.append(str.charAt(i++));
        return Integer.parseInt(t.toString());
    }
}
