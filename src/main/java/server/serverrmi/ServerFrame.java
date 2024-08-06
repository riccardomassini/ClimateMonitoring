/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.serverrmi;

import client.registraeventi.Chiusura;
import commons.connessione.ValidatoreIndirizzo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Properties;


/**
 * La classe {@code ServerFrame} rappresenta l'interfaccia grafica per controllare il server.
 * <p>
 * Questa classe estende {@code javax.swing.JFrame} e consente di avviare e fermare il server,
 * impostare le credenziali e configurare l'indirizzo host e la porta del server tramite un'interfaccia utente.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class ServerFrame extends javax.swing.JFrame {

    /** Indica se il server è in esecuzione. */
    private boolean serverRunning = false;

    /** Istanza del server. */
    private Server server;

    /** nome del file di configurazione per host e porta del server. */
    private String configFilePath = "./config.properties";

    /** Oggetto Properties per il file di configurazione. */
    private Properties properties = new Properties();

    /**
     * Costruttore della classe {@code ServerFrame}.
     * <p>
     * Imposta le credenziali di default del server, inizializza i componenti grafici,
     * imposta l'immagine di sfondo e aggiunge un listener per la chiusura della finestra.
     * </p>
     */
    public ServerFrame() {
        ImpostazioniServer.impostaCredenziali("admin", "root"); //credenziali default
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
    }

    /**
     * Imposta l'immagine di sfondo della finestra.
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
     * Metodo generato automaticamente per inizializzare i componenti grafici della finestra.
     * <p>
     * Non deve essere modificato manualmente.
     * </p>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        titolo = new javax.swing.JLabel();
        avvia = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        sfondo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setText("jLabel4");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titolo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        titolo.setText("SERVER");
        getContentPane().add(titolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        avvia.setText("Avvia");
        avvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avviaActionPerformed(evt);
            }
        });
        getContentPane().add(avvia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 126, 31));

        out.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 160, 29));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Porta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 29));

        port.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(port, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 126, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Host");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, 29));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 29));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 29));

        host.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(host, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 126, 29));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 126, 29));

        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 126, 29));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo chiamato quando l'utente clicca sul pulsante "Avvia".
     * <p>
     * Se il server è già in esecuzione, questo metodo lo ferma e aggiorna l'interfaccia utente.
     * Se il server non è in esecuzione, controlla le credenziali e l'indirizzo IP,
     * e avvia il server se tutti i controlli hanno esito positivo.
     * </p>
     *
     * @param evt L'evento generato dall'azione dell'utente sul pulsante "Avvia".
     */
    private void avviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avviaActionPerformed
        out.setText("");
        if (serverRunning) {
            if (server != null)
                server.stop();
            avvia.setText("Avvia");
            out.setText("Server spento");
            serverRunning = false;
        } else {
            try {
                if (ImpostazioniServer.controlloCredenziali(username.getText(), new String(password.getPassword())) && ValidatoreIndirizzo.indirizzoIpValido(host.getText()) && ValidatoreIndirizzo.portaValida(Integer.parseInt(port.getText()))) {
                    if (host.getText().equals("127.0.0.1")) {
                        try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/../config.properties")) {
                            properties.load(input);
                        } catch (IOException ex) {return;}
                        properties.setProperty("host", host.getText());
                        properties.setProperty("port", port.getText());

                        try (FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "/../config.properties")) {
                            properties.store(output, null);
                        } catch (IOException ex) {
                        }

                        server = Server.ottieniIstanzaServer();
                        server.start();
                        avvia.setText("Ferma");
                        out.setText("Server avviato");
                        serverRunning = true;
                    } else {
                        out.setText("Host non trovato");
                    }
                }else{
                    out.setText("Dati invalidi");
                }
            }catch(NumberFormatException e){
                out.setText("Fomato invalido");
            }
        }
    }

    /**
     * Metodo chiamato quando l'utente preme invio nel campo di testo per l'username.
     * <p>
     * Attualmente, questo metodo non esegue alcuna azione specifica,
     * ma può essere utilizzato per gestire eventi relativi all'input dell'username.
     * </p>
     *
     * @param evt L'evento generato dall'azione dell'utente sul campo di testo dell'username.
     */
    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    /**
     * Metodo principale che avvia l'applicazione.
     * <p>
     * Imposta il look and feel dell'interfaccia utente e crea una nuova istanza di {@code ServerFrame},
     * rendendola visibile.
     * </p>
     *
     * @param args Gli argomenti della linea di comando. Non utilizzati in questo contesto.
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
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }

    /** Pulsante per avviare o fermare il server. */
    private javax.swing.JButton avvia;

    /** Campo di testo per l'inserimento dell'indirizzo IP del server. */
    private javax.swing.JTextField host;

    /** Label 1 */
    private javax.swing.JLabel jLabel1;

    /** Label 2 */
    private javax.swing.JLabel jLabel2;

    /** Label 3 */
    private javax.swing.JLabel jLabel3;

    /** Label 4 */
    private javax.swing.JLabel jLabel4;

    /** Label 5 */
    private javax.swing.JLabel jLabel5;

    /** Pannello  per la grafica */
    private javax.swing.JPanel jPanel1;

    /** Contenitore testo per la password */
    private javax.swing.JPasswordField jPasswordField1;

    /** Label per messaggi di errore */
    private javax.swing.JLabel out;

    /** Contenitore testo per la password */
    private javax.swing.JPasswordField password;

    /** Contenitore testo per la porta */
    private javax.swing.JTextField port;

    /** Label per lo sfondo */
    private javax.swing.JLabel sfondo;

    /** Label per il titolo */
    private javax.swing.JLabel titolo;

    /** Contenitore testo per l'username */
    private javax.swing.JTextField username;
}
