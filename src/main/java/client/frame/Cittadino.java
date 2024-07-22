/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.frame;

import client.clientrmi.ClientRMI;
import client.registraeventi.Chiusura;
import commons.oggetti.PuntoInteresse;
import commons.servizio.RicercaPuntiInteresse;

import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;

/**
 *
 * @author hew15bc502nl
 */
public class Cittadino extends javax.swing.JFrame {
    RicercaPuntiInteresse ricercaPuntiInteresse = ClientRMI.ottieniClientRMI().ottieniStubRicercaPuntiInteresse();
    DefaultTableModel model;
    
    public Cittadino(){
        initComponents();
        addWindowListener(new Chiusura());
        inizializza();
    }
    
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

        //TODO rmi client
        try {
            elencoPuntiInteresse = ricercaPuntiInteresse.ottieniElencoPuntiInteresse();
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        out = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Longitudine");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 22));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 66, 22));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Latitudine");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, 22));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Stato");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 66, -1));

        out.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca2ActionPerformed
        out.setText("");
        try {
            double latitudine = Double.parseDouble(ric2.getText());
            double longitudine = Double.parseDouble(ric3.getText());

            if(!PuntoInteresse.coordinateValide(latitudine, longitudine)) {
                out.setText("valori inesistenti");
                return;
            }

            PuntoInteresse[] elencoPuntiInteresse = null;

            //TODO rmi client
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

    }//GEN-LAST:event_cerca2ActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
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
            this.setVisible(false);
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
    }//GEN-LAST:event_comboActionPerformed

    private void cerca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca1ActionPerformed
        ric2.setText("");
        ric3.setText("");
        ric4.setText("");
        
        String nome = ric1.getText();
        PuntoInteresse[] elencoPuntiInteresse = null;

        //TODO rmi client
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

    }//GEN-LAST:event_cerca1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        GestioneScelta gs = new GestioneScelta();
        gs.setLocation(this.getX(), this.getY());
        this.setVisible(false);
        gs.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void cerca3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerca3ActionPerformed
        ric1.setText("");
        ric2.setText("");
        ric3.setText("");
        
        String codice = ric4.getText();
        PuntoInteresse[] elencoPuntiInteresse = null;

        //TODO rmi client
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
    }//GEN-LAST:event_cerca3ActionPerformed

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
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cittadino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cittadino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cerca1;
    private javax.swing.JButton cerca2;
    private javax.swing.JButton cerca3;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel out;
    private javax.swing.JTextField ric1;
    private javax.swing.JTextField ric2;
    private javax.swing.JTextField ric3;
    private javax.swing.JTextField ric4;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables
}