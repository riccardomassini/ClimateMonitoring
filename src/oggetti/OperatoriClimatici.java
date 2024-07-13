package oggetti;

/**
 * Classe che contiene tutti gli attributi che formano l'oggetto OperatoriClimatici
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class OperatoriClimatici{
    
    /**
     * Stringa che rappresenta il nome di un Operatore Climatico
     */
    private String nome;
    
    private String cognome;
    
    /**
     * Stringa che rappresenta il codice fiscale di un Operatore Climatico
     */
    private String cf;
    
    /**
     * Stringa che rappresenta la mail di un Operatore Climatico
     */
    private String mail;
    
    /**
     * Attributo che rappresenta l'id di un Operatore Climatico
     */
    private int userID;
    
    /**
     * Stringa che rappresenta la password di un Operatore Climatico
     */
    private String password;
    
    /**
     * Stringa che rappresenta il centro di appartenenza di un Operatore Climatico
     */
    private String centroM;
    
    /**
     * Costruttore vuoto della classe che serve per inizializzarla
     */
    public OperatoriClimatici(){}

    /**
     * Costruttore pieno che servirà per istanziare l'oggetto di tipo OperatoriClimatici
     * @param nome nome dell'operatore
     * @param cf codice fiscale dell'operatore
     * @param mail mail dell'operatore
     * @param userID id dell'operatore
     * @param password password dell'operatore
     * @param centroM centro di appartenenza dell'operatore
     */
    public OperatoriClimatici(String nome, String cognome, String cf, String mail, int userID, String password, String centroM){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.mail = mail;
        this.userID = userID;
        this.password = password;
        this.centroM = centroM;
    }
    
    public OperatoriClimatici(String nome, String cognome, String cf, String mail, int userID, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.mail = mail;
        this.userID = userID;
        this.password = password;
    }
    
    public OperatoriClimatici(int userID, String password){
        this.userID = userID;
        this.password = password;
    }

    /**
     * Metodo get che ritorna l'attributo che rappresenta il nome dell'operatore
     * @return id dell'operatore
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Metodo get che ritorna la stringa che rappresenta la password dell'operatore
     * @return password dell'operatore
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo get che ritorna la stringa che rappresenta il centro di appartenenza dell'operatore
     * @return centro dell'operatore
     */
    public String getCentroM() {
        return centroM;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    public String getMail() {
        return mail;
    }

    /**
     * Metodo che permette di assegnare al centro un valore
     * @param centroM centro dell'operatore
     */
    public void setCentroM(String centroM) {
        this.centroM = centroM;
    }

    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe OperatoriClimatici
     */
    @Override
    public String toString() {
        return nome + "," + cf + "," + mail + "," + userID + "," + password + "," + centroM+ "\n";
    }
}
