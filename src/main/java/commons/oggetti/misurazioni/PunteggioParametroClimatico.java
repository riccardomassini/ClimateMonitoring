package commons.oggetti.misurazioni;

public enum PunteggioParametroClimatico {
    NULLO(0, "nullo"),
    GRAVE(1, "grave"),
    PERICOLOSO(2, "pericoloso"),
    MODERATO(3, "moderato"),
    BUONO(4, "buono"),
    OTTIMALE(5, "ottimale");

    PunteggioParametroClimatico(int punteggio, String descrizione) {
        this.punteggio = punteggio;
        this.descrizione = descrizione;
    }

    private int punteggio;
    private String descrizione;

    public int getPunteggio() {
        return punteggio;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
