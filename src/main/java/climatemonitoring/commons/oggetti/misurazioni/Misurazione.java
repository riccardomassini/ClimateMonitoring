/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.oggetti.misurazioni;

import java.io.Serializable;
import java.sql.*;

/**
 * <p>La classe {@code Misurazione} rappresenta una misurazione di parametri climatici associata
 * a un punto di interesse e registrata da un centro di monitoraggio in un determinato
 * timestamp. La misurazione include un array di {@link ValutazioneParametro} che fornisce
 * valutazioni specifiche per ogni categoria climatica.</p>
 *
 * <p>La classe implementa l'interfaccia {@link Serializable} per consentire la serializzazione
 * degli oggetti {@code Misurazione}.</p>
 *
 * <p>La classe include costruttori per l'inizializzazione con diversi livelli di dettaglio,
 * nonché metodi getter e setter per accedere e modificare i dati della misurazione.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Misurazione implements Serializable {

    /** Identificativo univoco del punto di interesse. */
    private int idPuntoInteresse;

    /** Nome del centro di interesse. */
     private String nomeCentro;

    /** Timestamp della misurazione effettuata. Rappresenta la data e l'ora in cui sono stati raccolti i dati relativi ai parametri climatici. */
    private Timestamp timestampMisurazione;

    /** Array di valutazioni dei parametri climatici misurati. Ogni elemento dell'array rappresenta una valutazione specifica di un parametro climatico. */
    private ValutazioneParametro[] parametriClimatici;

    /**
     * Costruttore predefinito che inizializza l'array di parametri climatici con una dimensione
     * basata sul numero di valori in {@link CategorieParametriClimatici}.
     */
    public Misurazione() {
        parametriClimatici = new ValutazioneParametro[CategorieParametriClimatici.values().length];
    }

    /**
     * Costruttore che inizializza una misurazione con ID del punto di interesse, nome del centro
     * e timestamp della misurazione.
     *
     * @param idPuntoInteresse l'ID del punto di interesse associato alla misurazione
     * @param nomeCentro il nome del centro che ha registrato la misurazione
     * @param timestampMisurazione il timestamp in cui la misurazione è stata registrata
     */
    public Misurazione(int idPuntoInteresse, String nomeCentro, Timestamp timestampMisurazione) {
        this();
        this.idPuntoInteresse = idPuntoInteresse;
        this.nomeCentro = nomeCentro;
        this.timestampMisurazione = timestampMisurazione;
    }

    /**
     * Costruttore che inizializza una misurazione con dettagli completi, inclusi i parametri climatici.
     *
     * @param idPuntoInteresse l'ID del punto di interesse associato alla misurazione
     * @param nomeCentro il nome del centro che ha registrato la misurazione
     * @param timestampMisurazione il timestamp in cui la misurazione è stata registrata
     * @param valutazioneParametri un array di {@link ValutazioneParametro} che fornisce le valutazioni
     *                             per ogni categoria climatica
     * @throws IllegalArgumentException se la lunghezza dell'array di valutazioni non corrisponde al numero di categorie
     */
    public Misurazione(int idPuntoInteresse, String nomeCentro, Timestamp timestampMisurazione, ValutazioneParametro[] valutazioneParametri) {
        this(idPuntoInteresse, nomeCentro, timestampMisurazione);
        if(valutazioneParametri.length != CategorieParametriClimatici.values().length)
            throw new IllegalArgumentException("Il numero di valutazioni di parametri climatici è errato");
        for (CategorieParametriClimatici categoria : CategorieParametriClimatici.values())
            parametriClimatici[categoria.ordinal()] = valutazioneParametri[categoria.ordinal()];
    }

    /**
     * Restituisce l'ID del punto di interesse associato alla misurazione.
     *
     * @return l'ID del punto di interesse
     */
    public int getIdPuntoInteresse() {
        return idPuntoInteresse;
    }

    /**
     * Imposta l'ID del punto di interesse associato alla misurazione.
     *
     * @param idPuntoInteresse l'ID del punto di interesse da associare
     */
    public void setIdPuntoInteresse(int idPuntoInteresse) {
        this.idPuntoInteresse = idPuntoInteresse;
    }

    /**
     * Restituisce il nome del centro che ha registrato la misurazione.
     *
     * @return il nome del centro di monitoraggio
     */
    public String getNomeCentro() {
        return nomeCentro;
    }

    /**
     * Imposta il nome del centro che ha registrato la misurazione.
     *
     * @param nomeCentro il nome del centro di monitoraggio
     */
    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    /**
     * Restituisce il timestamp della misurazione.
     *
     * @return il timestamp della misurazione
     */
    public Timestamp getTimestampMisurazione() {
        return timestampMisurazione;
    }

    /**
     * Imposta il timestamp della misurazione.
     *
     * @param timestampMisurazione il timestamp in cui la misurazione è stata registrata
     */
    public void setTimestampMisurazione(Timestamp timestampMisurazione) {
        this.timestampMisurazione = timestampMisurazione;
    }

    /**
     * Restituisce la valutazione del parametro climatico per una specifica categoria.
     *
     * @param categoria la categoria climatica di interesse
     * @return l'oggetto {@link ValutazioneParametro} associato alla categoria specificata
     */
    public ValutazioneParametro getParametroConCategoria(CategorieParametriClimatici categoria) {
        return parametriClimatici[categoria.ordinal()];
    }

    /**
     * Restituisce la valutazione numerica per una specifica categoria climatica.
     *
     * @param categoria la categoria climatica di interesse
     * @return la valutazione numerica del parametro climatico
     */
    public int getValutazioneParametroConCategoria(CategorieParametriClimatici categoria) {
        return parametriClimatici[categoria.ordinal()].getValutazione();
    }

    /**
     * Restituisce il commento associato al parametro climatico per una specifica categoria.
     *
     * @param categoria la categoria climatica di interesse
     * @return il commento associato al parametro climatico
     */
    public String getCommentoParametroConCategoria(CategorieParametriClimatici categoria) {
        return parametriClimatici[categoria.ordinal()].getCommento();
    }

    /**
     * Imposta l'oggetto {@link ValutazioneParametro} per una specifica categoria climatica.
     *
     * @param categoria la categoria climatica per cui impostare il parametro
     * @param parametro l'oggetto {@link ValutazioneParametro} da associare
     */
    public void setParametroConCategoria(CategorieParametriClimatici categoria, ValutazioneParametro parametro) {
        parametriClimatici[categoria.ordinal()] = parametro;
    }

    /**
     * Imposta la valutazione numerica per una specifica categoria climatica.
     *
     * @param categoria la categoria climatica per cui impostare la valutazione
     * @param valutazione la valutazione numerica da associare
     */
    public void setValutazioneParametroConCategoria(CategorieParametriClimatici categoria, int valutazione) {
        parametriClimatici[categoria.ordinal()].setValutazione(valutazione);
    }

    /**
     * Imposta il commento associato al parametro climatico per una specifica categoria.
     *
     * @param categoria la categoria climatica per cui impostare il commento
     * @param commento il commento da associare
     */
    public void setCommentoParametroConCategoria(CategorieParametriClimatici categoria, String commento) {
        parametriClimatici[categoria.ordinal()].setCommento(commento);
    }
}