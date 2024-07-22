/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.frame;

import client.clientrmi.ClientRMI;
import client.registraeventi.Chiusura;
import commons.oggetti.PuntoInteresse;
import commons.oggetti.Misurazione;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import commons.servizio.GestioneMisurazioni;
import commons.servizio.RicercaPuntiInteresse;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author hew15bc502nl
 */
public class StampaParametri extends JFrame {
    GestioneMisurazioni gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
    RicercaPuntiInteresse ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();;
    DefaultTableModel model1, model2, model3;
    
    public StampaParametri() {
        initComponents();
        addWindowListener(new Chiusura());
        model1 = (DefaultTableModel) tabella1.getModel(); 
        model1.setRowCount(0);
        model2 = (DefaultTableModel) tabella2.getModel(); 
        model2.setRowCount(0);
        model3 = (DefaultTableModel) tabella3.getModel(); 
        model3.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel1 = new JLabel();
        back = new JButton();
        jLabel2 = new JLabel();
        ric1 = new JTextField();
        ric2 = new JTextField();
        cerca = new JButton();
        jScrollPane1 = new JScrollPane();
        tabella1 = new JTable();
        jScrollPane2 = new JScrollPane();
        tabella2 = new JTable();
        jScrollPane3 = new JScrollPane();
        tabella3 = new JTable();
        out = new JLabel();
        jPanel1 = new JPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("STAMPA PARAMETRI");
        getContentPane().add(jLabel1, new AbsoluteConstraints(211, 15, -1, 27));

        back.setText("Indietro");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new AbsoluteConstraints(20, 503, -1, -1));

        jLabel2.setText("Inserisci Area");
        getContentPane().add(jLabel2, new AbsoluteConstraints(51, 67, -1, -1));
        getContentPane().add(ric1, new AbsoluteConstraints(38, 89, 93, -1));
        getContentPane().add(ric2, new AbsoluteConstraints(38, 117, 93, -1));

        cerca.setText("Cerca");
        cerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cercaActionPerformed(evt);
            }
        });
        getContentPane().add(cerca, new AbsoluteConstraints(38, 145, 93, -1));

        tabella1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Centro", "Paese", "Data", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa", "nota1", "nota2", "nota3", "nota4", "nota5", "nota6", "nota7"
            }
        ));
        jScrollPane1.setViewportView(tabella1);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(176, 67, 818, 303));

        tabella2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine", "Massa"
            }
        ));
        jScrollPane2.setViewportView(tabella2);

        getContentPane().add(jScrollPane2, new AbsoluteConstraints(176, 382, 818, 52));

        tabella3.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa"
            }
        ));
        jScrollPane3.setViewportView(tabella3);

        getContentPane().add(jScrollPane3, new AbsoluteConstraints(176, 446, 818, 49));
        getContentPane().add(out, new AbsoluteConstraints(28, 200, 136, 25));

        jPanel1.setBackground(new Color(204, 255, 204));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 1020, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Cittadino cit = new Cittadino();
        cit.setLocation(this.getX(), this.getY());
        this.setVisible(false);
        cit.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void cercaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cercaActionPerformed
        out.setText("");
        
        Misurazione[] elencoMisurazioni = null;
        String nomePuntoInteresse = ric1.getText();
        String codiceNazione = ric2.getText();
        PuntoInteresse puntoInteresse = null;
        PuntoInteresse[] elencoPuntiInteresse = null;
        Object[] medie = new Object[7];
        Object[] mode = new Object[7];

        //TODO rmi client
        try {
            elencoPuntiInteresse = ricercaPuntiInteresse.ricercaPerNomeENazione(nomePuntoInteresse, codiceNazione);
        } catch(RemoteException ex) {
            System.err.println("Errore RMI");
            ex.printStackTrace();
            System.exit(1);
        }
        
        if(elencoPuntiInteresse == null)
            out.setText("Non sono stati trovati punti di interesse corrispondenti alla ricerca");
        for(PuntoInteresse puntoInteresseTemp : elencoPuntiInteresse)
            if(puntoInteresseTemp.getNomePuntoInteresseASCII().equalsIgnoreCase(nomePuntoInteresse) && puntoInteresseTemp.getCodiceNazione().equalsIgnoreCase(codiceNazione))
                puntoInteresse = puntoInteresseTemp;
        if(puntoInteresse == null) {
            out.setText("Nessun paese trovato");
            return;
        }

        //TODO rmi client
        try {
            elencoMisurazioni = gestioneMisurazioni.ottieniMisurazioniSuPuntoInteresse(puntoInteresse.getIdPuntoInteresse());
        } catch(RemoteException ex) {
            System.err.println("Errore RMI");
            ex.printStackTrace();
            System.exit(1);
        }
        
        //TODO ATTENZIONE!!! vedere se può funzionare
        if(elencoMisurazioni == null) {
            out.setText("Nessuna rilevazione");
            return;
        }

        model1.setRowCount(0);
        model2.setRowCount(0);
        model3.setRowCount(0);

        for(Misurazione misurazione : elencoMisurazioni) {
            model1.addRow(estraiMisurazione(misurazione));
        }

        for(int i = 0; i < medie.length; i++) {
            medie[i] = calcolaMedia();
            mode[i] = calcolaModa();
        }

        model2.addRow(medie);
        model3.addRow(mode);

    }//GEN-LAST:event_cercaActionPerformed

    private Object[] estraiMisurazione(Misurazione misurazione) {
        Object[] datiMisurazione = new Object[20];
        datiMisurazione[0] = misurazione.getNomeCentro();
        datiMisurazione[1] = misurazione.getTimestampMisurazione();
        datiMisurazione[2] = misurazione.getTimestampMisurazione();
        datiMisurazione[3] = misurazione.getValutazioneVento();
        datiMisurazione[4] = misurazione.getValutazioneUmidita();
        datiMisurazione[5] = misurazione.getValutazionePressione();
        datiMisurazione[6] = misurazione.getValutazioneTemperatura();
        datiMisurazione[7] = misurazione.getValutazionePrecipitazioni();
        datiMisurazione[8] = misurazione.getValutazioneAltitudineGhiacciai();
        datiMisurazione[9]= misurazione.getValutazioneMassaGhiacciai();
        datiMisurazione[10] = misurazione.getCommentoVento();
        datiMisurazione[11] = misurazione.getCommentoUmidita();
        datiMisurazione[12] = misurazione.getCommentoPressione();
        datiMisurazione[13] = misurazione.getCommentoTemperatura();
        datiMisurazione[14] = misurazione.getCommentoPrecipitazioni();
        datiMisurazione[15] = misurazione.getCommentoAltitudineGhiacciai();
        datiMisurazione[16] = misurazione.getCommentoMassaGhiacciai();
        return datiMisurazione;
    }

    private double calcolaMedia() {
        //TODO IMPLEMENTARE CALCOLO MEDIA
        return 0.0;
    }

    private int calcolaModa() {
        //TODO IMPLEMENTARE CALCOLO MODA
        return 0;
    }

    /**
     * @param args the command line arguments
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
    private JButton back;
    private JButton cerca;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTextArea jTextArea1;
    private JLabel out;
    private JTextField ric1;
    private JTextField ric2;
    private JTable tabella1;
    private JTable tabella2;
    private JTable tabella3;
    // End of variables declaration//GEN-END:variables
}
