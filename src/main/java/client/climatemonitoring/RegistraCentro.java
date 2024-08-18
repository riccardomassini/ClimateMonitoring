/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package client.climatemonitoring;

import client.clientrmi.ClientRMI;
import client.clientrmi.ResetClient;
import client.registraeventi.Chiusura;
import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.Operatore;
import commons.oggetti.PuntoInteresse;
import java.rmi.RemoteException;
import java.util.ArrayList;
import commons.servizio.GestioneCentriMonitoraggio;
import commons.servizio.RicercaPuntiInteresse;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La classe {@code RegistraCentro} rappresenta il frame di registrazione centro dell'applicazione, utilizzato per registrare i centri di monitoraggio.
 * <p>Permette di registrare un centro di monitoraggio inserendo anche le aree di interesse relative.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class RegistraCentro extends javax.swing.JFrame {

    /** Oggetto per la gestione dei centri di monitoraggio. */
    private GestioneCentriMonitoraggio gestioneCentriMonitoraggio;

    /** Oggetto per la ricerca dei punti di interesse. */
    private RicercaPuntiInteresse ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();

    /** Lista dei punti di interesse monitorati. */
    private ArrayList<PuntoInteresse> puntiInteresseMonitorati = new ArrayList<>();

    /** Operatore che sta effettuando la registrazione. */
    private Operatore operatorePassato;

    /** Contatore per il numero di punti di interesse associati. */
    private int count;

    /** Costruttore vuoto di default. */
    public RegistraCentro() {
        initComponents();
    }

    /**
     * Costruttore con parametri per inizializzare un'istanza di
     * RegistraCentro con le informazioni dell'operatore.
     *
     * @param id ID dell'operatore.
     * @param pass Password dell'operatore.
     */
    public RegistraCentro(int id, String pass){
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
        operatorePassato = new Operatore(id, pass);
        areeLabel.setVisible(false);
        nomepReg.setVisible(false);
        codiceReg.setVisible(false);
        insAree.setVisible(false);
        centroReg.setVisible(false);
        out9.setVisible(false);
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

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        nomeReg = new javax.swing.JTextField();
        indReg = new javax.swing.JTextField();
        numcReg = new javax.swing.JTextField();
        capReg = new javax.swing.JTextField();
        comReg = new javax.swing.JTextField();
        proReg = new javax.swing.JTextField();
        numaReg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        cliccaReg = new javax.swing.JButton();
        nomepReg = new javax.swing.JTextField();
        codiceReg = new javax.swing.JTextField();
        out1 = new javax.swing.JLabel();
        insAree = new javax.swing.JButton();
        out2 = new javax.swing.JLabel();
        out3 = new javax.swing.JLabel();
        out4 = new javax.swing.JLabel();
        out5 = new javax.swing.JLabel();
        out6 = new javax.swing.JLabel();
        out7 = new javax.swing.JLabel();
        out9 = new javax.swing.JLabel();
        centroReg = new javax.swing.JButton();
        areeLabel = new javax.swing.JLabel();
        out8 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRA CENTRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 43));
        getContentPane().add(nomeReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 67, 96, -1));
        getContentPane().add(indReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 96, -1));
        getContentPane().add(numcReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 123, 96, -1));
        getContentPane().add(capReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 151, 96, -1));
        getContentPane().add(comReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 96, -1));
        getContentPane().add(proReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 208, 96, -1));
        getContentPane().add(numaReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 96, -1));

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 67, 78, 22));

        jLabel3.setText("Indirizzo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 78, 22));

        jLabel4.setText("Numero civico");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 123, -1, 22));

        jLabel5.setText("CAP");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 151, 78, 23));

        jLabel6.setText("Comune");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, 78, 22));

        jLabel7.setText("Provincia");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 208, 78, 22));

        jLabel8.setText("Numero aree");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 240, 130, 22));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 268, 78, -1));

        cliccaReg.setText("Clicca");
        cliccaReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliccaRegActionPerformed(evt);
            }
        });
        getContentPane().add(cliccaReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 268, 96, -1));
        getContentPane().add(nomepReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 95, 86, -1));
        getContentPane().add(codiceReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 123, 86, -1));
        getContentPane().add(out1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 67, 143, 22));

        insAree.setText("Inserisci");
        insAree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insAreeActionPerformed(evt);
            }
        });
        getContentPane().add(insAree, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 151, 86, -1));
        getContentPane().add(out2, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 95, 143, 22));
        getContentPane().add(out3, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 123, 143, 22));
        getContentPane().add(out4, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 151, 143, 23));
        getContentPane().add(out5, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 180, 143, 22));
        getContentPane().add(out6, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 208, 143, 26));
        getContentPane().add(out7, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 240, 143, 22));

        out9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        out9.setText("Clicca per registrare il centro");
        getContentPane().add(out9, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 100, 290, 22));

        centroReg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centroReg.setText("Registra");
        centroReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centroRegActionPerformed(evt);
            }
        });
        getContentPane().add(centroReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 130, 90, 30));

        areeLabel.setText("Inserisci aree");
        getContentPane().add(areeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 70, 90, 22));
        getContentPane().add(out8, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 240, 130, 19));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        gestioneCentriMonitoraggio = ClientRMI.ottieniClientRMI().ottieniStubGestioneCentriMonitoraggio();
        
        if(gestioneCentriMonitoraggio != null){
            puntiInteresseMonitorati.clear();
            AreaOperatore ao = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
            ao.setLocation(this.getX(), this.getY());
            this.dispose();
            ao.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_backActionPerformed

    /**
     * Azione eseguita quando viene cliccato il pulsante di registrazione.
     * Controlla la validità dei dati inseriti e mostra o nasconde
     * gli elementi dell'interfaccia in base alla validità dei dati.
     *
     * @param evt Evento di azione generato dal clic del pulsante.
     */
    private void cliccaRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliccaRegActionPerformed
        gestioneCentriMonitoraggio = ClientRMI.ottieniClientRMI().ottieniStubGestioneCentriMonitoraggio();
        
        if(gestioneCentriMonitoraggio != null){     
            out1.setText("");
            out2.setText("");
            out3.setText("");
            out4.setText("");
            out5.setText("");
            out6.setText("");
            out7.setText("");
            out8.setText("");
            
            puntiInteresseMonitorati.clear();

            count = 0;
            String nome = nomeReg.getText();
            String indirizzo = indReg.getText();
            int numCivico = -1;
            try{
                numCivico = Integer.parseInt(numcReg.getText());
            }catch(NumberFormatException ex){
                out3.setText("Formato non valido");
            }
            String cap = capReg.getText();
            String comune = comReg.getText();
            String provincia = proReg.getText();
            int numAree = 0;
            try{
                numAree = Integer.parseInt(numaReg.getText());
                if(numAree <= 0)
                    out7.setText("Troppo corto");
            }catch(NumberFormatException ex){
                out7.setText("Formato non valido");
            }

            if(nome.length()<=0)
                out1.setText("Troppo corto");
            if(nome.length()>20)
                out1.setText("Troppo lungo");
            if(indirizzo.length()<=0)
                out2.setText("Troppo corto");
            if(indirizzo.length()>50)
                out1.setText("Troppo lungo");
            if(!controlloCap(cap))
                out4.setText("CAP invalido");
            if(comune.length()<=0)
                out5.setText("Troppo corto");
            if(comune.length()>50)
                out5.setText("Troppo lungo");
            if(provincia.length()!=2)
                out6.setText("inserire 2 lettere");

            try {
                if(!gestioneCentriMonitoraggio.controllaEsistenzaCentro(nome))
                    out1.setText("Centro già presente");

                if(!nome.isEmpty() && !indirizzo.isEmpty() && numCivico != -1 && controlloCap(cap) && !comune.isEmpty() && provincia.length()==2 && numAree>0 && gestioneCentriMonitoraggio.controllaEsistenzaCentro(nome)){
                    areeLabel.setVisible(true);
                    nomepReg.setVisible(true);
                    codiceReg.setVisible(true);
                    insAree.setVisible(true);
                }else{
                    areeLabel.setVisible(false);
                    nomepReg.setVisible(false);
                    codiceReg.setVisible(false);
                    insAree.setVisible(false);
                }
            } catch (RemoteException e) {}
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_cliccaRegActionPerformed

    /**
     * Azione eseguita quando viene cliccato il pulsante per inserire le aree.
     * Cerca un punto di interesse e lo associa al centro di monitoraggio
     * se non è già stato inserito.
     *
     * @param evt Evento di azione generato dal clic del pulsante.
     */
    private void insAreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insAreeActionPerformed
        gestioneCentriMonitoraggio = ClientRMI.ottieniClientRMI().ottieniStubGestioneCentriMonitoraggio();
        
        if(gestioneCentriMonitoraggio != null){ 
            out8.setText("");
            String asname = nomepReg.getText();
            String cc = codiceReg.getText();
            int numAree = Integer.parseInt(numaReg.getText());
            PuntoInteresse puntoInteresse = null;

            //TODO rmi client
            try {
                puntoInteresse = ricercaPuntiInteresse.ricercaPerNomeENazione(asname, cc);
            } catch(RemoteException ex) {
                System.err.println("Errore RMI");
                ex.printStackTrace();
                System.exit(1);
            }
            
            if(puntoInteresse == null)
                out8.setText("Il paese non esiste");
            else if(puntiInteresseMonitorati.contains(puntoInteresse))
                out8.setText("Paese già inserito");
            else {
                puntiInteresseMonitorati.add(puntoInteresse);
                count++;
                out8.setText("Paese inserito");
            }     

            if(count==numAree)
                cambiaVisibilita();
        }else{
            ResetClient.spegniClient(this);
        }

    }//GEN-LAST:event_insAreeActionPerformed

    /**
     * Azione eseguita quando viene cliccato il pulsante per registrare il centro.
     * Registra il centro di monitoraggio e associa i punti di interesse.
     *
     * @param evt Evento di azione generato dal clic del pulsante.
     */
    private void centroRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centroRegActionPerformed
        gestioneCentriMonitoraggio = ClientRMI.ottieniClientRMI().ottieniStubGestioneCentriMonitoraggio();

        if(gestioneCentriMonitoraggio != null){
            CentroMonitoraggio nuovoCentro = new CentroMonitoraggio(nomeReg.getText(), indReg.getText(), Integer.parseInt(numcReg.getText()), capReg.getText(), comReg.getText(), proReg.getText());

            //TODO rmi client
            try {
                gestioneCentriMonitoraggio.registraCentroMonitoraggio(new CentroMonitoraggio(nuovoCentro.getNomeCentro(), nuovoCentro.getIndirizzo(), nuovoCentro.getNumeroCivico(), nuovoCentro.getCAP(), nuovoCentro.getComune(), nuovoCentro.getProvincia()));
                gestioneCentriMonitoraggio.associaPuntiInteresseCentroMonitoraggio(nuovoCentro.getNomeCentro(), puntiInteresseMonitorati.toArray(new PuntoInteresse[puntiInteresseMonitorati.size()]));
                gestioneCentriMonitoraggio.associaCentroMonitoraggioOperatore(operatorePassato.getUsername(), nuovoCentro.getNomeCentro());
            } catch(RemoteException ex) {
                System.err.println("Errore RMI");
                ex.printStackTrace();
                System.exit(1);
            }

            AreaOperatore areaOperatore = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
            areaOperatore.setLocation(this.getX(), this.getY());
            this.dispose();
            areaOperatore.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_centroRegActionPerformed

    /**
     * Metodo che controlla se il cap inserito dall'utente è valido.
     *
     * @param cap cap del paese/città del nostro centro di monitoraggio
     * @return un valore boolean, true se il cap è valido, false altrimenti
     */
    private boolean controlloCap(String cap){
        if(cap.length() != 5)
            return false;

        for(int i=0; i<cap.length(); i++){
            char c = cap.charAt(i);
            if(c<48 || c>57)
                return false;
        }
        return true;
    }
    
    /**
     * Cambia la visibilità degli elementi dell'interfaccia utente in base
     * allo stato della registrazione del centro di monitoraggio.
     * <p>Questo metodo nasconde gli elementi legati alla registrazione delle aree
     * e mostra il pulsante per finalizzare la registrazione del centro.</p>
     */
    private void cambiaVisibilita(){
        areeLabel.setVisible(false);
        nomepReg.setVisible(false);
        codiceReg.setVisible(false);
        insAree.setVisible(false);
        out8.setVisible(false);
        centroReg.setVisible(true);
        nomepReg.setVisible(false);
        capReg.setVisible(false);
        cliccaReg.setVisible(false);
        codiceReg.setVisible(false);
        comReg.setVisible(false);
        indReg.setVisible(false);
        nomeReg.setVisible(false);
        nomepReg.setVisible(false);
        numaReg.setVisible(false);
        numcReg.setVisible(false);
        proReg.setVisible(false);
        cliccaReg.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        out9.setVisible(true);
    }

    /**
     * Metodo principale che avvia il frame {@code RegistraCentro}.
     * <p>Crea e visualizza l'istanza di {@code RegistraCentro}.</p>
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
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistraCentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistraCentro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areeLabel;
    private javax.swing.JButton back;
    private javax.swing.JTextField capReg;
    private javax.swing.JButton centroReg;
    private javax.swing.JButton cliccaReg;
    private javax.swing.JTextField codiceReg;
    private javax.swing.JTextField comReg;
    private javax.swing.JTextField indReg;
    private javax.swing.JButton insAree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField nomeReg;
    private javax.swing.JTextField nomepReg;
    private javax.swing.JTextField numaReg;
    private javax.swing.JTextField numcReg;
    private javax.swing.JLabel out1;
    private javax.swing.JLabel out2;
    private javax.swing.JLabel out3;
    private javax.swing.JLabel out4;
    private javax.swing.JLabel out5;
    private javax.swing.JLabel out6;
    private javax.swing.JLabel out7;
    private javax.swing.JLabel out8;
    private javax.swing.JLabel out9;
    private javax.swing.JTextField proReg;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}