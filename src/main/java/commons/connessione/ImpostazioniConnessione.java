/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.connessione;

/**
 * <p>La classe {@code ImpostazioniConnessione} contiene le configurazioni predefinite per la connessione
 * RMI (Remote Method Invocation). Questa classe fornisce parametri statici per la porta e l'indirizzo
 * del server RMI, nonché i nomi di registrazione degli oggetti remoti.</p>
 *
 * <p>Le costanti di configurazione sono:</p>
 * <ul>
 *     <li>{@link #RMI_GestioneCentriMonitoraggio}: Il nome di registrazione dell'oggetto remoto per la gestione dei centri di monitoraggio.</li>
 *     <li>{@link #RMI_Autenticazione}: Il nome di registrazione dell'oggetto remoto per il servizio di autenticazione.</li>
 *     <li>{@link #RMI_RicercaPuntiInteresse}: Il nome di registrazione dell'oggetto remoto per il servizio di ricerca dei punti di interesse.</li>
 *     <li>{@link #RMI_GestioneMisurazioni}: Il nome di registrazione dell'oggetto remoto per la gestione delle misurazioni.</li>
 * </ul>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ImpostazioniConnessione {

    /** Costruttore vuoto */
    public ImpostazioniConnessione(){}

    /** Nome del progetto che serve per calcolare il percorso per poter accedere alla root */
    public static String targetDir = "ClimateMonitoring";

    /**
     * Nome di registrazione dell'oggetto remoto per la gestione dei centri di monitoraggio.
     */
    public static final String RMI_GestioneCentriMonitoraggio = "CentriMonitoraggio";

    /**
     * Nome di registrazione dell'oggetto remoto per il servizio di autenticazione.
     */
    public static final String RMI_Autenticazione = "Autenticazione";

    /**
     * Nome di registrazione dell'oggetto remoto per il servizio di ricerca dei punti di interesse.
     */
    public static final String RMI_RicercaPuntiInteresse = "PuntiInteresse";

    /**
     * Nome di registrazione dell'oggetto remoto per la gestione delle misurazioni.
     */
    public static final String RMI_GestioneMisurazioni= "Misurazioni";

    /**
     * Estrae e restituisce la porzione del percorso completo fornito che include la directory target specificata.
     *
     * <p>Questo metodo cerca la prima occorrenza della directory target all'interno del percorso completo fornito,
     * quindi restituisce la sottostringa che inizia dall'inizio del percorso completo e termina con l'ultimo carattere
     * della directory target.</p>
     *
     * @param fullPath il percorso completo del file come {@code String} dal quale deve essere estratta una sottostringa.
     * @return una {@code String} che rappresenta la porzione del percorso completo che termina con la directory target specificata.
     * @throws StringIndexOutOfBoundsException se la directory target non viene trovata all'interno del percorso completo,
     *                                         o se {@code targetDir} è una stringa vuota.
     */
    public static String getPath(String fullPath){
        int targetIndex = fullPath.indexOf(targetDir);
        return fullPath.substring(0, targetIndex + targetDir.length());
    }
}
