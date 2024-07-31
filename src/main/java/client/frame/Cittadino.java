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
import commons.oggetti.PuntoInteresse;
import commons.servizio.RicercaPuntiInteresse;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La classe {@code Cittadino} rappresenta una finestra dell'applicazione che consente all'utente di cercare e visualizzare punti di interesse.
 * <p> Estende {@link javax.swing.JFrame} e gestisce le interazioni dell'utente con l'interfaccia grafica per effettuare ricerche su punti di interesse
 * in base a vari criteri come nome, coordinate o stato. </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Cittadino extends javax.swing.JFrame {

    /** Oggetto per la ricerca dei punti di interesse tramite RMI. */
    RicercaPuntiInteresse ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();;

    /** Modello della tabella per visualizzare i risultati della ricerca. */
    DefaultTableModel model;

    /**
     * Crea una nuova istanza della finestra {@code Cittadino}.
     * <p>Inizializza i componenti della finestra, imposta l'immagine di sfondo, e gestisce l'evento di chiusura della finestra.</p>
     */
    public Cittadino(){
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
        inizializza();
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
     * Inizializza i componenti visivi e il modello della tabella.
     * <p>Imposta la visibilità degli elementi in base ai criteri di ricerca e carica l'elenco dei punti di interesse.</p>
     */
    public void inizializza(){
        ric1.setVisible(false);
        ric2.setVisible(false);
        ric3.setVisible(false);
        ric4.setVisible(false);
        cerca1.setVisible(false);
        cerca2.setVisible(false);
        cerca3.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        ric1.setText("");
        ric2.setText("");
        ric3.setText("");
        ric4.setText("");
        model = (DefaultTableModel) tabella.getModel();

        PuntoInteresse[] elencoPuntiInteresse = null;

        try {
            elencoPuntiInteresse = ricercaPuntiInteresse.ottieniElencoPuntiInteresse();
        } catch(RemoteException ex) {
            System.err.println("Errore RMI");
            System.exit(1);
        }

        model.setRowCount(0);
        Object[] dati = new Object[7];

        for(PuntoInteresse puntoInteresse : elencoPuntiInteresse){
            dati[0] = puntoInteresse.getIdPuntoInteresse();
            dati[1] = puntoInteresse.getNomePuntoInteresse();
            dati[2] = puntoInteresse.getNomePuntoInteresseASCII();
            dati[3] = puntoInteresse.getCodiceNazione();
            dati[4] = puntoInteresse.getNomeNazione();
            dati[5] = puntoInteresse.getLatitudine();
            dati[6] = puntoInteresse.getLongitudine();

            model.addRow(dati);
        }
    }

    /**
     * Inizializza i componenti dell'interfaccia utente.
     * <p>
     * Questo metodo è generato automaticamente dal Form Editor e non dovrebbe essere modificato manualmente.
     * </p>
     */
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();
        ric2 = new javax.swing.JTextField();
        ric3 = new javax.swing.JTextField();
        cerca2 = new javax.swing.JButton();
        ric1 = new javax.swing.JTextField();
        cerca1 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        ric4 = new javax.swing.JTextField();
        cerca3 = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CITTADINO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 8, 127, 46));

        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "geonameID", "nome", "nome_ascii", "codice_stato", "nome_stato", "lat", "lon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabella);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 520, 358));
        getContentPane().add(ric2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 92, -1));
        getContentPane().add(ric3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 92, -1));

        cerca2.setText("Cerca");
        cerca2.setAlignmentX(0.5F);
        cerca2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerca2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cerca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerca2ActionPerformed(evt);
            }
        });
        getContentPane().add(cerca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 92, -1));
        getContentPane().add(ric1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 92, -1));

        cerca1.setText("Cerca");
        cerca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerca1ActionPerformed(evt);
            }
        });
        getContentPane().add(cerca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 92, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "scelta", "nome", "stato", "coordinate", "parametri" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 60, -1, -1));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 401, -1, -1));
        getContentPane().add(ric4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 92, -1));

        cerca3.setText("Cerca");
        cerca3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerca3ActionPerformed(evt);
            }
        });
        getContentPane().add(cerca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 92, -1));

        out.setBackground(new java.awt.Color(255, 255, 255));
        out.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Longitudine");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Nome");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 66, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Latitudine");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Stato");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 66, -1));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 430));

        pack();
    }

    /**
     * Gestisce l'evento di azione del pulsante {@code cerca2}.
     * <p>Effettua una ricerca di punti di interesse in base alle coordinate inserite dall'utente e aggiorna la tabella con i risultati.</p>
     * <p>Mostra un messaggio di errore se i valori inseriti non sono validi.</p>
     * {@link ResetClient#spegniClient}
     *
     * @param evt l'evento di azione generato dal pulsante {@code cerca2}.
     */
    private void cerca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca2ActionPerformed
        ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();
        if(ricercaPuntiInteresse != null){
            out.setText("");
            try {
                double latitudine = Double.parseDouble(ric2.getText());
                double longitudine = Double.parseDouble(ric3.getText());

                if(!PuntoInteresse.coordinateValide(latitudine, longitudine)) {
                    out.setText("valori inesistenti");
                    return;
                }

                PuntoInteresse[] elencoPuntiInteresse = null;

                try {
                    elencoPuntiInteresse = ricercaPuntiInteresse.ricercaPerCoordinate(latitudine, longitudine);
                } catch(RemoteException ex) {
                    System.err.println("Errore RMI");
                    ex.printStackTrace();
                    System.exit(1);
                }

                model.setRowCount(0);
                Object[] dati = new Object[7];

                for(PuntoInteresse puntoInteresse : elencoPuntiInteresse){
                    dati[0] = puntoInteresse.getIdPuntoInteresse();
                    dati[1] = puntoInteresse.getNomePuntoInteresse();
                    dati[2] = puntoInteresse.getNomePuntoInteresseASCII();
                    dati[3] = puntoInteresse.getCodiceNazione();
                    dati[4] = puntoInteresse.getNomeNazione();
                    dati[5] = puntoInteresse.getLatitudine();
                    dati[6] = puntoInteresse.getLongitudine();

                    model.addRow(dati);
                }

            } catch(NumberFormatException ex) {
                out.setText("Valori non validi");
            }
        }else{
            ResetClient.spegniClient(this);
        }

    }

    /**
     * Gestisce l'evento di azione del componente {@code combo}.
     * <p>Aggiorna la visibilità dei componenti di ricerca e, se necessario, apre la finestra di stampa dei parametri o reimposta la vista di ricerca.</p>
     * {@link ResetClient#spegniClient}
     *
     * @param evt l'evento di azione generato dal componente {@code combo}.
     */
    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        
        ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();
        if(ricercaPuntiInteresse != null){
            String parametroSelezione = (String) combo.getSelectedItem();

            ric1.setVisible(parametroSelezione.equals("nome"));
            ric2.setVisible(parametroSelezione.equals("coordinate"));
            ric3.setVisible(parametroSelezione.equals("coordinate"));
            ric4.setVisible(parametroSelezione.equals("stato"));
            cerca1.setVisible(parametroSelezione.equals("nome"));
            cerca2.setVisible(parametroSelezione.equals("coordinate"));
            cerca3.setVisible(parametroSelezione.equals("stato"));
            jLabel2.setVisible(parametroSelezione.equals("stato"));
            jLabel3.setVisible(parametroSelezione.equals("nome"));
            jLabel4.setVisible(parametroSelezione.equals("coordinate"));
            jLabel5.setVisible(parametroSelezione.equals("coordinate"));

            if (parametroSelezione.equals("parametri")) {
                StampaParametri sp = new StampaParametri();
                sp.setLocation(this.getX(), this.getY());
                this.dispose();
                sp.setVisible(true);
            }else if(parametroSelezione.equals("scelta")){
                inizializza();

            }else if(parametroSelezione.equals("nome")){
                ric2.setText("");
                ric3.setText("");
                ric4.setText("");
            }else if(parametroSelezione.equals("coordinate")){
                ric1.setText("");
                ric4.setText("");
            }else{
                ric1.setText("");
                ric2.setText("");
                ric3.setText("");
            }
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Gestisce l'evento di azione del pulsante {@code cerca1}.
     * <p>Effettua una ricerca di punti di interesse in base al nome inserito dall'utente e aggiorna la tabella con i risultati.</p>
     * {@link ResetClient#spegniClient}
     *
     * @param evt l'evento di azione generato dal pulsante {@code cerca1}.
     */
    private void cerca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca1ActionPerformed
        
        ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();
        if(ricercaPuntiInteresse != null){
            ric2.setText("");
            ric3.setText("");
            ric4.setText("");

            String nome = ric1.getText();
            PuntoInteresse[] elencoPuntiInteresse = null;

            try {
                elencoPuntiInteresse = ricercaPuntiInteresse.ricercaPerNome(nome);
            } catch(RemoteException ex) {
                System.err.println("Errore RMI");
                ex.printStackTrace();
                System.exit(1);
            }

            model.setRowCount(0);
            Object[] dati = new Object[7];

            for(PuntoInteresse puntoInteresse : elencoPuntiInteresse){
                dati[0] = puntoInteresse.getIdPuntoInteresse();
                dati[1] = puntoInteresse.getNomePuntoInteresse();
                dati[2] = puntoInteresse.getNomePuntoInteresseASCII();
                dati[3] = puntoInteresse.getCodiceNazione();
                dati[4] = puntoInteresse.getNomeNazione();
                dati[5] = puntoInteresse.getLatitudine();
                dati[6] = puntoInteresse.getLongitudine();

                model.addRow(dati);
            }
        }else{
            ResetClient.spegniClient(this);
        }

    }

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
        ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();
        if(ricercaPuntiInteresse != null){
            GestioneScelta gs = new GestioneScelta();
            gs.setLocation(this.getX(), this.getY());
            this.dispose();
            gs.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Gestisce l'evento di azione del pulsante {@code cerca3}.
     * <p>Effettua una ricerca di punti di interesse in base al codice della nazione inserito dall'utente e aggiorna la tabella con i risultati.</p>
     * <p>Se si verifica un errore durante la comunicazione RMI, viene stampato un messaggio di errore e il programma viene terminato.</p>
     * {@link ResetClient#spegniClient}
     *
     * @param evt l'evento di azione generato dal pulsante {@code cerca3}.
     */
    private void cerca3ActionPerformed(java.awt.event.ActionEvent evt) {
        ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();
        if(ricercaPuntiInteresse != null){
            ric1.setText("");
            ric2.setText("");
            ric3.setText("");

            String codice = ric4.getText();
            PuntoInteresse[] elencoPuntiInteresse = null;

            try {
                elencoPuntiInteresse = ricercaPuntiInteresse.ricercaPerNazione(codice);
            } catch(RemoteException ex) {
                System.err.println("Errore RMI");
                ex.printStackTrace();
                System.exit(1);
            }

            model.setRowCount(0);
            Object[] dati = new Object[7];

            for(PuntoInteresse puntoInteresse : elencoPuntiInteresse){
                dati[0] = puntoInteresse.getIdPuntoInteresse();
                dati[1] = puntoInteresse.getNomePuntoInteresse();
                dati[2] = puntoInteresse.getNomePuntoInteresseASCII();
                dati[3] = puntoInteresse.getCodiceNazione();
                dati[4] = puntoInteresse.getNomeNazione();
                dati[5] = puntoInteresse.getLatitudine();
                dati[6] = puntoInteresse.getLongitudine();

                model.addRow(dati);
            }
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Metodo principale che avvia l'applicazione {@code Cittadino}.
     * <p>Imposta il look and feel Nimbus e crea e visualizza la finestra principale.</p>
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
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cittadino().setVisible(true);
            }
        });
    }

    /** Bottone per tornare alla schermata precedente */
    private javax.swing.JButton back;

    /** Bottone per cercare punti di interesse per nome */
    private javax.swing.JButton cerca1;

    /** Bottone per cercare punti di interesse per coordinate */
    private javax.swing.JButton cerca2;

    /** Bottone per cercare punti di interesse per codice nazione */
    private javax.swing.JButton cerca3;

    /** ComboBox per selezionare il tipo di ricerca */
    private javax.swing.JComboBox<String> combo;

    /** Etichetta per il campo di ricerca per nome */
    private javax.swing.JLabel jLabel1;

    /** Etichetta per il campo di ricerca per coordinate */
    private javax.swing.JLabel jLabel2;

    /** Etichetta per il campo di ricerca per coordinate */
    private javax.swing.JLabel jLabel3;

    /** Etichetta per il campo di ricerca per coordinate */
    private javax.swing.JLabel jLabel4;

    /** Etichetta per il campo di ricerca per stato */
    private javax.swing.JLabel jLabel5;

    /** ScrollPane per la tabella dei risultati */
    private javax.swing.JScrollPane jScrollPane2;

    /** ScrollPane per la tabella dei risultati */
    private javax.swing.JScrollPane jScrollPane3;

    /** Tabella per visualizzare i risultati della ricerca */
    private javax.swing.JTable jTable1;

    /** Etichetta per visualizzare messaggi di output */
    private javax.swing.JLabel out;


    /** Campo di testo per inserire il nome del punto di interesse */
    private javax.swing.JTextField ric1;

    /** Campo di testo per inserire la latitudine */
    private javax.swing.JTextField ric2;

    /** Campo di testo per inserire la longitudine */
    private javax.swing.JTextField ric3;

    /** Campo di testo per inserire il codice della nazione */
    private javax.swing.JTextField ric4;

    /** Etichetta per lo sfondo */
    private javax.swing.JLabel sfondo;

    /** Tabella per visualizzare i punti di interesse */
    private javax.swing.JTable tabella;
}