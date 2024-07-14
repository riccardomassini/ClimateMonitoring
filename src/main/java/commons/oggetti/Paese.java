package commons.oggetti;

/**
 * Classe che contiene tutti gli attributi che formano l'oggetto Paese
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class Paese{
    
    private int geonameID;
    private String name;
    
    /**
     * Stringa che rappresenta il nome del Paese in ascii code
     */
    private String asname;
    
    /**
     * Stringa che rappresenta il codice del Paese
     */
    private String  cc;
    private String cname;
    
    /**
     * Attributo che indica la latitudine
     */
    private double lat;
    
    /**
     * Attributo che indica la longitudine
     */
    private double lon;
    
    /**
     * Costruttore vuoto della classe che serve per inizializzarla
     */
    public Paese(){}

    /**
     * Costruttore pieno che servirà per istanziare l'oggetto di tipo Paese
     * @param asname nome del Paese
     * @param cc codice del Paese
     * @param lat latitudine del Paese
     * @param lon longitudine del Paese
     */
    public Paese(int geonameID, String name, String asname, String cc, String cname, double lat, double lon) {
        this.geonameID = geonameID;
        this.name = name;
        this.asname = asname;
        this.cc = cc;
        this.cname = cname;
        this.lat = lat;
        this.lon = lon;
    }

    public int getGeonameID() {
        return geonameID;
    }

    public String getName() {
        return name;
    }

    public String getAsname() {
        return asname;
    }

    public String getCc() {
        return cc;
    }

    public String getCname() {
        return cname;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
    
    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe Paese
     */
    @Override
    public String toString() {
        return asname + "," + cc + "," + lat + "," + lon;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paese other = (Paese) obj;
        return this.asname.equals(other.asname) &&
               this.cc.equals(other.cc);
    }

    
}
