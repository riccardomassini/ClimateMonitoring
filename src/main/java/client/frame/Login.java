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

import java.rmi.RemoteException;

import commons.oggetti.Operatore;
import commons.servizio.Autenticazione;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La classe {@code Login} rappresenta il frame di login dell'applicazione, utilizzato per autenticare gli utenti.
 * <p>Gestisce l'interfaccia di login, inclusi i campi per l'identificatore dell'utente e la password.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Login extends javax.swing.JFrame {

    /** Oggetto per l'autenticazione tramite RMI */
    Autenticazione autenticazione;

    /**
     * Costruttore predefinito che inizializza la finestra di login.
     * <p>Imposta l'immagine di sfondo, aggiunge un listener per la chiusura della finestra e imposta la finestra come non ridimensionabile.</p>
     */
    public Login() {
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
    private void initComponents() {
        log = new javax.swing.JLabel();
        ident = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        log.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        log.setText("LOGIN");
        getContentPane().add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 14, 70, 35));

        ident.setAlignmentY(0.0F);
        getContentPane().add(ident, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 89, 109, -1));

        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 151, 109, -1));

        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 67, -1, -1));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 129, -1, -1));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 251, -1, -1));

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 191, 47, -1));

        out.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 251, 168, 23));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 310));

        pack();
    }

    /**
     * Gestisce l'azione del pulsante "Indietro".
     * <p>
     * Quando l'utente clicca sul pulsante "Indietro", questo metodo crea una nuova istanza di {@link FrameOperatore},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra di FrameOperatore.
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
            FrameOperatore op = new FrameOperatore();
            op.setLocation(this.getX(), this.getY());
            this.dispose();
            op.setVisible(true); 
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Gestisce l'evento di azione del pulsante {@code ok}.
     * <p>Stabilisce una connessione RMI per l'autenticazione e tenta di effettuare il login con le credenziali inserite.</p>
     * <p>Se il login ha successo, apre la finestra dell'area dell'operatore; altrimenti, mostra un messaggio di errore.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code ok}.
     */
    private void okActionPerformed(java.awt.event.ActionEvent evt) {
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null){
        
            out.setText("");

            int usernameOperatore = 0;

            try{
                usernameOperatore = Integer.parseInt(ident.getText());
            } catch(NumberFormatException e) {}

            Operatore operatore = new Operatore(usernameOperatore, String.copyValueOf(password.getPassword()));

            try {
                if (autenticazione.login(operatore.getUsername(), operatore.getPassword())) {
                    AreaOperatore ao = new AreaOperatore(operatore.getUsername(), operatore.getPassword());
                    ao.setLocation(this.getX(), this.getY());
                    this.dispose();
                    ao.setVisible(true);
                } else {
                    if (usernameOperatore == 0)
                        out.setText("ID non valido");
                    else
                        out.setText("Credenziali errate");
                }
            } catch(RemoteException ex) {
                System.err.println("Errore RMI: impossibile effettuare il login");
                ex.printStackTrace();
                System.exit(1);
            }
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Metodo principale che avvia l'applicazione di login.
     * <p>Crea e visualizza il frame di login.</p>
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    /** Bottone per tornare indietro (non utilizzato nel codice attuale) */
    private javax.swing.JButton back;

    /** Campo di testo per l'identificatore dell'utente */
    private javax.swing.JTextField ident;

    /** Etichetta per l'identificatore dell'utente */
    private javax.swing.JLabel jLabel1;

    /** Etichetta per la password */
    private javax.swing.JLabel jLabel2;

    /** Etichetta per il login */
    private javax.swing.JLabel log;

    /** Bottone per confermare il login */
    private javax.swing.JButton ok;

    /** Etichetta per i messaggi di errore */
    private javax.swing.JLabel out;

    /** Campo di password per l'inserimento della password */
    private javax.swing.JPasswordField password;

    /** Etichetta per l'immagine di sfondo */
    private javax.swing.JLabel sfondo;
}