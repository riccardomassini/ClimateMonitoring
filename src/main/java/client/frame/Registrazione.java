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
import commons.oggetti.Operatore;
import commons.oggetti.ValidatorePassword;
import commons.servizio.Autenticazione;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.rmi.RemoteException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La classe {@code Registrazione} rappresenta il frame di registrazione dell'applicazione, utilizzato per registrare gli operatori climatici.
 * <p>Gestisce l'interfaccia di registrazione e permette l'inserimento di tutti gli attributi che un operatore deve possedere, inoltre controlla
 * che tutti gli attributi inseriti siano validi.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Registrazione extends javax.swing.JFrame {

    /** Oggetto per gestire l'autenticazione tramite RMI. */
    Autenticazione autenticazione;

    /**
     * Costruttore per inizializzare i componenti dell'interfaccia utente,
     * impostare lo sfondo della finestra e aggiungere un listener per la
     * chiusura della finestra.
     */
    public Registrazione() {
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

        jLabel1 = new javax.swing.JLabel();
        nomeReg = new javax.swing.JTextField();
        cfReg = new javax.swing.JTextField();
        mailReg = new javax.swing.JTextField();
        idReg = new javax.swing.JTextField();
        passReg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reg = new javax.swing.JButton();
        back = new javax.swing.JButton();
        out2 = new javax.swing.JLabel();
        cognomeReg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        out3 = new javax.swing.JLabel();
        out1 = new javax.swing.JLabel();
        out4 = new javax.swing.JLabel();
        out5 = new javax.swing.JLabel();
        out6 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("REGISTRAZIONE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 38));
        getContentPane().add(nomeReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 50, 85, -1));
        getContentPane().add(cfReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 118, 85, -1));

        getContentPane().add(mailReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 152, 85, -1));
        getContentPane().add(idReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 186, 85, -1));
        getContentPane().add(passReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 220, 85, -1));

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 50, 67, 22));

        jLabel3.setText("Codice Fiscale");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 121, -1, -1));

        jLabel4.setText("Mail");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 152, -1, 22));

        jLabel5.setText("ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 189, 37, -1));

        jLabel6.setText("Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 223, -1, -1));

        reg.setText("Registrati");
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });
        getContentPane().add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 260, 85, -1));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 260, -1, -1));
        getContentPane().add(out2, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 84, 260, 22));
        getContentPane().add(cognomeReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 84, 85, -1));

        jLabel7.setText("Cognome");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 84, 67, 22));
        getContentPane().add(out3, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 118, 260, 22));
        getContentPane().add(out1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 50, 260, 22));

        out4.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(out4, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 152, 260, 22));
        getContentPane().add(out5, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 186, 260, 22));
        getContentPane().add(out6, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 220, 260, 22));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 310));

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
        } else {
             ResetClient.spegniClient(this);
        }
    }

    /**
     * Metodo chiamato quando l'utente clicca sul pulsante di registrazione.
     * Questo metodo valida i dati inseriti e, se sono corretti,
     * tenta di registrare un nuovo operatore utilizzando RMI.
     *
     * @param evt L'evento di azione scatenato dal clic sul pulsante di registrazione.
     */
    private void regActionPerformed(java.awt.event.ActionEvent evt) {
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        
        if(autenticazione != null) {
            out1.setText("");
            out2.setText("");
            out3.setText("");
            out4.setText("");
            out5.setText("");
            out6.setText("");

            boolean valido = true;
            String nome = nomeReg.getText();
            String cognome = cognomeReg.getText();
            String cf = cfReg.getText();
            String email = mailReg.getText();
            String password = passReg.getText();
            int id = 0;

            try {
                id = Integer.parseInt(idReg.getText());
            } catch(NumberFormatException e) {
                out5.setText("non è un numero valido");
                valido = false;
            }

            if(nome == null || nome.isEmpty()) {
                out1.setText("nome non valido");
                valido = false;
            }
            if(nome.length()>30){
                out1.setText("nome troppo lungo");
                valido = false;
            }
            if(cognome == null || cognome.isEmpty() || cognome.length()>30) {
                out2.setText("cognome non valido");
                valido = false;
            }
            if(cognome.length()>30){
                out2.setText("cognome troppo lungo");
                valido = false;
            }
            if(id < 0) {
                out5.setText("deve essere un intero positivo");
                valido = false;
            }

            if(!emailValida(email))
                valido = false;

            if(!codiceFiscaleValido(cf))
                valido = false;

            if(!passwordValida(password))
                valido = false;

            if(!valido)
                return;

            Operatore operatore = new Operatore(nome, cognome, cf, email, id, password);

            try {
                if (autenticazione.registrazione(operatore)) {
                    out1.setText("Operatore registrato con successo!");
                    backActionPerformed(evt);
                } else
                    out5.setText("ID " + id + " gia registrato");
            } catch(RemoteException ex) {
                System.err.println("Errore RMI: impossibile registrare un nuovo operatore");
                ex.printStackTrace();
                System.exit(1);
            }

        } else
            ResetClient.spegniClient(this);
    }

    /**
     * Verifica se la password inserita rispetta i requisiti di validità.
     *
     * @param password La password da verificare.
     * @return true se la password è valida, false altrimenti.
     */
    private boolean passwordValida(String password) {
        if(password == null) {
            out6.setText("Inserire una password valida");
            return false;
        }
        if(!ValidatorePassword.rispettaLunghezzaMinima(password)) {
            out6.setText("deve contenere un minimo di " + ValidatorePassword.LUNGHEZZA_MINIMA + " caratteri");
            return false;
        }
        if(!ValidatorePassword.contieneCifra(password)) {
            out6.setText("deve contenere almeno una cifra");
            return false;
        }
        if(!ValidatorePassword.contieneLetteraMinuscola(password)) {
            out6.setText("deve contenere almeno una lettera minuscola");
            return false;
        }
        if(!ValidatorePassword.contieneLetteraMaiuscola(password)) {
            out6.setText("deve contenere almeno una lettera maiuscola");
            return false;
        }
        if(!ValidatorePassword.contieneCarattereSpeciale(password)) {
            out6.setText("deve contenere almeno un carattere speciale");
            return false;
        }
        if(password.length() > 60){
            out6.setText("troppo lunga");
            return false;
        }
        return true;
    }

    /**
     * Verifica se l'email inserita è valida.
     *
     * @param email L'email da verificare.
     * @return true se l'email è valida, false altrimenti.
     */
    private boolean emailValida(String email) {
        String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (email == null) {
            out4.setText("Inserire una email valida");
            return false;
        }
        if(email.length()>30){
            out4.setText("Email troppo lunga");
            return false;
        }
        if (!Pattern.compile(REGEX_EMAIL).matcher(email).matches()) {
            out4.setText("email con formato non valido");
            return false;
        }
        return true;
    }

    /**
     * Verifica se il codice fiscale inserito è valido.
     *
     * @param codiceFiscale Il codice fiscale da verificare.
     * @return true se il codice fiscale è valido, false altrimenti.
     */
    private boolean codiceFiscaleValido(String codiceFiscale){
        int LUNGHEZZA_CF = 16;

        if (codiceFiscale == null) {
            out3.setText("inserire un CF valido");
            return false;
        }
        if (codiceFiscale.length() != LUNGHEZZA_CF) {
            out3.setText("deve contenere " + LUNGHEZZA_CF + " caratteri");
            return false;
        }
        if(!(Character.isLetter(codiceFiscale.charAt(0)) && //COGNOME
                Character.isLetter(codiceFiscale.charAt(1)) && //COGNOME
                Character.isLetter(codiceFiscale.charAt(2)) && //COGNOME
                Character.isLetter(codiceFiscale.charAt(3)) && //NOME
                Character.isLetter(codiceFiscale.charAt(4)) && //NOME
                Character.isLetter(codiceFiscale.charAt(5)) && //NOME
                Character.isDigit(codiceFiscale.charAt(6)) && //ANNO DI NASCITA
                Character.isDigit(codiceFiscale.charAt(7)) && //ANNO DI NASCITA
                Character.isLetter(codiceFiscale.charAt(8)) && //MESE DI NASCITA
                Character.isDigit(codiceFiscale.charAt(9)) && //GIORNO DI NASCITA / SESSO
                Character.isDigit(codiceFiscale.charAt(10)) && //GIORNO DI NASCITA / SESSO
                Character.isLetter(codiceFiscale.charAt(11)) && //COMUNE / STATO DI NASCITA
                Character.isDigit(codiceFiscale.charAt(12)) && //COMUNE / STATO DI NASCITA
                Character.isDigit(codiceFiscale.charAt(13)) && //COMUNE / STATO DI NASCITA
                Character.isDigit(codiceFiscale.charAt(14)) && //COMUNE / STATO DI NASCITA
                Character.isLetter(codiceFiscale.charAt(15)))) //CARATTERE DI CONTROLLO
        {
            out3.setText("non rispetta formato CF");
            return false;
        }

        return true;
    }

    /**
     * Metodo principale che avvia il frame {@code Registrazione}.
     * <p>Crea e visualizza l'istanza di {@code Registrazione}.</p>
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
            java.util.logging.Logger.getLogger(Registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrazione().setVisible(true);
            }
        });
    }

    /** Pulsante per tornare alla schermata precedente. */
    private javax.swing.JButton back;

    /** Campo di testo per inserire il codice fiscale dell'operatore. */
    private javax.swing.JTextField cfReg;

    /** Campo di testo per inserire il cognome dell'operatore. */
    private javax.swing.JTextField cognomeReg;

    /** Campo di testo per inserire l'ID dell'operatore. */
    private javax.swing.JTextField idReg;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel1;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel2;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel3;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel4;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel5;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel6;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel7;

    /** Campo di testo per inserire l'indirizzo email dell'operatore. */
    private javax.swing.JTextField mailReg;

    /** Campo di testo per inserire il nome dell'operatore. */
    private javax.swing.JTextField nomeReg;

    /** Etichetta per i messaggi di errore o conferma. */
    private javax.swing.JLabel out1;

    /** Etichetta per i messaggi di errore o conferma. */
    private javax.swing.JLabel out2;

    /** Etichetta per i messaggi di errore o conferma. */
    private javax.swing.JLabel out3;

    /** Etichetta per i messaggi di errore o conferma. */
    private javax.swing.JLabel out4;

    /** Etichetta per i messaggi di errore o conferma. */
    private javax.swing.JLabel out5;

    /** Etichetta per i messaggi di errore o conferma. */
    private javax.swing.JLabel out6;

    /** Campo di testo per inserire la password dell'operatore. */
    private javax.swing.JTextField passReg;

    /** Pulsante per confermare la registrazione dell'operatore. */
    private javax.swing.JButton reg;

    /** Etichetta per lo sfondo dell'interfaccia. */
    private javax.swing.JLabel sfondo;
}