/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.oggetti.misurazioni;

import java.io.Serializable;

/**
 * La classe {@code ValutazioneParametro} rappresenta una valutazione di un parametro climatico,
 * includendo un punteggio numerico e un commento opzionale.
 * <p>
 * Questa classe implementa l'interfaccia {@code Serializable} per consentire la serializzazione
 * dell'oggetto, utile in contesti come la memorizzazione persistente o la trasmissione di oggetti
 * tramite reti.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ValutazioneParametro implements Serializable {

    /**
     * La lunghezza massima consentita per il commento descrittivo.
     */
    public static final int LUNGHEZZA_COMMENTO_MAX = 256;

    /**
     * Il punteggio numerico associato al parametro climatico.
     */
    private int valutazione;

    /**
     * Un commento che fornisce ulteriori dettagli sulla valutazione.
     */
    private String commento;

    /**
     * Costruttore predefinito che inizializza la valutazione con il punteggio di {@code NULLO}
     * e il commento come una stringa vuota.
     */
    public ValutazioneParametro() {
        valutazione = PunteggioParametroClimatico.NULLO.getPunteggio();
        commento = "";
    }

    /**
     * Costruttore che accetta un punteggio numerico e un commento per inizializzare la valutazione.
     *
     * @param valutazione il punteggio numerico del parametro climatico
     * @param commento    un commento descrittivo per la valutazione
     */
    public ValutazioneParametro(int valutazione, String commento) {
        this();
        this.valutazione = valutazione;
        this.commento = commento;
    }

    /**
     * Costruttore che accetta un'istanza di {@code PunteggioParametroClimatico} e un commento
     * per inizializzare la valutazione.
     *
     * @param valutazione il punteggio del parametro climatico come istanza di {@code PunteggioParametroClimatico}
     * @param commento    un commento descrittivo per la valutazione
     */
    public ValutazioneParametro(PunteggioParametroClimatico valutazione, String commento) {
        this(valutazione.getPunteggio(), commento);
    }

    /**
     * Restituisce il punteggio numerico della valutazione del parametro climatico.
     *
     * @return il punteggio numerico della valutazione
     */
    public int getValutazione() {
        return valutazione;
    }

    /**
     * Restituisce il commento descrittivo associato alla valutazione del parametro climatico.
     *
     * @return il commento descrittivo
     */
    public String getCommento() {
        return commento;
    }

    /**
     * Imposta il punteggio numerico per la valutazione del parametro climatico.
     *
     * @param valutazione il nuovo punteggio numerico
     */
    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    /**
     * Imposta il punteggio numerico utilizzando un'istanza di {@code PunteggioParametroClimatico}.
     *
     * @param valutazione il nuovo punteggio come istanza di {@code PunteggioParametroClimatico}
     */
    public void setValutazione(PunteggioParametroClimatico valutazione) {
        this.valutazione = valutazione.getPunteggio();
    }

    /**
     * Imposta il commento descrittivo per la valutazione del parametro climatico.
     *
     * @param commento il nuovo commento descrittivo
     */
    public void setCommento(String commento) {
        this.commento = commento;
    }

    /**
     * Verifica se la lunghezza del commento è valida, ovvero se non supera
     * la lunghezza massima definita da {@link #LUNGHEZZA_COMMENTO_MAX}.
     *
     * @param commento il commento da verificare
     * @return {@code true} se la lunghezza del commento è valida, {@code false} altrimenti
     */
    public static boolean lunghezzaCommentoValida(String commento) {
        return commento.length() <= LUNGHEZZA_COMMENTO_MAX;
    }
}