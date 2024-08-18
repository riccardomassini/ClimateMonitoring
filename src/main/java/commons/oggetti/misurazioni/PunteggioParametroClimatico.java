/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.oggetti.misurazioni;

/**
 * <p>Enumerazione {@code PunteggioParametroClimatico} rappresenta i livelli di valutazione
 * per i parametri climatici. Ogni livello ha un punteggio numerico e una descrizione associata.</p>
 *
 * <p>Questa enumerazione è utilizzata per classificare la qualità dei parametri climatici
 * misurati, con valori che vanno da "Nullo" a "Ottimale".</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public enum PunteggioParametroClimatico {

    /**
     * Indica un parametro climatico nullo, con punteggio 0.
     */
    NULLO(0, "nullo"),

    /**
     * Indica un parametro climatico grave, con punteggio 1.
     */
    GRAVE(1, "grave"),

    /**
     * Indica un parametro climatico pericoloso, con punteggio 2.
     */
    PERICOLOSO(2, "pericoloso"),

    /**
     * Indica un parametro climatico moderato, con punteggio 3.
     */
    MODERATO(3, "moderato"),

    /**
     * Indica un parametro climatico buono, con punteggio 4.
     */
    BUONO(4, "buono"),

    /**
     * Indica un parametro climatico ottimale, con punteggio 5.
     */
    OTTIMALE(5, "ottimale");

    /**
     * Il punteggio numerico associato al livello di parametro climatico.
     */
    private int punteggio;

    /**
     * La descrizione testuale associata al livello di parametro climatico.
     */
    private String descrizione;

    /**
     * Costruttore per l'enum {@code PunteggioParametroClimatico}.
     *
     * @param punteggio    il punteggio numerico associato al livello di parametro climatico
     * @param descrizione  una descrizione testuale del livello di parametro climatico
     */
    PunteggioParametroClimatico(int punteggio, String descrizione) {
        this.punteggio = punteggio;
        this.descrizione = descrizione;
    }

    /**
     * Restituisce il punteggio numerico associato al livello di parametro climatico.
     *
     * @return il punteggio numerico
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Restituisce la descrizione testuale associata al livello di parametro climatico.
     *
     * @return la descrizione del livello di parametro climatico
     */
    public String getDescrizione() {
        return descrizione;
    }
}