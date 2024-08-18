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
 * La classe {@code Operatore} rappresenta un operatore di un centro di monitoraggio.
 * Include informazioni personali e di accesso come nome, cognome, codice fiscale, email, username, password e ID del centro di monitoraggio.
 * <p>
 * Questa classe implementa l'interfaccia {@code Serializable} per consentire la serializzazione
 * dell'oggetto, utile per la memorizzazione persistente o la trasmissione su una rete.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Operatore implements Serializable {

    /**
     * Il nome dell'operatore.
     */
    private String nome;

    /**
     * Il cognome dell'operatore.
     */
    private String cognome;

    /**
     * Il codice fiscale dell'operatore.
     */
    private String codiceFiscale;

    /**
     * L'email dell'operatore.
     */
    private String email;

    /**
     * Lo username utilizzato dall'operatore per l'accesso.
     */
    private int username;

    /**
     * La password utilizzata dall'operatore per l'accesso.
     */
    private String password;

    /**
     * L'identificativo del centro di monitoraggio a cui appartiene l'operatore.
     */
    private String idCentroMonitoraggio;

    /**
     * Costruttore predefinito. Inizializza un'istanza vuota di {@code Operatore}.
     */
    public Operatore() {}

    /**
     * Costruttore che inizializza l'operatore con username e password.
     *
     * @param username lo username dell'operatore
     * @param password la password dell'operatore
     */
    public Operatore(int username, String password){
        this();
        this.username = username;
        this.password = password;
    }

    /**
     * Costruttore che inizializza l'operatore con informazioni personali e credenziali di accesso.
     *
     * @param nome           il nome dell'operatore
     * @param cognome        il cognome dell'operatore
     * @param codiceFiscale  il codice fiscale dell'operatore
     * @param email          l'email dell'operatore
     * @param username       lo username dell'operatore
     * @param password       la password dell'operatore
     */
    public Operatore(String nome, String cognome, String codiceFiscale, String email, int username, String password){
        this(username, password);
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
    }

    /**
     * Costruttore che inizializza l'operatore con informazioni personali, credenziali di accesso e ID del centro di monitoraggio.
     *
     * @param nome                  il nome dell'operatore
     * @param cognome               il cognome dell'operatore
     * @param codiceFiscale         il codice fiscale dell'operatore
     * @param email                 l'email dell'operatore
     * @param username              lo username dell'operatore
     * @param password              la password dell'operatore
     * @param idCentroMonitoraggio  l'ID del centro di monitoraggio a cui appartiene l'operatore
     */
    public Operatore(String nome, String cognome, String codiceFiscale, String email, int username, String password, String idCentroMonitoraggio){
        this(nome, cognome, codiceFiscale, email, username, password);
        this.idCentroMonitoraggio = idCentroMonitoraggio;
    }

    /**
     * Restituisce lo username dell'operatore.
     *
     * @return lo username dell'operatore
     */
    public int getUsername() {
        return username;
    }

    /**
     * Restituisce la password dell'operatore.
     *
     * @return la password dell'operatore
     */
    public String getPassword() {
        return password;
    }

    /**
     * Restituisce l'ID del centro di monitoraggio a cui appartiene l'operatore.
     *
     * @return l'ID del centro di monitoraggio
     */
    public String getIdCentroMonitoraggio() {
        return idCentroMonitoraggio;
    }

    /**
     * Restituisce il nome dell'operatore.
     *
     * @return il nome dell'operatore
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il cognome dell'operatore.
     *
     * @return il cognome dell'operatore
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Restituisce il codice fiscale dell'operatore.
     *
     * @return il codice fiscale dell'operatore
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Restituisce l'email dell'operatore.
     *
     * @return l'email dell'operatore
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il nome dell'operatore.
     *
     * @param nome il nome dell'operatore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta il cognome dell'operatore.
     *
     * @param cognome il cognome dell'operatore
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Imposta il codice fiscale dell'operatore.
     *
     * @param codiceFiscale il codice fiscale dell'operatore
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Imposta l'email dell'operatore.
     *
     * @param email l'email dell'operatore
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Imposta lo username dell'operatore.
     *
     * @param username lo username dell'operatore
     */
    public void setUsername(int username) {
        this.username = username;
    }

    /**
     * Imposta la password dell'operatore.
     *
     * @param password la password dell'operatore
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Imposta l'ID del centro di monitoraggio a cui appartiene l'operatore.
     *
     * @param idCentroMonitoraggio l'ID del centro di monitoraggio
     */
    public void setIdCentroMonitoraggio(String idCentroMonitoraggio) {
        this.idCentroMonitoraggio = idCentroMonitoraggio;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto {@code Operatore}.
     *
     * @return una stringa contenente i dettagli dell'operatore
     */
    @Override
    public String toString() {
        return nome + "," + codiceFiscale + "," + email + "," + username + "," + password + "," + idCentroMonitoraggio + "\n";
    }
}