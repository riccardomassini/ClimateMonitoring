/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.frame;

import client.registraeventi.Chiusura;
import commons.oggetti.PuntoInteresse;
import commons.oggetti.ParametriClimatici;

import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

import server.servizio.GestisciCentri;
import server.servizio.ricercapoi.RepositoryPuntiInteresse;
import server.servizio.GestisciParametri;

/**
 *
 * @author hew15bc502nl
 */
public class StampaParametri extends javax.swing.JFrame {

    GestisciCentri gc = new GestisciCentri();
    GestisciParametri gParam = new GestisciParametri();
    RepositoryPuntiInteresse gPaesi = new RepositoryPuntiInteresse();
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
        jPanel1 = new javax.swing.JPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("STAMPA PARAMETRI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 15, -1, 27));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 503, -1, -1));

        jLabel2.setText("Inserisci Area");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 67, -1, -1));
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
        ));
        jScrollPane1.setViewportView(tabella1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 67, 818, 303));

        tabella2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine", "Massa"
            }
        ));
        jScrollPane2.setViewportView(tabella2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 382, 818, 52));

        tabella3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa"
            }
        ));
        jScrollPane3.setViewportView(tabella3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 446, 818, 49));
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 200, 136, 25));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Cittadino cit = new Cittadino();
        cit.setLocation(this.getX(), this.getY());
        this.setVisible(false);
        cit.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void cercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercaActionPerformed
        ResultSet set = null;
        ArrayList<ParametriClimatici> parametri;
        out.setText("");
        String nome = ric1.getText();
        String codice = ric2.getText();

        PuntoInteresse paese = gc.ricercaPuntiInteresseAssociati(nome, codice);
        if(paese != null){
            parametri = gParam.ottieniMisurazioniSuPuntoInteresse(paese);
            if(parametri.isEmpty())
                out.setText("Nessuna rilevazione");
            double[] media;
            media = gParam.ottieniMediaMisurazioni();
            int[] moda;
            moda = gParam.ottieniModaMisurazioni();

            //ar = ricercaPOI.ottieniMisurazioniSuPuntoInteresse(nome, codice);
            model1.setRowCount(0);
            model2.setRowCount(0);
            model3.setRowCount(0);

            Object dati[] = new Object[20];
            for(int i=0; i<parametri.size(); i++){
                dati[0] = parametri.get(i).getNomeC();
                dati[1] = parametri.get(i).getData();
                dati[2] = parametri.get(i).getData();
                dati[3] = parametri.get(i).getVento();
                dati[4] = parametri.get(i).getUmidita();
                dati[5] = parametri.get(i).getPressione();
                dati[6] = parametri.get(i).getTemperatura();
                dati[7] = parametri.get(i).getPrecipitazioni();
                dati[8] = parametri.get(i).getAltitudine();
                dati[9]= parametri.get(i).getMassa();
                dati[10] = parametri.get(i).getNoteV();
                dati[11] = parametri.get(i).getNoteU();
                dati[12] = parametri.get(i).getNotePres();
                dati[13] = parametri.get(i).getNoteT();
                dati[14] = parametri.get(i).getNotePrec();
                dati[15] = parametri.get(i).getNoteA();
                dati[16] = parametri.get(i).getNoteM();

                model1.addRow(dati);
            }

            Object dati1[] = new Object[7];
            dati1[0] = media[0];
            dati1[1] = media[1];
            dati1[2] = media[2];
            dati1[3] = media[3];
            dati1[4] = media[4];
            dati1[5] = media[5];
            dati1[6] = media[6];

            if(!parametri.isEmpty())
                model2.addRow(dati1);

            Object dati2[] = new Object[7];
            dati2[0] = moda[0];
            dati2[1] = moda[1];
            dati2[2] = moda[2];
            dati2[3] = moda[3];
            dati2[4] = moda[4];
            dati2[5] = moda[5];
            dati2[6] = moda[6]; 

            if(!parametri.isEmpty())
                model3.addRow(dati1);
        }else
            out.setText("Nessun paese trovato");
        
    }//GEN-LAST:event_cercaActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StampaParametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StampaParametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StampaParametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StampaParametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel out;
    private javax.swing.JTextField ric1;
    private javax.swing.JTextField ric2;
    private javax.swing.JTable tabella1;
    private javax.swing.JTable tabella2;
    private javax.swing.JTable tabella3;
    // End of variables declaration//GEN-END:variables
}
