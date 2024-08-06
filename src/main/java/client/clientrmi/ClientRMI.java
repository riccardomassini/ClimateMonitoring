/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package client.clientrmi;

import static commons.connessione.ImpostazioniConnessione.*;
import commons.servizio.Autenticazione;
import commons.servizio.GestioneCentriMonitoraggio;
import commons.servizio.GestioneMisurazioni;
import commons.servizio.RicercaPuntiInteresse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

/**
 * <p>La classe {@code ClientRMI} è responsabile di stabilire una connessione con il server RMI
 * e di recuperare gli stub dei servizi remoti disponibili. La classe implementa un pattern Singleton
 * per garantire che venga creata una sola istanza dell'oggetto client RMI, fornendo un metodo
 * statico per ottenere tale istanza.</p>
 *
 * <p>Gli stub recuperati includono:</p>
 * <ul>
 *     <li>{@link commons.servizio.Autenticazione}: per la gestione delle operazioni di autenticazione</li>
 *     <li>{@link commons.servizio.GestioneMisurazioni}: per la gestione delle misurazioni</li>
 *     <li>{@link commons.servizio.GestioneCentriMonitoraggio}: per la gestione dei centri di monitoraggio</li>
 *     <li>{@link commons.servizio.RicercaPuntiInteresse}: per la gestione delle operazioni di ricerca di punti di interesse</li>
 * </ul>
 *
 * <p>Il client si connette a un registro RMI specificato dai parametri <code>HOST</code> e {@code PORTA}
 * definiti nella classe {@code commons.connessione.ImpostazioniConnessione}.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ClientRMI {

    /** Stub per l'autenticazione degli operatori. */
    private Autenticazione stubAutenticazione;

    /** Stub per la ricerca dei punti di interesse. */
    private RicercaPuntiInteresse stubRicercaPuntiInteresse;

    /** Stub per la gestione dei centri di monitoraggio. */
    private GestioneCentriMonitoraggio stubGestioneCentriMonitoraggio;

    /** Stub per la gestione delle misurazioni. */
    private GestioneMisurazioni stubGestioneMisurazioni;

    /** Oggetto Registry per RMI. */
    private Registry registroRMI;

    /** Oggetto Properties per il file di configurazione. */
    private Properties properties = new Properties();

    /**
     * Costruttore privato della classe {@code ClientRMI} che stabilisce la connessione con il registro RMI
     * e inizializza gli stub per i servizi remoti. Gestisce eventuali eccezioni di connessione
     * e di recupero degli oggetti remoti.
     */
    private ClientRMI() {
        String host = null;
        int port = 0;
        try {
            try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/../config.properties")) {
                properties.load(input);
                host = properties.getProperty("host");
                port = Integer.parseInt(properties.getProperty("port"));
                System.out.println("HOST: " +host);
                System.out.println("PORT: " +port);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            registroRMI = LocateRegistry.getRegistry(host, port);
            stubAutenticazione = (Autenticazione) registroRMI.lookup(RMI_Autenticazione);
            stubGestioneMisurazioni = (GestioneMisurazioni) registroRMI.lookup(RMI_GestioneMisurazioni);
            stubGestioneCentriMonitoraggio = (GestioneCentriMonitoraggio) registroRMI.lookup(RMI_GestioneCentriMonitoraggio);
            stubRicercaPuntiInteresse = (RicercaPuntiInteresse) registroRMI.lookup(RMI_RicercaPuntiInteresse);
        } catch (RemoteException e) {} catch (NotBoundException e) {}
    }

    /**
     * Metodo statico che restituisce un'istanza della classe {@code ClientRMI}. Implementa il pattern
     * Singleton per garantire che esista una sola istanza di questa classe.
     *
     * @return istanza singleton di {@code ClientRMI}
     */
    public static ClientRMI ottieniClientRMI() {
        return new ClientRMI();
    }

    /**
     * Restituisce l'oggetto stub per il servizio di autenticazione.
     *
     * @return l'oggetto stub per {@link commons.servizio.Autenticazione}
     */
    public Autenticazione ottieniStubAutenticazione() {
        return stubAutenticazione;
    }

    /**
     * Restituisce l'oggetto stub per il servizio di ricerca dei punti di interesse.
     *
     * @return l'oggetto stub per {@link commons.servizio.RicercaPuntiInteresse}
     * */
    public RicercaPuntiInteresse ottieniStubRicercaPuntiInteresse() {
        return stubRicercaPuntiInteresse;
    }

    /**
     * Restituisce l'oggetto stub per il servizio di gestione delle misurazioni.
     *
     * @return l'oggetto stub per {@link commons.servizio.GestioneMisurazioni}
     */
    public GestioneMisurazioni ottieniStubGestioneMisurazioni() {
        return stubGestioneMisurazioni;
    }

    /**
     * Restituisce l'oggetto stub per il servizio di gestione dei centri di monitoraggio.
     *
     * @return l'oggetto stub per {@link commons.servizio.GestioneCentriMonitoraggio}
     */
    public GestioneCentriMonitoraggio ottieniStubGestioneCentriMonitoraggio() {
        return stubGestioneCentriMonitoraggio;
    }
}