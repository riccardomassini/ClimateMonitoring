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
import commons.oggetti.misurazioni.CategorieParametriClimatici;
import commons.oggetti.PuntoInteresse;
import commons.oggetti.misurazioni.Misurazione;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import commons.oggetti.misurazioni.PunteggioParametroClimatico;
import commons.servizio.GestioneMisurazioni;
import commons.servizio.RicercaPuntiInteresse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * La classe {@code StampaParametri} rappresenta il frame di stampa dei parametri, utilizzato per scegliere un'area di interesse e visualizzarne le rilevazioni.
 * <p>
 * Questa classe fornisce l'interfaccia utente per monitorare e visualizzare le
 * rilevazioni su determinate aree di interesse. Utilizza RMI per ottenere e gestire
 * le rilevazioni.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class StampaParametri extends JFrame {

    /** Gestisce le misurazioni. */
    private GestioneMisurazioni gestioneMisurazioni;

    /** Interfaccia per la ricerca dei punti di interesse. */
    private RicercaPuntiInteresse ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();

    /** Modello di tabella per la visualizzazione delle misurazioni. */
    private DefaultTableModel model1, model2, model3;

    /**
     * Costruttore della classe {@code StampaParametri}.
     * <p>
     * Inizializza l'interfaccia utente, imposta l'immagine di sfondo, aggiunge un listener per la chiusura della finestra e
     * imposta le dimensioni della finestra come non modificabili. Inoltre, inizializza i modelli di tabella e li svuota.
     * </p>
     */
    public StampaParametri() {
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
        model1 = (DefaultTableModel) tabella1.getModel(); 
        model1.setRowCount(0);
        model2 = (DefaultTableModel) tabella2.getModel(); 
        model2.setRowCount(0);
        model3 = (DefaultTableModel) tabella3.getModel(); 
        model3.setRowCount(0);
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

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ric1 = new javax.swing.JTextField();
        ric2 = new javax.swing.JTextField();
        cerca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabella1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabella2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabella3 = new javax.swing.JTable();
        out = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("STAMPA PARAMETRI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 440, 40));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 503, -1, -1));

        jLabel2.setText("Inserisci Area");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        getContentPane().add(ric1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 89, 93, -1));
        getContentPane().add(ric2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 117, 93, -1));

        cerca.setText("Cerca");
        cerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercaActionPerformed(evt);
            }
        });
        getContentPane().add(cerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 145, 93, -1));

        tabella1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Centro", "Paese", "Data", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa", "nota1", "nota2", "nota3", "nota4", "nota5", "nota6", "nota7"
            }
        )
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }
    );
    jScrollPane1.setViewportView(tabella1);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 67, 1020, 303));

    tabella2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine", "Massa"
        }
    )
    {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
    );
    jScrollPane2.setViewportView(tabella2);

    getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 382, 1020, 52));

    tabella3.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa"
        }
    )
    {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
    );
    jScrollPane3.setViewportView(tabella3);

    getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 446, 1020, 49));
    getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 200, 150, 25));
    getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 550));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestisce l'azione del pulsante "Indietro".
     * <p>
     * Quando l'utente clicca sul pulsante "Indietro", questo metodo crea una nuova istanza di {@link Cittadino},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra di Cittadino.
     * </p>
     * <p>
     * Se l'oggetto di autenticazione è nullo, il metodo chiama {@link ResetClient#spegniClient}
     * per spegnere il client.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void backActionPerformed(ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
        
        if(gestioneMisurazioni != null){
            Cittadino cit = new Cittadino();
            cit.setLocation(this.getX(), this.getY());
            this.dispose();
            cit.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_backActionPerformed

    /**
     * Metodo chiamato quando viene eseguita l'azione di ricerca.
     * <p>
     * Recupera le misurazioni per un punto di interesse specificato e aggiorna le tabelle con i dati delle misurazioni.
     * Se il punto di interesse non viene trovato o non ci sono misurazioni, viene visualizzato un messaggio di errore.
     * </p>
     *
     * @param evt Evento generato dall'azione.
     */
    private void cercaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cercaActionPerformed
        gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
        
        if(gestioneMisurazioni != null){
            out.setText("");

            Misurazione[] elencoMisurazioni = null;
            String nomePuntoInteresse = ric1.getText();
            String codiceNazione = ric2.getText();
            PuntoInteresse puntoInteresse = null;
            PuntoInteresse[] elencoPuntiInteresse = null;
            Object[] medie = new Object[CategorieParametriClimatici.values().length];
            Object[] mode = new Object[CategorieParametriClimatici.values().length];

            try {
                puntoInteresse = ricercaPuntiInteresse.ricercaPerNomeENazione(nomePuntoInteresse, codiceNazione);
            } catch(RemoteException ex) {
                System.err.println("Errore RMI: ricerca del punto di interesse associato fallita");
                ex.printStackTrace();
                System.exit(1);
            }

            if(puntoInteresse == null) {
                out.setText("Nessun paese trovato");
                resetTable();
                return;
            }

            try {
                elencoMisurazioni = gestioneMisurazioni.ottieniMisurazioniSuPuntoInteresse(puntoInteresse.getIdPuntoInteresse());
            } catch(RemoteException ex) {
                System.err.println("Errore RMI: recupero delle misurazioni sul punto di interesse fallita");
                ex.printStackTrace();
                System.exit(1);
            }

            if(elencoMisurazioni.length == 0) {
                out.setText("Nessuna rilevazione");
                resetTable();
                return;
            }

            resetTable();

            for(Misurazione misurazione : elencoMisurazioni) {
                model1.addRow(estraiMisurazione(misurazione));
            }

            for(CategorieParametriClimatici categoria : CategorieParametriClimatici.values()) {
                medie[categoria.ordinal()] = calcolaMedia(elencoMisurazioni, categoria);
                mode[categoria.ordinal()] = calcolaModa(elencoMisurazioni, categoria);
            }

            model2.addRow(medie);
            model3.addRow(mode);
        }else{
            ResetClient.spegniClient(this);
        }

    }//GEN-LAST:event_cercaActionPerformed

    /**
     * Estrae i dati da una misurazione e li restituisce come array di oggetti.
     * <p>
     * L'array risultante contiene informazioni sul centro, l'ID del punto di interesse, il timestamp e le valutazioni dei parametri.
     * </p>
     *
     * @param misurazione La misurazione da cui estrarre i dati.
     * @return Un array di oggetti contenente i dati della misurazione.
     */
    private Object[] estraiMisurazione(Misurazione misurazione) {
        Object[] datiMisurazione = new Object[20];
        int i = 0;
        datiMisurazione[i++] = misurazione.getNomeCentro();
        datiMisurazione[i++] = misurazione.getIdPuntoInteresse();
        datiMisurazione[i++] = misurazione.getTimestampMisurazione();
        for(CategorieParametriClimatici categoria : CategorieParametriClimatici.values()) {
            datiMisurazione[i] = misurazione.getValutazioneParametroConCategoria(categoria);
            datiMisurazione[i + CategorieParametriClimatici.values().length] = misurazione.getCommentoParametroConCategoria(categoria);
            i++;
        }
        return datiMisurazione;
    }

    /**
     * Calcola la media delle valutazioni per una categoria di parametri climatici.
     * <p>
     * La media viene calcolata sommando tutte le valutazioni non nulle e dividendo per il numero di valutazioni.
     * </p>
     *
     * @param elencoMisurazioni L'array delle misurazioni.
     * @param categoria La categoria di parametri climatici.
     * @return La media delle valutazioni per la categoria specificata.
     */
    private double calcolaMedia(Misurazione[] elencoMisurazioni, CategorieParametriClimatici categoria) {
        int somma = 0;
        int nValutazioni = 0;
        for(Misurazione misurazione : elencoMisurazioni) {
            if(misurazione.getValutazioneParametroConCategoria(categoria) != PunteggioParametroClimatico.NULLO.getPunteggio()) {
                somma += misurazione.getValutazioneParametroConCategoria(categoria);
                nValutazioni++;
            }
        }
        
        if(nValutazioni == 0)
            return 0;
        
        return (double) somma / nValutazioni;
    }

    /**
     * Calcola la moda delle valutazioni per una categoria di parametri climatici.
     * <p>
     * La moda è il valore che appare con maggiore frequenza nelle valutazioni.
     * </p>
     *
     * @param elencoMisurazioni L'array delle misurazioni.
     * @param categoria La categoria di parametri climatici.
     * @return La moda delle valutazioni per la categoria specificata.
     */
    private Object calcolaModa(Misurazione[] elencoMisurazioni, CategorieParametriClimatici categoria) {
        int[] conteggioPunteggi = new int[PunteggioParametroClimatico.values().length - 1];
        int totalNonZeroCounts = 0;

        for(Misurazione misurazione : elencoMisurazioni) {
            if (misurazione.getValutazioneParametroConCategoria(categoria) != PunteggioParametroClimatico.NULLO.getPunteggio()) {
                conteggioPunteggi[misurazione.getValutazioneParametroConCategoria(categoria) - 1]++;
                totalNonZeroCounts++;
            }
        }

        int max = 0;
        int maxPunteggio = 1;
        boolean tuttiUno = true;

        for(int i = 0; i < conteggioPunteggi.length; i++) {
            if(conteggioPunteggi[i] > max) {
                max = conteggioPunteggi[i];
                maxPunteggio = i + 1;
            }
            if(conteggioPunteggi[i] > 1) {
                tuttiUno = false;
            }
        }

        if(max==0)
            return PunteggioParametroClimatico.NULLO.getPunteggio();
        if(tuttiUno && totalNonZeroCounts > 1)
            return "Inesistente";
        return PunteggioParametroClimatico.values()[maxPunteggio].getPunteggio();
    }

    /**
     * Ripristina le tabelle svuotando tutte le righe.
     * <p>
     * Questo metodo viene chiamato per resettare i dati visualizzati nelle tabelle.
     * </p>
     */
    private void resetTable(){
        model1.setRowCount(0);
        model2.setRowCount(0);
        model3.setRowCount(0);
    }


    /**
     * Metodo principale che avvia il frame {@code StampaParametri}.
     * <p>Crea e visualizza l'istanza di {@code StampaParametri}.</p>
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StampaParametri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(StampaParametri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(StampaParametri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(StampaParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StampaParametri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cerca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel out;
    private javax.swing.JTextField ric1;
    private javax.swing.JTextField ric2;
    private javax.swing.JLabel sfondo;
    private javax.swing.JTable tabella1;
    private javax.swing.JTable tabella2;
    private javax.swing.JTable tabella3;
    // End of variables declaration//GEN-END:variables
}