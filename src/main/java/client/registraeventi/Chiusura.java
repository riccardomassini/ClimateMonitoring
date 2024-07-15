/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.registraeventi;

import java.awt.event.*;
import javax.swing.*;

public class Chiusura extends WindowAdapter{
    
    LoggerEventi logger = LoggerEventi.getInstance();
    
    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(
                null, // Utilizziamo null per il frame principale
                "Sei sicuro di voler uscire?",
                "Conferma uscita",
                JOptionPane.YES_NO_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            // Aggiorna il logger prima di chiudere l'applicazione
            logger.log("Applicazione chiusa.");
            logger.close();

            // Chiudi l'applicazione
            System.exit(0);
        } else {
            // Impedisci la chiusura effettiva del frame quando l'utente fa clic su "No"
            JFrame frame = (JFrame) e.getSource();
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}