/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.oggetti;

import java.io.Serializable;

/**
 * La classe {@code PuntoInteresse} rappresenta un punto di interesse geografico.
 * Include informazioni come l'ID, il nome del punto, il nome in formato ASCII, il codice e il nome della nazione,
 * nonché le coordinate geografiche (latitudine e longitudine).
 * <p>
 * Questa classe implementa l'interfaccia {@code Serializable} per consentire la serializzazione
 * dell'oggetto, utile per la memorizzazione persistente o la trasmissione su una rete.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class PuntoInteresse implements Serializable {

    /**
     * L'ID del punto di interesse.
     */
    private int idPuntoInteresse;

    /**
     * Il nome del punto di interesse.
     */
    private String nomePuntoInteresse;

    /**
     * Il nome del punto di interesse in formato ASCII.
     */
    private String nomePuntoInteresseASCII;

    /**
     * Il codice della nazione del punto di interesse.
     */
    private String codiceNazione;

    /**
     * Il nome della nazione del punto di interesse.
     */
    private String nomeNazione;

    /**
     * La latitudine del punto di interesse.
     */
    private double latitudine;

    /**
     * La longitudine del punto di interesse.
     */
    private double longitudine;

    /**
     * Costruttore predefinito. Inizializza un'istanza vuota di {@code PuntoInteresse}.
     */
    public PuntoInteresse() {}

    /**
     * Costruttore che inizializza tutte le proprietà del punto di interesse.
     *
     * @param idPuntoInteresse       l'ID del punto di interesse
     * @param nomePuntoInteresse     il nome del punto di interesse
     * @param nomePuntoInteresseASCII il nome del punto di interesse in formato ASCII
     * @param codiceNazione          il codice della nazione del punto di interesse
     * @param nomeNazione            il nome della nazione del punto di interesse
     * @param latitudine             la latitudine del punto di interesse
     * @param longitudine            la longitudine del punto di interesse
     */
    public PuntoInteresse(int idPuntoInteresse, String nomePuntoInteresse, String nomePuntoInteresseASCII, String codiceNazione, String nomeNazione, double latitudine, double longitudine) {
        this();
        this.idPuntoInteresse = idPuntoInteresse;
        this.nomePuntoInteresse = nomePuntoInteresse;
        this.nomePuntoInteresseASCII = nomePuntoInteresseASCII;
        this.codiceNazione = codiceNazione;
        this.nomeNazione = nomeNazione;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    /**
     * Restituisce l'ID del punto di interesse.
     *
     * @return l'ID del punto di interesse
     */
    public int getIdPuntoInteresse() {
        return idPuntoInteresse;
    }

    /**
     * Restituisce il nome del punto di interesse.
     *
     * @return il nome del punto di interesse
     */
    public String getNomePuntoInteresse() {
        return nomePuntoInteresse;
    }

    /**
     * Restituisce il nome del punto di interesse in formato ASCII.
     *
     * @return il nome del punto di interesse in formato ASCII
     */
    public String getNomePuntoInteresseASCII() {
        return nomePuntoInteresseASCII;
    }

    /**
     * Restituisce il codice della nazione del punto di interesse.
     *
     * @return il codice della nazione
     */
    public String getCodiceNazione() {
        return codiceNazione;
    }

    /**
     * Restituisce il nome della nazione del punto di interesse.
     *
     * @return il nome della nazione
     */
    public String getNomeNazione() {
        return nomeNazione;
    }

    /**
     * Restituisce la latitudine del punto di interesse.
     *
     * @return la latitudine
     */
    public double getLatitudine() {
        return latitudine;
    }

    /**
     * Restituisce la longitudine del punto di interesse.
     *
     * @return la longitudine
     */
    public double getLongitudine() {
        return longitudine;
    }

    /**
     * Imposta l'ID del punto di interesse.
     *
     * @param idPuntoInteresse l'ID del punto di interesse
     */
    public void setIdPuntoInteresse(int idPuntoInteresse) {
        this.idPuntoInteresse = idPuntoInteresse;
    }

    /**
     * Imposta il nome del punto di interesse.
     *
     * @param nomePuntoInteresse il nome del punto di interesse
     */
    public void setNomePuntoInteresse(String nomePuntoInteresse) {
        this.nomePuntoInteresse = nomePuntoInteresse;
    }

    /**
     * Imposta il nome del punto di interesse in formato ASCII.
     *
     * @param nomePuntoInteresseASCII il nome del punto di interesse in formato ASCII
     */
    public void setNomePuntoInteresseASCII(String nomePuntoInteresseASCII) {
        this.nomePuntoInteresseASCII = nomePuntoInteresseASCII;
    }

    /**
     * Imposta il codice della nazione del punto di interesse.
     *
     * @param codiceNazione il codice della nazione
     */
    public void setCodiceNazione(String codiceNazione) {
        this.codiceNazione = codiceNazione;
    }

    /**
     * Imposta il nome della nazione del punto di interesse.
     *
     * @param nomeNazione il nome della nazione
     */
    public void setNomeNazione(String nomeNazione) {
        this.nomeNazione = nomeNazione;
    }

    /**
     * Imposta la latitudine del punto di interesse.
     *
     * @param latitudine la latitudine
     */
    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    /**
     * Imposta la longitudine del punto di interesse.
     *
     * @param longitudine la longitudine
     */
    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto {@code PuntoInteresse}.
     *
     * @return una stringa contenente i dettagli del punto di interesse
     */
    @Override
    public String toString() {
        return nomePuntoInteresseASCII + "," + codiceNazione + "," + latitudine + "," + longitudine;
    }

    /**
     * Confronta questo punto di interesse con un altro oggetto per verificarne l'uguaglianza.
     *
     * @param obj l'oggetto da confrontare
     * @return {@code true} se i due oggetti sono uguali, altrimenti {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PuntoInteresse other = (PuntoInteresse) obj;
        return this.nomePuntoInteresseASCII.equals(other.nomePuntoInteresseASCII) &&
               this.codiceNazione.equals(other.codiceNazione);
    }

    /**
     * Verifica se le coordinate geografiche sono valide.
     *
     * @param latitudine  la latitudine da verificare
     * @param longitudine la longitudine da verificare
     * @return {@code true} se le coordinate sono valide, altrimenti {@code false}
     */
    public static boolean coordinateValide(double latitudine, double longitudine) {
        return latitudine >-90 && latitudine <90 && longitudine >-180 && longitudine <180;
    }
}