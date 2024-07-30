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
 *     <li>{@link #PORTA}: La porta predefinita su cui il server RMI ascolta le richieste.</li>
 *     <li>{@link #HOST}: L'indirizzo IP predefinito del server RMI.</li>
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

    /**
     * Porta predefinita su cui il server RMI ascolta le richieste.
     */
    public static int PORTA = 10000;

    /**
     * Indirizzo IP predefinito del server RMI.
     */
    public static String HOST = "127.0.0.1";

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
}
