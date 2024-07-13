package oggetti;

import java.sql.*;

/**
 * Classe che contiene tutti gli attributi che rappresentano i parametri climatici
 * che l'operatore può registrare su una o più aree di interesse
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class ParametriClimatici{
    
    /**
     * Parametro vento che può avere un valore compreso tra 1 e 5
     */
    private Object vento;
    
    /**
     * Parametro umidità che può avere un valore compreso tra 1 e 5
     */
    private Object umidita;
    
    /**
     * Parametro pressione che può avere un valore compreso tra 1 e 5
     */
    private Object pressione; 
    
    /**
     * Parametro temperatura che può avere un valore compreso tra 1 e 5
     */
    private Object temperatura;
    
    /**
     * Parametro precipitazioni che può avere un valore compreso tra 1 e 5
     */
    private Object precipitazioni; 
    
    /**
     * Parametro altitudine che può avere un valore compreso tra 1 e 5
     */
    private Object altitudine;
    
    /**
     * Parametro massa che può avere un valore compreso tra 1 e 5
     */
    private Object massa;
    
    /**
     * Stringa che contiene una data
     */
    private Timestamp data;
    
    /**
     * Stringa che contiene le note di vento
     */
    private String noteV;
    
    /**
     * Stringa che contiene le note di umidità
     */
    private String noteU;
    
    /**
     * Stringa che contiene le note di pressione
     */
    private String notePres;
    
    /**
     * Stringa che contiene le note di temperatura
     */
    private String noteT;
    
    /**
     * Stringa che contiene le note di precipitazioni
     */
    private String notePrec;
    
    /**
     * Stringa che contiene le note di altitudine
     */
    private String noteA;
    
    /**
     * Stringa che contiene le note di massa
     */
    private String noteM;
    
    /**
     * Stringa che contiene il nome del centro di monitoraggio
     */
    private String nomeC;
    
    /**
     * Oggetto di tipo Paese che contiene il nome del paese, il codice e relative latitudine e longitudine
     */
    private Paese paese;

    /**
     * Costruttore vuoto della classe che serve per inizializzarla
     */
    public ParametriClimatici(){}
    
    /**
     * Costruttore pieno che servirà per istanziare l'oggetto di tipo ParametriClimatici
     * @param nomeC nome del centro
     * @param paese oggetto di tipo Paese
     * @param data stringa che rappresenta una data
     * @param vento attributo vento
     * @param noteV attributo che contiene le note di vento
     * @param umidita attributo umidità
     * @param noteU attributo che contiene le note di umidità
     * @param pressione attributo pressione
     * @param notePres attributo che contiene le note di pressione
     * @param temperatura attributo temperatura
     * @param noteT attributo che contiene le note di temperatura
     * @param precipitazioni attributo precipitazioni
     * @param notePrec attributo che contiene le note di precipitazioni
     * @param altitudine attributo altitudine
     * @param noteA attributo che contiene le note di altitudine
     * @param massa attributo massa
     * @param noteM attributo che contiene le note di massa
     */
    public ParametriClimatici(String nomeC, Paese paese, Timestamp data, Object vento, String noteV, Object umidita, String noteU, Object pressione, String notePres, 
            Object temperatura, String noteT, Object precipitazioni, String notePrec, Object altitudine, String noteA, Object massa, String noteM){
        
        this.nomeC = nomeC;
        this.paese = paese;
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

    /**
     * Metodo get che ritorna l'attributo vento
     * @return attributo vento
     */
    public Object getVento() {
        return vento;
    }

    /**
     * Metodo get che ritorna l'attributo umidità
     * @return attributo umidità
     */
    public Object getUmidita() {
        return umidita;
    }

    /**
     * Metodo get che ritorna l'attributo pressione
     * @return attributo pressione
     */
    public Object getPressione() {
        return pressione;
    }

    /**
     * Metodo get che ritorna l'attributo temperatura
     * @return attributo temperatura
     */
    public Object getTemperatura() {
        return temperatura;
    }

    /**
     * Metodo get che ritorna l'attributo precipitazioni
     * @return attributo precipitazioni
     */
    public Object getPrecipitazioni() {
        return precipitazioni;
    }

    /**
     * Metodo get che ritorna l'attributo altitudine
     * @return attributo altitudine
     */
    public Object getAltitudine() {
        return altitudine;
    }

    /**
     * Metodo get che ritorna l'attributo massa
     * @return attributo massa
     */
    public Object getMassa() {
        return massa;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di vento
     * @return attributo noteV
     */
    public String getNoteV() {
        return noteV;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di umidità
     * @return attributo noteU
     */
    public String getNoteU() {
        return noteU;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di pressione
     * @return attributo notePres
     */
    public String getNotePres() {
        return notePres;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di temperatura
     * @return attributo noteT
     */
    public String getNoteT() {
        return noteT;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di precipitazioni
     * @return attributo notePrec
     */
    public String getNotePrec() {
        return notePrec;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di altitudine
     * @return attributo noteA
     */
    public String getNoteA() {
        return noteA;
    }

    /**
     * Metodo get che ritorna la stringa che contiene le note di massa
     * @return attributo noteM
     */
    public String getNoteM() {
        return noteM;
    }

    /**
     * Metodo get che ritorna la stringa che contiene una data
     * @return attributo data
     */
    public Timestamp getData() {
        return data;
    }

    /**
     * Metodo get che ritorna la stringa che contiene il nome del centro di monitoraggio
     * @return attributo nomeC
     */
    public String getNomeC() {
        return nomeC;
    }

    /**
     * Metodo get che ritorna l'oggetto di tipo Paese
     * @return oggetto paese
     */
    public Paese getPaese() {
        return paese;
    }
    
    

    /**
     * Metodo toString che permette di stampare tutti gli attributi nell'ordine seguente
     * @return stringa concatena che contiene tutti gli attributi della classe ParametriClimatici
     */
    @Override
    public String toString() {
        return nomeC + "," + paese.toString() + "," + data + "," + vento + "," + umidita + "," + pressione + "," + temperatura + "," + precipitazioni 
        + "," + altitudine + "," + massa + "," + noteV + "," + noteU + "," + notePres + "," +  noteT
        + "," + notePrec + "," + noteA + "," + noteM + "\n";
    }  
}
