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
import commons.oggetti.PuntoInteresse;
import java.rmi.RemoteException;
import commons.servizio.Autenticazione;
import commons.servizio.GestioneCentriMonitoraggio;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * La classe {@code AreaOperatore} rappresenta l'interfaccia grafica principale per l'operatore nel sistema.
 * <p>
 * Fornisce le funzionalità di registrazione di nuovi centri di monitoraggio, selezione di centri esistenti,
 * e ricerca di punti di interesse. Include anche l'interfaccia per gestire l'autenticazione dell'operatore
 * e interagire con i centri di monitoraggio.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class AreaOperatore extends javax.swing.JFrame {
    /** L'oggetto per l'autenticazione dell'operatore. */
    Autenticazione autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();

    /** L'oggetto per la gestione dei centri di monitoraggio. */
    GestioneCentriMonitoraggio gestioneCentriMonitoraggio = ClientRMI.ottieniClientRMI().ottieniStubGestioneCentriMonitoraggio();

    /** Il nome del centro di monitoraggio associato all'operatore. */
    String nomeCentroMonitoraggioOperatore;

    /** L'oggetto operatore passato all'area operatore. */
    Operatore operatorePassato;

    /** Il nome del paese selezionato nella combo box. */
    String sceltaPaese = null;

    /** Il nome del paese selezionato. */
    String nomePaese = null;

    /** Il codice del paese selezionato. */
    String cc = null;
    
    /**
     * Costruttore predefinito della classe {@code AreaOperatore}.
     * <p>
     * Inizializza l'interfaccia grafica e imposta lo sfondo.
     * </p>
     */
    public AreaOperatore(){
        initComponents();
    }

    /**
     * Costruttore della classe {@code AreaOperatore} che accetta l'ID e la password dell'operatore.
     * <p>
     * Inizializza l'interfaccia grafica e configura le opzioni in base all'autenticazione dell'operatore.
     * </p>
     *
     * @param id l'ID dell'operatore
     * @param password la password dell'operatore
     */
    public AreaOperatore(int id, String password){
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
        operatorePassato = new Operatore(id, password);

        try {
            if (autenticazione.loginSenzaBcrypt(operatorePassato.getUsername(), operatorePassato.getPassword()) == true) {
                operatorePassato = autenticazione.ottieniOperatoreAutenticato();
                out1.setText("OPERATORE " + operatorePassato.getUsername());

                if (operatorePassato.getIdCentroMonitoraggio() == null ) {
                    titReg.setVisible(true);
                    registraCentro.setVisible(true);
                    scegliCentro.setVisible(true);
                    scelta.setVisible(false);
                    cercaParam.setVisible(false);
                    out2.setVisible(false);
                    out3.setVisible(false);
                } else {
                    titReg.setVisible(false);
                    registraCentro.setVisible(false);
                    scegliCentro.setVisible(false);
                    cercaParam.setVisible(true);
                    scelta.setVisible(true);
                    out2.setVisible(true);
                    out3.setVisible(true);
                    out2.setText("Centro " + operatorePassato.getIdCentroMonitoraggio());
                    nomeCentroMonitoraggioOperatore = operatorePassato.getIdCentroMonitoraggio();
                    ArrayList<PuntoInteresse> areeAssociate = gestioneCentriMonitoraggio.ottieniAreeAssociate(nomeCentroMonitoraggioOperatore);
                    ArrayList<String> names = new ArrayList<>();

                    for(PuntoInteresse punto: areeAssociate){
                        names.add(punto.getNomePuntoInteresseASCII() + " " + punto.getCodiceNazione());
                    }

                    names.add(0, "nessun paese");

                    String[] namesArray = names.toArray(new String[0]);
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(namesArray);
                    scelta.setModel(model);
                }
            }
        } catch(RemoteException ex) {
            System.err.println("Errore RMI");
            ex.printStackTrace();
            System.exit(1);
        }
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
     * Costruttore predefinito della classe {@code AreaOperatore}.
     * <p>
     * Inizializza l'interfaccia grafica e imposta lo sfondo.
     * </p>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        registraCentro = new javax.swing.JButton();
        scegliCentro = new javax.swing.JButton();
        scelta = new javax.swing.JComboBox<>();
        titReg = new javax.swing.JLabel();
        cercaParam = new javax.swing.JButton();
        out3 = new javax.swing.JLabel();
        out2 = new javax.swing.JLabel();
        titolo = new javax.swing.JLabel();
        out1 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 254, -1, -1));

        registraCentro.setText("Registra");
        registraCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registraCentroActionPerformed(evt);
            }
        });
        getContentPane().add(registraCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        scegliCentro.setText("Scegli");
        scegliCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scegliCentroActionPerformed(evt);
            }
        });
        getContentPane().add(scegliCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 80, -1));

        scelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceltaActionPerformed(evt);
            }
        });
        getContentPane().add(scelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, 30));

        titReg.setText("REGISTRA IL CENTRO");
        getContentPane().add(titReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 18));

        cercaParam.setText("Cerca");
        cercaParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercaParamActionPerformed(evt);
            }
        });
        getContentPane().add(cercaParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 80, 30));

        out3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(out3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 90, 26));

        out2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(out2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 260, 24));

        titolo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        titolo.setText("AREA OPERATORE");
        getContentPane().add(titolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        out1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(out1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 240, 24));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestisce l'azione del pulsante "Indietro".
     * <p>
     * Quando l'utente clicca sul pulsante "Indietro", questo metodo crea una nuova istanza di {@link Login},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra di login.
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
        if(autenticazione != null){
            Login l = new Login();
            l.setLocation(this.getX(), this.getY());
            this.dispose();
            l.setVisible(true); 
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_backActionPerformed

    /**
     * Gestisce l'azione del pulsante "Registra".
     * <p>
     * Quando l'utente clicca sul pulsante "Registra", questo metodo crea una nuova istanza di {@link RegistraCentro},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra per la registrazione del centro.
     * </p>
     * <p>
     * Se l'oggetto di autenticazione è nullo, il metodo chiama {@link ResetClient#spegniClient}
     * per spegnere il client.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void registraCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registraCentroActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null){
            RegistraCentro rc = new RegistraCentro(operatorePassato.getUsername(), operatorePassato.getPassword());
            rc.setLocation(this.getX(), this.getY());
            this.dispose();
            rc.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_registraCentroActionPerformed

    /**
     * Gestisce l'azione del pulsante "Cerca".
     * <p>
     * Quando l'utente clicca sul pulsante "Cerca", questo metodo verifica se un paese è selezionato nella
     * {@link JComboBox} e non è "nessun paese". Se è valido, recupera il punto di interesse associato
     * e crea una nuova istanza di {@link Parametri} con i dettagli dell'operatore e del punto di interesse.
     * La nuova finestra viene poi mostrata all'utente. Se il paese selezionato è "nessun paese" o
     * l'oggetto di autenticazione è nullo, viene visualizzato un messaggio di errore e il client viene spento.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void cercaParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercaParamActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null){
            out3.setText("");
            PuntoInteresse p;

            if(sceltaPaese != null && sceltaPaese != "nessun paese"){
                try {
                    p = gestioneCentriMonitoraggio.ottieniPaese(nomePaese, cc, nomeCentroMonitoraggioOperatore);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
                Parametri pa = new Parametri(operatorePassato.getUsername(), operatorePassato.getPassword(), nomeCentroMonitoraggioOperatore, p);
                pa.setLocation(this.getX(), this.getY());
                this.dispose();
                pa.setVisible(true);
            }else
            out3.setText("Invalido");
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_cercaParamActionPerformed

    /**
     * Gestisce l'azione della selezione di un elemento nella {@link JComboBox}.
     * <p>
     * Quando l'utente seleziona un elemento nella {@link JComboBox}, questo metodo aggiorna i valori
     * {@code nomePaese} e {@code cc} in base all'elemento selezionato.
     * </p>
     *
     * @param evt l'evento di azione generato dalla selezione dell'elemento nella {@link JComboBox}
     */
    private void sceltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceltaActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null){
            sceltaPaese = (String) scelta.getSelectedItem();
            String[] parts = sceltaPaese.split(" ");
            nomePaese = parts[0];
            cc = parts[1];
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_sceltaActionPerformed

    /**
     * Gestisce l'azione del pulsante "Scegli".
     * <p>
     * Quando l'utente clicca sul pulsante "Scegli", questo metodo crea una nuova istanza di {@link ScegliCentro},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra per la selezione di centri di monitoraggio.
     * </p>
     * <p>
     * Se l'oggetto di autenticazione è nullo, il metodo chiama {@link ResetClient#spegniClient}
     * per spegnere il client.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void scegliCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scegliCentroActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        if(autenticazione != null){
            ScegliCentro sc = new ScegliCentro(operatorePassato.getUsername(), operatorePassato.getPassword());
            sc.setLocation(this.getX(), this.getY());
            this.dispose();
            sc.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_scegliCentroActionPerformed
 
    /**
     * Metodo principale per avviare il frame {@code AreaOperatore}.
     * <p>Crea e visualizza l'istanza di {@code AreaOperatore}.</p>
     *
     * @param args gli argomenti della riga di comando
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
            java.util.logging.Logger.getLogger(AreaOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaOperatore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaOperatore().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cercaParam;
    private javax.swing.JLabel out1;
    private javax.swing.JLabel out2;
    private javax.swing.JLabel out3;
    private javax.swing.JButton registraCentro;
    private javax.swing.JButton scegliCentro;
    private javax.swing.JComboBox<String> scelta;
    private javax.swing.JLabel sfondo;
    private javax.swing.JLabel titReg;
    private javax.swing.JLabel titolo;
    // End of variables declaration//GEN-END:variables
}