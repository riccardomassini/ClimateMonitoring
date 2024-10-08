/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/
package client.clientrmi;

import client.climatemonitoring.ClimateMonitoring;

import javax.swing.JFrame;

/**
 * <p>La classe {@code ResetClient} fornisce un metodo statico per gestire il processo di spegnimento
 * di un client e il successivo avvio di una nuova finestra di scelta. Questo è utile per operazioni
 * che richiedono la chiusura di una finestra corrente e l'apertura di una nuova finestra di selezione.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ResetClient {

    /** Costruttore vuoto */
    public ResetClient(){}

    /**
     * Chiude la finestra corrente e apre la finestra di scelta.
     *
     * <p>Questo metodo crea un'istanza di {@link ClimateMonitoring} e la posiziona
     * nella stessa posizione della finestra {@code frame} passata come parametro. Dopo aver chiuso
     * la finestra corrente, rende visibile la nuova finestra di scelta.</p>
     *
     * @param frame la finestra {@code JFrame} da chiudere. La posizione della finestra corrente
     *              verrà utilizzata per posizionare la nuova finestra di scelta.
     *
     * @see ClimateMonitoring
     */
    public static void spegniClient(JFrame frame){
        //passo una stringa vuota perchè il costruttore vuoto esiste già
        ClimateMonitoring gs = new ClimateMonitoring("");
        gs.setLocation(frame.getX(), frame.getY());
        frame.dispose();
        gs.setVisible(true);
    }
}