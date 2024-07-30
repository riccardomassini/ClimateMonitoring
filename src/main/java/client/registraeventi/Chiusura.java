/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/
package client.registraeventi;

import java.awt.event.*;
import javax.swing.*;

/**
 * <p>La classe {@code Chiusura} estende {@link java.awt.event.WindowAdapter} e fornisce un comportamento
 * personalizzato per la chiusura di una finestra {@link javax.swing.JFrame}. Utilizza un dialogo di conferma
 * per chiedere all'utente se desidera davvero uscire dall'applicazione.</p>
 *
 * <p>Quando l'utente tenta di chiudere la finestra, viene visualizzato un dialogo di conferma. Se l'utente
 * conferma l'uscita, l'applicazione viene chiusa; in caso contrario, la chiusura della finestra viene
 * annullata.</p>
 */
public class Chiusura extends WindowAdapter{

    /**
     * Gestisce l'evento di chiusura della finestra. Mostra un dialogo di conferma all'utente per chiedere
     * se desidera uscire dall'applicazione.
     *
     * <p>Se l'utente seleziona "Sì" nel dialogo, l'applicazione viene chiusa chiamando {@code System.exit(0)}.
     * Se l'utente seleziona "No", l'operazione di chiusura della finestra viene annullata e la finestra rimane
     * aperta.</p>
     *
     * @param e l'evento di chiusura della finestra {@link java.awt.event.WindowEvent}. Utilizzato per ottenere
     *          la finestra {@code JFrame} che sta tentando di chiudersi.
     *
     * @author Riccardo Massini
     * @author Luca Abignano
     * @author Lorenzo Artale
     */
    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(
                null, // Utilizziamo null per il frame principale
                "Sei sicuro di voler uscire?",
                "Conferma uscita",
                JOptionPane.YES_NO_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            JFrame frame = (JFrame) e.getSource();
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}
