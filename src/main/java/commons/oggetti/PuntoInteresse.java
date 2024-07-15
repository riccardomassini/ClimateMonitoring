package commons.oggetti;

import java.io.Serializable;

/**
 * Classe che contiene tutti gli attributi che formano l'oggetto Paese
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class PuntoInteresse implements Serializable {
    private int idPuntoInteresse;
    private String nomePuntoInteresse;
    private String nomePuntoInteresseASCII;
    private String codiceNazione;
    private String nomeNazione;
    private double latitudine;
    private double longitudine;

    public PuntoInteresse() {
    }

    /**
     * Costruttore pieno che servirà per istanziare l'oggetto di tipo Paese
     * @param asname nome del Paese
     * @param cc codice del Paese
     * @param lat latitudine del Paese
     * @param lon longitudine del Paese
     */
    public PuntoInteresse(int geonameID, String name, String asname, String cc, String cname, double lat, double lon) {
        this.idPuntoInteresse = geonameID;
        this.nomePuntoInteresse = name;
        this.nomePuntoInteresseASCII = asname;
        this.codiceNazione = cc;
        this.nomeNazione = cname;
        this.latitudine = lat;
        this.longitudine = lon;
    }

    public int getIdPuntoInteresse() {
        return idPuntoInteresse;
    }

    public String getNomePuntoInteresse() {
        return nomePuntoInteresse;
    }

    public String getNomePuntoInteresseASCII() {
        return nomePuntoInteresseASCII;
    }

    public String getCodiceNazione() {
        return codiceNazione;
    }

    public String getNomeNazione() {
        return nomeNazione;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setIdPuntoInteresse(int idPuntoInteresse) {
        this.idPuntoInteresse = idPuntoInteresse;
    }

    public void setNomePuntoInteresse(String nomePuntoInteresse) {
        this.nomePuntoInteresse = nomePuntoInteresse;
    }

    public void setNomePuntoInteresseASCII(String nomePuntoInteresseASCII) {
        this.nomePuntoInteresseASCII = nomePuntoInteresseASCII;
    }

    public void setCodiceNazione(String codiceNazione) {
        this.codiceNazione = codiceNazione;
    }

    public void setNomeNazione(String nomeNazione) {
        this.nomeNazione = nomeNazione;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe Paese
     */
    @Override
    public String toString() {
        return nomePuntoInteresseASCII + "," + codiceNazione + "," + latitudine + "," + longitudine;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PuntoInteresse other = (PuntoInteresse) obj;
        return this.nomePuntoInteresseASCII.equals(other.nomePuntoInteresseASCII) &&
               this.codiceNazione.equals(other.codiceNazione);
    }

    
}
