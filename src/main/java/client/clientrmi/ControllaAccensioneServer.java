/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.clientrmi;

/**
 *
 * @author massi
 */
import client.frame.Cittadino;
import client.frame.GestioneScelta;
import commons.servizio.Autenticazione;
import javax.swing.SwingUtilities;

public class ControllaAccensioneServer {

    private static final int POLLING_INTERVAL_MS = 2000;
    private final Thread pollingThread;
    private volatile boolean running = true;
    private GestioneScelta gestioneScelta;
    private Cittadino cittadino;

    public ControllaAccensioneServer(GestioneScelta gestioneScelta) {
        this.gestioneScelta = gestioneScelta;
        pollingThread = new Thread(this::pollAutenticazione);
        pollingThread.start();
    }
    
    private void pollAutenticazione() {
        while (running) {
            Autenticazione autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
            
            SwingUtilities.invokeLater(() -> gestioneScelta.updateUI(autenticazione));

            try {
                Thread.sleep(POLLING_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stopPolling() {
        running = false;
        pollingThread.interrupt();
    }
}

