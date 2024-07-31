/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package client.frame;

import client.clientrmi.ClientRMI;
import client.clientrmi.ResetClient;
import client.registraeventi.Chiusura;
import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.Operatore;

import java.rmi.RemoteException;

import commons.servizio.Autenticazione;
import commons.servizio.GestioneCentriMonitoraggio;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * La classe {@code ScegliCentro} rappresenta il frame di scelta del centro dell'applicazione, utilizzato per scegliere un centro datone uno già esistente.
 * <p>
 * Questa classe fornisce l'interfaccia utente per scegliere un centro di monitoraggio
 * e associare l'operatore selezionato a tale centro. Utilizza RMI per ottenere e gestire
 * i centri di monitoraggio.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ScegliCentro extends javax.swing.JFrame {

    /** Oggetto per l'autenticazione dell'operatore. */
    Autenticazione autenticazione;

    /** Oggetto per la gestione dei centri di monitoraggio. */
    GestioneCentriMonitoraggio gestioneCentriMonitoraggio = ClientRMI.ottieniClientRMI().ottieniStubGestioneCentriMonitoraggio();

    /** Operatore passato per la selezione del centro di monitoraggio. */
    Operatore operatorePassato;

    /** Nome del centro di monitoraggio selezionato. */
    String sceltaCentro = null;

    /** Crea una nuova istanza di {@code ScegliCentro} senza parametri e inizializza i componenti. */
    public ScegliCentro() {
        initComponents();
    }

    /**
     * Crea una nuova istanza di {@code ScegliCentro} e inizializza i componenti.
     * <p>
     * Configura lo sfondo della finestra e gestisce l'inizializzazione dei centri di monitoraggio.
     * </p>
     *
     * @param id ID dell'operatore.
     * @param password Password dell'operatore.
     */
    public ScegliCentro(int id, String password){
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
        operatorePassato = new Operatore(id, password);
        ArrayList<CentroMonitoraggio> centri = null;
        try {
            centri = gestioneCentriMonitoraggio.leggiCentri();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> names = new ArrayList<>();

        for(CentroMonitoraggio centro: centri) {
            names.add(centro.getNomeCentro());
        }

        names.add(0, "nessun centro");

        String[] namesArray = names.toArray(new String[0]);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(namesArray);
        scelta.setModel(model);
    }

    /**
     * Imposta l'immagine di sfondo del frame.
     *
     * @param imagePath il percorso dell'immagine di sfondo
     */
    private void setBackgroundImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(getClass().getClassLoader().getResource(imagePath));    
            sfondo.setIcon(new ImageIcon(image.getScaledInstance(sfondo.getWidth(), sfondo.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Inizializza i componenti dell'interfaccia utente.
     * <p>
     * Questo metodo è generato automaticamente dal Form Editor e non dovrebbe essere modificato manualmente.
     * </p>
     */
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        scelta = new javax.swing.JComboBox<>();
        scegli = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 271, -1, -1));

        scelta.setName(""); // NOI18N
        scelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceltaActionPerformed(evt);
            }
        });
        getContentPane().add(scelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 89, 113, -1));

        scegli.setText("Scegli");
        scegli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scegliActionPerformed(evt);
            }
        });
        getContentPane().add(scegli, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 89, 84, -1));

        out.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 141, 75, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("SCEGLI CENTRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 6, -1, 43));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

        pack();
    }

    /**
     * Gestisce l'azione del pulsante "Indietro".
     * <p>
     * Quando l'utente clicca sul pulsante "Indietro", questo metodo crea una nuova istanza di {@link AreaOperatore},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra di AreaOperatore.
     * </p>
     * <p>
     * Se l'oggetto di autenticazione è nullo, il metodo chiama {@link ResetClient#spegniClient}
     * per spegnere il client.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        
        if(autenticazione != null){
            AreaOperatore ao = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
            ao.setLocation(this.getX(), this.getY());
            this.dispose();
            ao.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Metodo chiamato quando viene selezionata una voce dal menu a discesa.
     * <p>
     * Recupera e memorizza il centro di monitoraggio selezionato.
     * </p>
     *
     * @param evt Evento di azione generato dalla selezione nel menu a discesa.
     */
    private void sceltaActionPerformed(java.awt.event.ActionEvent evt) {
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        
        if(autenticazione != null){
            out.setText("");
            sceltaCentro = (String) scelta.getSelectedItem();
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Metodo chiamato quando viene cliccato il pulsante di conferma per selezionare un centro.
     * <p>
     * Associa il centro di monitoraggio selezionato all'operatore e apre l'area operatore.
     * </p>
     *
     * @param evt Evento di azione generato dal clic sul pulsante di conferma.
     */
    private void scegliActionPerformed(java.awt.event.ActionEvent evt) {
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        
        if(autenticazione != null){
            if(sceltaCentro != null){
                if(!sceltaCentro.equals("nessun centro")){
                    try {
                        gestioneCentriMonitoraggio.associaCentroMonitoraggioOperatore(operatorePassato.getUsername(), sceltaCentro);
                        AreaOperatore ao = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
                        ao.setLocation(this.getX(), this.getY());
                        this.dispose();
                        ao.setVisible(true);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ScegliCentro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else
                    out.setText("Invalido");
            }else
                out.setText("Invalido");
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Metodo principale che avvia il frame {@code ScegliCentro}.
     * <p>Crea e visualizza l'istanza di {@code ScegliCentro}.</p>
     * {@link javax.swing.UIManager#setLookAndFeel(String)}
     *
     * @param args gli argomenti della riga di comando.
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScegliCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScegliCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScegliCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScegliCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScegliCentro().setVisible(true);
            }
        });
    }

    /** Bottone per tornare alla schermata precedente. */
    private javax.swing.JButton back;

    /** Bottone per confermare la selezione del centro di monitoraggio. */
    private javax.swing.JButton jButton1;

    /** Etichetta per visualizzare messaggi di stato o errori. */
    private javax.swing.JLabel jLabel1;

    /** Etichetta per visualizzare l'output o messaggi di errore. */
    private javax.swing.JLabel out;

    /** Pulsante per selezionare un centro di monitoraggio. */
    private javax.swing.JButton scegli;

    /** Combo box per scegliere un centro di monitoraggio. */
    private javax.swing.JComboBox<String> scelta;

    /** Etichetta per lo sfondo dell'interfaccia. */
    private javax.swing.JLabel sfondo;
}