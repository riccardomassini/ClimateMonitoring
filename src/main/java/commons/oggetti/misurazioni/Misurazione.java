package commons.oggetti.misurazioni;

import java.io.Serializable;
import java.sql.*;

/**
 * Classe che contiene tutti gli attributi che rappresentano i parametri climatici
 * che l'operatore può registrare su una o più aree di interesse
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @author Nome: Massimiliano De Lorenzo    Matricola: 754160   Sede: CO
 * @version 1.0
 */
public class Misurazione implements Serializable {
    private int idPuntoInteresse;
    private String nomeCentro;
    private Timestamp timestampMisurazione;
    private ValutazioneParametro[] parametriClimatici;

    public Misurazione() {
        parametriClimatici = new ValutazioneParametro[CategorieParametriClimatici.values().length];
    }

    public Misurazione(int idPuntoInteresse, String nomeCentro, Timestamp timestampMisurazione) {
        this();
        this.idPuntoInteresse = idPuntoInteresse;
        this.nomeCentro = nomeCentro;
        this.timestampMisurazione = timestampMisurazione;
    }

    public Misurazione(int idPuntoInteresse, String nomeCentro, Timestamp timestampMisurazione, ValutazioneParametro[] valutazioneParametri) {
        this(idPuntoInteresse, nomeCentro, timestampMisurazione);
        if(valutazioneParametri.length != CategorieParametriClimatici.values().length)
            throw new IllegalArgumentException("Il numero di valutazioni di parametri climatici è errato");
        for (CategorieParametriClimatici categoria : CategorieParametriClimatici.values())
            parametriClimatici[categoria.ordinal()] = valutazioneParametri[categoria.ordinal()];
    }

    public int getIdPuntoInteresse() {
        return idPuntoInteresse;
    }

    public void setIdPuntoInteresse(int idPuntoInteresse) {
        this.idPuntoInteresse = idPuntoInteresse;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    public Timestamp getTimestampMisurazione() {
        return timestampMisurazione;
    }

    public void setTimestampMisurazione(Timestamp timestampMisurazione) {
        this.timestampMisurazione = timestampMisurazione;
    }

    public ValutazioneParametro getParametroConCategoria(CategorieParametriClimatici categoria) {
        return parametriClimatici[categoria.ordinal()];
    }

    public int getValutazioneParametroConCategoria(CategorieParametriClimatici categoria) {
        return parametriClimatici[categoria.ordinal()].getValutazione();
    }

    public String getCommentoParametroConCategoria(CategorieParametriClimatici categoria) {
        return parametriClimatici[categoria.ordinal()].getCommento();
    }

    public void setParametroConCategoria(CategorieParametriClimatici categoria, ValutazioneParametro parametro) {
        parametriClimatici[categoria.ordinal()] = parametro;
    }

    public void setValutazioneParametroConCategoria(CategorieParametriClimatici categoria, int valutazione) {
        parametriClimatici[categoria.ordinal()].setValutazione(valutazione);
    }

    public void setCommentoParametroConCategoria(CategorieParametriClimatici categoria, String commento) {
        parametriClimatici[categoria.ordinal()].setCommento(commento);
    }


}
