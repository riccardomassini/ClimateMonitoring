package commons.oggetti;

import java.util.*;

/**
 * Classe che contiene tutti gli attributi che formano l'oggetto CentroMonitoraggio
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class CentroMonitoraggio{
    
    /**
     * Stringa che rappresenta il nome del centro di monitoraggio
     */
    private String nome;
    
    /**
     * Stringa che rappresenta la via del centro di monitoraggio
     */
    private String indirizzo;
    
    /**
     * Attributo che rappresenta il numero civico del centro di monitoraggio
     */
    private int numCivico;
    
    /**
     * Attributo che rappresenta il cap del centro di monitoraggio
     */
    private String cap;
    
    /**
     * Stringa che rappresenta il comune del centro di monitoraggio
     */
    private String comune;
    
    /**
     * Stringa che rappresenta la provincia del centro di monitoraggio
     */
    private String provincia;
    
    /**
    * Costruttore vuoto della classe che serve per inizializzarla
    */
    public CentroMonitoraggio(){}

    /**
     * Costruttore pieno che servirà per istanziare l'oggetto di tipo CentroMonitoraggio
     * @param nome nome del centro di monitoraggio
     * @param indirizzo indirizzo del centro di monitoraggio
     * @param numCivico numero civico del centro di monitoraggio
     * @param cap cap del centro di monitoraggio
     * @param comune comune del centro di monitoraggio
     * @param provincia provincia del centro di monitoraggio
     */
    public CentroMonitoraggio(String nome, String indirizzo, int numCivico, String cap, String comune, String provincia){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numCivico = numCivico;
        this.cap = cap;
        this.comune = comune;
        this.provincia = provincia;
    }

    /**
     * Metodo get che ritorna la striga che rappresenta il nome del centro di monitoraggio
     * @return nome del centro di monitoraggio
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo get che ritorna la striga che rappresenta la via del centro di monitoraggio
     * @return via del centro di monitoraggio
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Metodo get che ritorna l'attributo che rappresenta il numero civico del centro di monitoraggio
     * @return id del centro di monitoraggio
     */
    public int getNumCivico() {
        return numCivico;
    }

    /**
     * Metodo get che ritorna l'attributo che rappresenta il cap del centro di monitoraggio
     * @return cap del centro di monitoraggio
     */
    public String getCap() {
        return cap;
    }

    /**
     * Metodo get che ritorna la striga che rappresenta il comune del centro di monitoraggio
     * @return comune del centro di monitoraggio
     */
    public String getComune() {
        return comune;
    }

    /**
     * Metodo get che ritorna la striga che rappresenta la provincia del centro di monitoraggio
     * @return provincia del centro di monitoraggio
     */
    public String getProvincia() {
        return provincia;
    }
    
    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe centroMonitoraggio
     */
    @Override
    public String toString() {
        return nome + "," + indirizzo + "," + numCivico + "," + cap + "," + comune + "," + provincia + "\n";
    } 
}
