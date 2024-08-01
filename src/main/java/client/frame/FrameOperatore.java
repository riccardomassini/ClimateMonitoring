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
import commons.servizio.Autenticazione;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La classe {@code FrameOperatore} rappresenta il frame principale per l'operatore, permettendo l'accesso alle funzionalità di login e registrazione.
 * <p>Gestisce le azioni dell'utente tramite i pulsanti di login e registrazione, e si occupa di caricare e visualizzare le rispettive finestre.</p>
 * <p>Imposta uno sfondo per il frame e gestisce la chiusura della finestra tramite un listener personalizzato.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class FrameOperatore extends javax.swing.JFrame {

    /** Oggetto per l'autenticazione tramite RMI */
     Autenticazione autenticazione;

    /**
     * Costruttore del frame operatore.
     * <p>Inizializza i componenti dell'interfaccia grafica, imposta l'immagine di sfondo, aggiunge un listener per la chiusura e disabilita il ridimensionamento della finestra.</p>
     */
    public FrameOperatore() {
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
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

        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        login = new javax.swing.JButton();
        reg = new javax.swing.JButton();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("OPERATORE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 16, -1, 42));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 254, -1, -1));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 112, 100, -1));

        reg.setText("Registrazione");
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });
        getContentPane().add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 162, -1, -1));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestisce l'azione del pulsante "Indietro".
     * <p>
     * Quando l'utente clicca sul pulsante "Indietro", questo metodo crea una nuova istanza di {@link GestioneScelta},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra di GestioneScelta.
     * </p>
     * <p>
     * Se l'oggetto di autenticazione è nullo, il metodo chiama {@link ResetClient#spegniClient}
     * per spegnere il client.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null) {
            GestioneScelta gs = new GestioneScelta();
            gs.setLocation(this.getX(), this.getY());
            this.dispose();
            gs.setVisible(true);  
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_backActionPerformed

    /**
     * Gestisce l'evento di azione del pulsante {@code login}.
     * <p>Stabilisce una connessione RMI per l'autenticazione e, se riuscito, apre la finestra di login, altrimenti spegne il client.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code login}.
     */
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null) {
            Login l = new Login();
            l.setLocation(this.getX(), this.getY());
            this.dispose();
            l.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_loginActionPerformed

    /**
     * Gestisce l'evento di azione del pulsante {@code reg}.
     * <p>Stabilisce una connessione RMI per l'autenticazione e, se riuscito, apre la finestra di registrazione, altrimenti spegne il client.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code reg}.
     */
    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null) {
            Registrazione r = new Registrazione();
            r.setLocation(this.getX(), this.getY());
            this.dispose();
            r.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_regActionPerformed
      
    /**
     * Metodo principale che avvia il frame {@code FrameOperatore}.
     * <p>Crea e visualizza l'istanza di {@code FrameOperatore}.</p>
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
            java.util.logging.Logger.getLogger(FrameOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameOperatore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JButton reg;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}