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
 * <p>L'enumerazione {@code CategorieParametriClimatici} definisce le categorie di parametri climatici
 * che possono essere misurati e monitorati. Ogni elemento rappresenta un tipo specifico di parametro climatico.</p>
 *
 * <p>Questa enumerazione è serializzabile e può essere utilizzata per trasmettere informazioni sui tipi di
 * parametri climatici attraverso una rete o per salvarli in un file.</p>
 *
 * <p>Le categorie disponibili sono:</p>
 * <ul>
 *     <li>{@link #VENTO}: Indica la velocità e la direzione del vento.</li>
 *     <li>{@link #UMIDITA}: Indica il livello di umidità presente nell'aria.</li>
 *     <li>{@link #PRESSIONE}: Indica la pressione atmosferica.</li>
 *     <li>{@link #TEMPERATURA}: Indica la temperatura dell'ambiente.</li>
 *     <li>{@link #PRECIPITAZIONI}: Indica la quantità di precipitazioni, come pioggia o neve.</li>
 *     <li>{@link #ALTITUDINE_GHIACCIAI}: Indica l'altitudine dei ghiacciai, utile per monitorare i cambiamenti nel tempo.</li>
 *     <li>{@link #MASSA_GHIACCIAI}: Indica la massa dei ghiacciai, utilizzata per studi sui cambiamenti climatici.</li>
 * </ul>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public enum CategorieParametriClimatici implements Serializable {

    /**
     * Parametro climatico relativo alla velocità e alla direzione del vento.
     */
    VENTO,

    /**
     * Parametro climatico relativo al livello di umidità nell'aria.
     */
    UMIDITA,

    /**
     * Parametro climatico relativo alla pressione atmosferica.
     */
    PRESSIONE,

    /**
     * Parametro climatico relativo alla temperatura dell'ambiente.
     */
    TEMPERATURA,

    /**
     * Parametro climatico relativo alla quantità di precipitazioni, come pioggia o neve.
     */
    PRECIPITAZIONI,

    /**
     * Parametro climatico relativo all'altitudine dei ghiacciai, utilizzato per monitorare i cambiamenti nel tempo.
     */
    ALTITUDINE_GHIACCIAI,

    /**
     * Parametro climatico relativo alla massa dei ghiacciai, importante per gli studi sui cambiamenti climatici.
     */
    MASSA_GHIACCIAI
}