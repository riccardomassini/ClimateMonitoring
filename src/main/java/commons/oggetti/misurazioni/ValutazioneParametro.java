package commons.oggetti.misurazioni;

import java.io.Serializable;

public class ValutazioneParametro implements Serializable {
    public static final int LUNGHEZZA_COMMENTO_MAX = 256;

    private int valutazione;
    private String commento;

    public ValutazioneParametro() {
        valutazione = PunteggioParametroClimatico.NULLO.getPunteggio();
        commento = "";
    }
    public ValutazioneParametro(int valutazione, String commento) {
        this();
        this.valutazione = valutazione;
        this.commento = commento;
    }

    public ValutazioneParametro(PunteggioParametroClimatico valutazione, String commento) {
        this(valutazione.getPunteggio(), commento);
    }

    public int getValutazione() {
        return valutazione;
    }

    public String getCommento() {
        return commento;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public void setValutazione(PunteggioParametroClimatico valutazione) {
        this.valutazione = valutazione.getPunteggio();
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public static boolean lunghezzaCommentoValida(String commento) {
        return commento.length() <= LUNGHEZZA_COMMENTO_MAX;
    }

}
