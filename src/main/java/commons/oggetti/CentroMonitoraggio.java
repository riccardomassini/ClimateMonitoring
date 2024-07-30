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
 * La classe {@code CentroMonitoraggio} rappresenta un centro di monitoraggio climatico.
 * Ogni centro è identificato da attributi come nome, indirizzo, numero civico, CAP, comune e provincia.
 * <p>
 * Questa classe implementa l'interfaccia {@code Serializable} per consentire la serializzazione
 * dell'oggetto, utile per la memorizzazione persistente o la trasmissione su una rete.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class CentroMonitoraggio implements Serializable {

    /**
     * Il nome del centro di monitoraggio.
     */
    private String nomeCentro;

    /**
     * L'indirizzo del centro di monitoraggio.
     */
    private String indirizzo;

    /**
     * Il numero civico del centro di monitoraggio.
     */
    private int numeroCivico;

    /**
     * Il codice di avviamento postale (CAP) del centro di monitoraggio.
     */
    private String CAP;

    /**
     * Il comune in cui si trova il centro di monitoraggio.
     */
    private String comune;

    /**
     * La provincia in cui si trova il centro di monitoraggio.
     */
    private String provincia;

    /**
     * Costruttore predefinito. Inizializza un'istanza vuota di {@code CentroMonitoraggio}.
     */
    public CentroMonitoraggio(){
    }

    /**
     * Costruttore con parametri. Inizializza un'istanza di {@code CentroMonitoraggio} con i dettagli forniti.
     *
     * @param nomeCentro  il nome del centro
     * @param indirizzo   l'indirizzo del centro
     * @param numeroCivico il numero civico del centro
     * @param CAP         il codice di avviamento postale del centro
     * @param comune      il comune del centro
     * @param provincia   la provincia del centro
     */
    public CentroMonitoraggio(String nomeCentro, String indirizzo, int numeroCivico, String CAP, String comune, String provincia){
        this();
        this.nomeCentro = nomeCentro;
        this.indirizzo = indirizzo;
        this.numeroCivico = numeroCivico;
        this.CAP = CAP;
        this.comune = comune;
        this.provincia = provincia;
    }

    /**
     * Restituisce il nome del centro di monitoraggio.
     *
     * @return il nome del centro
     */
    public String getNomeCentro() {
        return nomeCentro;
    }

    /**
     * Restituisce l'indirizzo del centro di monitoraggio.
     *
     * @return l'indirizzo del centro
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Restituisce il numero civico del centro di monitoraggio.
     *
     * @return il numero civico
     */
    public int getNumeroCivico() {
        return numeroCivico;
    }

    /**
     * Restituisce il codice di avviamento postale (CAP) del centro di monitoraggio.
     *
     * @return il CAP
     */
    public String getCAP() {
        return CAP;
    }

    /**
     * Restituisce il comune in cui si trova il centro di monitoraggio.
     *
     * @return il comune
     */
    public String getComune() {
        return comune;
    }

    /**
     * Restituisce la provincia in cui si trova il centro di monitoraggio.
     *
     * @return la provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Imposta il nome del centro di monitoraggio.
     *
     * @param nomeCentro il nome del centro
     */
    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    /**
     * Imposta l'indirizzo del centro di monitoraggio.
     *
     * @param indirizzo l'indirizzo del centro
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Imposta il numero civico del centro di monitoraggio.
     *
     * @param numeroCivico il numero civico
     */
    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    /**
     * Imposta il codice di avviamento postale (CAP) del centro di monitoraggio.
     *
     * @param CAP il CAP
     */
    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    /**
     * Imposta il comune in cui si trova il centro di monitoraggio.
     *
     * @param comune il comune
     */
    public void setComune(String comune) {
        this.comune = comune;
    }

    /**
     * Imposta la provincia in cui si trova il centro di monitoraggio.
     *
     * @param provincia la provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto {@code CentroMonitoraggio}.
     *
     * @return una stringa contenente i dettagli del centro
     */
    @Override
    public String toString() {
        return nomeCentro + "," + indirizzo + "," + numeroCivico + "," + CAP + "," + comune + "," + provincia + "\n";
    } 
}