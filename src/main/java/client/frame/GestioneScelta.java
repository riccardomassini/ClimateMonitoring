/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package client.frame;

import client.clientrmi.ClientRMI;
import client.registraeventi.Chiusura;
import commons.servizio.Autenticazione;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La classe {@code GestioneScelta} rappresenta il frame principale per la gestione della scelta tra cittadino e operatore.
 * <p>Gestisce la visibilità dei pulsanti e dei messaggi di errore basati sulla disponibilità del servizio di autenticazione.</p>
 * <p>Offre due costruttori per inizializzare la finestra con stati diversi: uno per la selezione normale e uno per la visualizzazione di un messaggio di errore.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class GestioneScelta extends javax.swing.JFrame {

    /** Oggetto per l'autenticazione tramite RMI */
    Autenticazione autenticazione;

    /**
     * Costruttore predefinito che inizializza la finestra per la selezione tra cittadino e operatore.
     * <p>Imposta l'immagine di sfondo, aggiunge un listener per la chiusura della finestra e gestisce la visibilità dei pulsanti e dei messaggi.</p>
     */
    public GestioneScelta() {
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);

        cittadino.setVisible(true);
        operatore.setVisible(true);
        out.setVisible(false);
        riprova.setVisible(false);
    }

    /**
     * Costruttore che inizializza la finestra per mostrare un messaggio di errore.
     * <p>Imposta l'immagine di sfondo, aggiunge un listener per la chiusura della finestra e gestisce la visibilità dei pulsanti e dei messaggi.</p>
     *
     * @param flag parametro temporaneo e inutilizzato per poter avere un altro costruttore per gestire l'errore dello spegnimento del server.
     */
    public GestioneScelta(String flag){
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);

        cittadino.setVisible(false);
        operatore.setVisible(false);
        out.setVisible(true);
        riprova.setVisible(true);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jColorChooser3 = new javax.swing.JColorChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        jColorChooser4 = new javax.swing.JColorChooser();
        jColorChooser5 = new javax.swing.JColorChooser();
        cittadino = new javax.swing.JButton();
        operatore = new javax.swing.JButton();
        riprova = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        scelta = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cittadino.setText("Cittadino");
        cittadino.setMaximumSize(new java.awt.Dimension(83, 23));
        cittadino.setMinimumSize(new java.awt.Dimension(83, 23));
        cittadino.setPreferredSize(new java.awt.Dimension(83, 23));
        cittadino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cittadinoActionPerformed(evt);
            }
        });
        getContentPane().add(cittadino, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 141, -1, 27));

        operatore.setText("Operatore");
        operatore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatoreActionPerformed(evt);
            }
        });
        getContentPane().add(operatore, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 197, -1, -1));

        riprova.setText("Riprova");
        riprova.setPreferredSize(new java.awt.Dimension(83, 23));
        riprova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riprovaActionPerformed(evt);
            }
        });
        getContentPane().add(riprova, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 220, -1, -1));

        out.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        out.setText("Server non acceso...");
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 45));

        scelta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scelta.setText("CLIMATE MONITOR");
        getContentPane().add(scelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 61));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestisce l'evento di azione del pulsante {@code cittadino}.
     * <p>Stabilisce una connessione RMI per l'autenticazione e, se riuscito, apre la finestra del cittadino; altrimenti, mostra un messaggio di errore.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code cittadino}.
     */
    private void cittadinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cittadinoActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null) {
            Cittadino cit = new Cittadino();
            cit.setLocation(this.getX(), this.getY());
            this.dispose();
            cit.setVisible(true);
        }else{
            cittadino.setVisible(false);
            operatore.setVisible(false);
            out.setVisible(true);
            riprova.setVisible(true);
        }
    }//GEN-LAST:event_cittadinoActionPerformed

    /**
     * Gestisce l'evento di azione del pulsante {@code operatore}.
     * <p>Stabilisce una connessione RMI per l'autenticazione e, se riuscito, apre la finestra dell'operatore; altrimenti, mostra un messaggio di errore.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code operatore}.
     */
    private void operatoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatoreActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null) {
            FrameOperatore op = new FrameOperatore();
            op.setLocation(this.getX(), this.getY());
            this.dispose();
            op.setVisible(true);
        }else{
            cittadino.setVisible(false);
            operatore.setVisible(false);
            out.setVisible(true);
            riprova.setVisible(true);
        }
    }//GEN-LAST:event_operatoreActionPerformed

    /**
     * Gestisce l'evento di azione del pulsante {@code riprova}.
     * <p>Rende di nuovo visibili i pulsanti per la selezione di cittadino e operatore e nasconde il messaggio di errore.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code riprova}.
     */
    private void riprovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riprovaActionPerformed
        cittadino.setVisible(true);
        operatore.setVisible(true);
        out.setVisible(false);
        riprova.setVisible(false);
    }//GEN-LAST:event_riprovaActionPerformed

    /**
     * Metodo principale che avvia il frame {@code GestioneScelta}.
     * <p>Crea e visualizza l'istanza di {@code GestioneScelta}.</p>
     * {@link javax.swing.UIManager#setLookAndFeel(String)}
     *
     * @param args gli argomenti della riga di comando.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestioneScelta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioneScelta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioneScelta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioneScelta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new GestioneScelta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cittadino;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JColorChooser jColorChooser3;
    private javax.swing.JColorChooser jColorChooser4;
    private javax.swing.JColorChooser jColorChooser5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JButton operatore;
    private javax.swing.JLabel out;
    private javax.swing.JButton riprova;
    private javax.swing.JLabel scelta;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables

}