package commons.oggetti;

import java.sql.*;

/**
 * Classe che contiene tutti gli attributi che rappresentano i parametri climatici
 * che l'operatore può registrare su una o più aree di interesse
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class ParametriClimatici{
    
    private int geonameid;
    
    /**
     * Stringa che contiene il nome del centro di monitoraggio
     */
    private String nomeC;
    
    /**
     * Stringa che contiene una data
     */
    private Timestamp data;
    
    /**
     * Parametro vento che può avere un valore compreso tra 1 e 5
     */
    private Object vento;
    
    /**
     * Stringa che contiene le note di vento
     */
    private String noteV;
    
    /**
     * Parametro umidità che può avere un valore compreso tra 1 e 5
     */
    private Object umidita;
    
    /**
     * Stringa che contiene le note di umidità
     */
    private String noteU;
    
    /**
     * Parametro pressione che può avere un valore compreso tra 1 e 5
     */
    private Object pressione; 
    
    /**
     * Stringa che contiene le note di pressione
     */
    private String notePres;
    
    /**
     * Parametro temperatura che può avere un valore compreso tra 1 e 5
     */
    private Object temperatura;
    
    /**
     * Stringa che contiene le note di temperatura
     */
    private String noteT;
    
    /**
     * Parametro precipitazioni che può avere un valore compreso tra 1 e 5
     */
    private Object precipitazioni; 
    
    /**
     * Stringa che contiene le note di precipitazioni
     */
    private String notePrec;
    
    /**
     * Parametro altitudine che può avere un valore compreso tra 1 e 5
     */
    private Object altitudine;
    
    /**
     * Stringa che contiene le note di altitudine
     */
    private String noteA;
    
    /**
     * Parametro massa che può avere un valore compreso tra 1 e 5
     */
    private Object massa;
    
    /**
     * Stringa che contiene le note di massa
     */
    private String noteM;

    
    public ParametriClimatici(int geonameid, String nomeC, Timestamp data, Object vento, String noteV, Object umidita, String noteU, Object pressione, String notePres, Object temperatura, String noteT, Object precipitazioni, String notePrec, Object altitudine, String noteA, Object massa, String noteM) {
        this.geonameid = geonameid;
        this.nomeC = nomeC;
        this.data = data;
        this.vento = vento;
        this.noteV = noteV;
        this.umidita = umidita;
        this.noteU = noteU;
        this.pressione = pressione;
        this.notePres = notePres;
        this.temperatura = temperatura;
        this.noteT = noteT;
        this.precipitazioni = precipitazioni;
        this.notePrec = notePrec;
        this.altitudine = altitudine;
        this.noteA = noteA;
        this.massa = massa;
        this.noteM = noteM;
    }

    public int getGeonameid() {
        return geonameid;
    }

    public String getNomeC() {
        return nomeC;
    }

    public Timestamp getData() {
        return data;
    }

    public Object getVento() {
        return vento;
    }

    public Object getUmidita() {
        return umidita;
    }

    public Object getPressione() {
        return pressione;
    }

    public Object getTemperatura() {
        return temperatura;
    }

    public Object getPrecipitazioni() {
        return precipitazioni;
    }

    public Object getAltitudine() {
        return altitudine;
    }

    public Object getMassa() {
        return massa;
    }

    public String getNoteV() {
        return noteV;
    }

    public String getNoteU() {
        return noteU;
    }

    public String getNotePres() {
        return notePres;
    }

    public String getNoteT() {
        return noteT;
    }

    public String getNotePrec() {
        return notePrec;
    }

    public String getNoteA() {
        return noteA;
    }

    public String getNoteM() {
        return noteM;
    } 
}
