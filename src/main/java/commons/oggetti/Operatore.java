package commons.oggetti;

import java.io.Serializable;

/**
 * Classe che contiene tutti gli attributi che formano l'oggetto Operatore
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class Operatore implements Serializable {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private int username;
    private String password;
    private String idCentroMonitoraggio;
    
    
    public Operatore() {
        
    }

    public Operatore(int username, String password){
        this();
        this.username = username;
        this.password = password;
    }

    public Operatore(String nome, String cognome, String codiceFiscale, String email, int username, String password){
        this(username, password);
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
    }

    public Operatore(String nome, String cognome, String codiceFiscale, String email, int username, String password, String idCentroMonitoraggio){
        this(nome, cognome, codiceFiscale, email, username, password);
        this.idCentroMonitoraggio = idCentroMonitoraggio;
    }
    
    public int getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIdCentroMonitoraggio() {
        return idCentroMonitoraggio;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdCentroMonitoraggio(String idCentroMonitoraggio) {
        this.idCentroMonitoraggio = idCentroMonitoraggio;
    }

    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe Operatore
     */
    @Override
    public String toString() {
        return nome + "," + codiceFiscale + "," + email + "," + username + "," + password + "," + idCentroMonitoraggio + "\n";
    }
}
