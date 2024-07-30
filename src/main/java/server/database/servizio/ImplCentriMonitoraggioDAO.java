/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.servizio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import server.database.ConnettoreDatabase;
import server.database.dao.CentriMonitoraggioDAO;
import static server.database.servizio.DizionarioDatabase.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe {@code ImplCentriMonitoraggioDAO} che implementa l'interfaccia {@link CentriMonitoraggioDAO}
 * per la gestione delle operazioni di accesso ai dati relativi ai centri di monitoraggio nel database.
 * <p>
 * Questa classe fornisce metodi per inserire nuovi centri di monitoraggio, associare punti di interesse
 * a centri esistenti, ottenere informazioni sui punti di interesse associati a un centro, e altre
 * operazioni di lettura e aggiornamento dei dati. Utilizza SQL per interagire con il database e gestisce
 * le eccezioni SQL in modo appropriato.
 * </p>
 *
 * <p>
 * La classe è progettata per essere utilizzata come parte di un sistema di gestione di centri di monitoraggio,
 * fornendo un'astrazione per le operazioni di database e facilitando l'integrazione con altre componenti
 * del sistema.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ImplCentriMonitoraggioDAO  implements CentriMonitoraggioDAO {

    /**
     * Query SQL per inserire un nuovo centro di monitoraggio.
     */
    private static final String QUERY_INSERIMENTO_NUOVO_CENTRO = "INSERT INTO " + CENTRIMONITORAGGIO_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?)";

    /**
     * Query SQL per inserire nuovi punti di interesse monitorati da un centro.
     */
    private static final String QUERY_INSERIMENTO_NUOVI_PUNTI_INTERESSE_MONITORATI = "INSERT INTO " + PUNTIINTERESSEASSOCIATI_RELAZIONE+ " VALUES (?, ?)";

    /**
     * Query SQL per ottenere i punti di interesse associati a un centro di monitoraggio.
     */
    private static final String QUERY_OTTIENI_PUNTI_INTERESSE_ASSOCIATI_A_CENTRO_MONITORAGGIO = "SELECT " + PUNTIINTERESSE_RELAZIONE + ".* FROM " + PUNTIINTERESSE_RELAZIONE + " NATURAL JOIN " + PUNTIINTERESSEASSOCIATI_RELAZIONE + " NATURAL JOIN " + CENTRIMONITORAGGIO_RELAZIONE + " WHERE " + CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO + " ILIKE ?";

    /**
     * Query SQL per aggiornare il centro di monitoraggio associato a un operatore.
     */
    private static final String QUERY_AGGIORNA_OPERATORE_CENTRO_ASSOCIATO = "UPDATE " + OPERATORI_RELAZIONE + " SET " + OPERATORI_ATTRIBUTO_IDCENTROMONITORAGGIO + " = ? WHERE " + OPERATORI_ATTRIBUTO_USERNAME + " = ?";

    /**
     * Query SQL per ottenere il centro di monitoraggio associato a un operatore.
     */
    private static final String QUERY_OTTENI_CENTRO_MONITORAGGIO_ASSOCIATO_A_OPERATORE = "SELECT * FROM " + CENTRIMONITORAGGIO_RELAZIONE + " NATURAL JOIN " + OPERATORI_RELAZIONE + " WHERE " + OPERATORI_ATTRIBUTO_USERNAME + " = ?";

    /**
     * Query SQL per ottenere un paese associato a un centro di monitoraggio.
     */
    private static final String QUERY_OTTIENI_PAESE_ASSOCIATO_A_CENTRO = "SELECT " + PUNTIINTERESSE_RELAZIONE + ".* " + "FROM " + PUNTIINTERESSEASSOCIATI_RELAZIONE + " NATURAL JOIN " + PUNTIINTERESSE_RELAZIONE + " WHERE " + PUNTIINTERESSEASSOCIATI_RELAZIONE + "." + PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDCENTROMONITORAGGIO +" = ? AND UPPER(" + PUNTIINTERESSE_RELAZIONE + "." + PUNTIINTERESSE_ATTRIBUTO_NOMEASCII + ") = ? AND " + PUNTIINTERESSE_RELAZIONE + "." + PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE + " = ?";

    /**
     * Query SQL per leggere tutti i centri di monitoraggio.
     */
    private static final String QUERY_LETTURA_CENTRI_DI_MONITORAGGIO = "SELECT " + CENTRIMONITORAGGIO_RELAZIONE + ".* FROM " + CENTRIMONITORAGGIO_RELAZIONE;

    /**
     * Inserisce un nuovo centro di monitoraggio nel database.
     * <p>
     * Questo metodo esegue una query SQL di tipo <code>INSERT</code> per aggiungere un nuovo centro
     * di monitoraggio alla tabella specificata nel database. I dettagli del centro vengono ottenuti
     * dall'oggetto {@link CentroMonitoraggio} passato come parametro.
     * </p>
     *
     * @param nuovoCentro Il centro di monitoraggio da inserire. Deve essere un'istanza di {@link CentroMonitoraggio}.
     */
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

    /**
     * Inserisce punti di interesse associati a un centro di monitoraggio.
     * <p>
     * Questo metodo esegue una query SQL di tipo <code>INSERT</code> per associare uno o più
     * punti di interesse a un centro di monitoraggio specificato. I punti di interesse sono forniti
     * come un array di oggetti {@link PuntoInteresse}.
     * </p>
     *
     * @param nomeCentro Il nome del centro di monitoraggio al quale associare i punti di interesse.
     * @param elencoPuntiInteresse L'array di punti di interesse da associare. Ogni elemento deve essere un'istanza di {@link PuntoInteresse}.
     */
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

    /**
     * <p>
     * Questo metodo esegue una query SQL per ottenere le informazioni di un paese associato a un centro di monitoraggio.
     * </p>
     *
     * @param nomePaese Il nome del paese da cercare.
     * @param codice Il codice della nazione del paese da cercare.
     * @param nomeCentro Il nome del centro di monitoraggio a cui il paese è associato.
     * @return Un oggetto {@link PuntoInteresse} che rappresenta il paese trovato, o {@code null} se il paese non è trovato.
     */
    @Override
    public PuntoInteresse ottieniPaeseDaCentro(String nomePaese, String codice, String nomeCentro){
        ResultSet rs = null;
        PuntoInteresse puntoInteresse = null;
        
        try {
            Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            PreparedStatement stmt = connessione.prepareStatement(QUERY_OTTIENI_PAESE_ASSOCIATO_A_CENTRO);

            stmt.setString(1, nomeCentro);
            stmt.setString(2, nomePaese.toUpperCase());
            stmt.setString(3, codice.toUpperCase());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                puntoInteresse = new PuntoInteresse();
                puntoInteresse.setIdPuntoInteresse(parseInt(rs.getString(PUNTIINTERESSE_ATTRIBUTO_ID)));
                puntoInteresse.setNomePuntoInteresse(rs.getString(PUNTIINTERESSE_ATTRIBUTO_NOME));
                puntoInteresse.setNomePuntoInteresseASCII(rs.getString(PUNTIINTERESSE_ATTRIBUTO_NOMEASCII));
                puntoInteresse.setCodiceNazione(rs.getString(PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE));
                puntoInteresse.setNomeNazione(rs.getString(PUNTIINTERESSE_ATTRIBUTO_NOMENAZIONE));
                puntoInteresse.setLatitudine(rs.getFloat(PUNTIINTERESSE_LATITUDINE));
                puntoInteresse.setLongitudine(rs.getFloat(PUNTIINTERESSE_LONGITUDINE));
            }
        } catch (SQLException ex) {} 
        
        return puntoInteresse;
    }

    /**
     * <p>
     * Questo metodo esegue una query SQL per ottenere tutti i centri di monitoraggio dal database.
     * </p>
     *
     * @return Una lista di oggetti {@link CentroMonitoraggio} che rappresentano tutti i centri di monitoraggio.
     */
    @Override
    public ArrayList<CentroMonitoraggio> leggiTuttiCentri() {
        ArrayList<CentroMonitoraggio> centri = new ArrayList<>();

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_LETTURA_CENTRI_DI_MONITORAGGIO);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nomeCentro = rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO);
                String indirizzo = rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_INDIRIZZO);
                int numeroCivico = rs.getInt(CENTRIMONITORAGGIO_ATTRIBUTO_NUMEROCIVICO);
                String CAP = rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_CAP);
                String comune = rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_COMUNE);
                String provincia = rs.getString(CENTRIMONITORAGGIO_ATTRIBUTO_PROVINCIA);

                centri.add(new CentroMonitoraggio(nomeCentro, indirizzo, numeroCivico, CAP, comune, provincia));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return centri;
    }

    /**
     * <p>
     * Questo metodo esegue una query SQL per ottenere tutti i punti di interesse monitorati da un centro di monitoraggio specificato.
     * </p>
     *
     * @param nomeCentro Il nome del centro di monitoraggio di cui ottenere i punti di interesse.
     * @return Una lista di oggetti {@link PuntoInteresse} che rappresentano i punti di interesse monitorati dal centro specificato.
     */
    @Override
    public ArrayList<PuntoInteresse> ottieniPuntiInteresseMonitoratiDaCentro(String nomeCentro) {
        ResultSet rs = null;
        ArrayList<PuntoInteresse> elencoPuntiInteresse = new ArrayList<>();
        PuntoInteresse puntoInteresse = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_OTTIENI_PUNTI_INTERESSE_ASSOCIATI_A_CENTRO_MONITORAGGIO);
            ) {
            stmt.setString(1, "%" + nomeCentro + "%");
            rs = stmt.executeQuery();
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

        } catch (SQLException ex) {
            System.err.println("Impossibile recuperare i punti di interesse associati al centri");
            ex.printStackTrace();
        }
        return elencoPuntiInteresse;
    }

    /**
     * <p>
     * Questo metodo esegue una query SQL per aggiornare il centro di monitoraggio associato a un operatore.
     * </p>
     *
     * @param username L'username dell'operatore da aggiornare.
     * @param nomeCentro Il nome del nuovo centro di monitoraggio da associare all'operatore.
     */
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