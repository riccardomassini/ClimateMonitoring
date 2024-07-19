/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import RegistraEventi.*;
import gestionefile.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oggetti.*;

public class RegistraCentro extends javax.swing.JFrame {

    GestisciCentri gc = new GestisciCentri();
    GestisciOperatori go = new GestisciOperatori();
    GestisciPaesi gp = new GestisciPaesi();
    ArrayList<Paese> aree = new ArrayList<>();
    ArrayList<OperatoriClimatici> op = new ArrayList<>();
    LoggerEventi logger = LoggerEventi.getInstance();
    OperatoriClimatici passato;
    boolean centroPresente = false;
    int count;
    
    public RegistraCentro() {
        initComponents();
    }
    
    public RegistraCentro(int id, String pass){
        initComponents();
        addWindowListener(new Chiusura());
        passato = new OperatoriClimatici(id, pass);
        areeLabel.setVisible(false);
        nomepReg.setVisible(false);
        codiceReg.setVisible(false);
        insAree.setVisible(false);
        centroReg.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        areeLabel = new javax.swing.JLabel();
        nomepReg = new javax.swing.JTextField();
        codiceReg = new javax.swing.JTextField();
        centroReg = new javax.swing.JButton();
        out1 = new javax.swing.JLabel();
        insAree = new javax.swing.JButton();
        out2 = new javax.swing.JLabel();
        out3 = new javax.swing.JLabel();
        out4 = new javax.swing.JLabel();
        out5 = new javax.swing.JLabel();
        out6 = new javax.swing.JLabel();
        out7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        out8 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRA CENTRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 6, -1, 43));
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
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 240, 78, 22));

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

        areeLabel.setText("Inserisci aree");
        getContentPane().add(areeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 67, 86, 22));
        getContentPane().add(nomepReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 95, 86, -1));
        getContentPane().add(codiceReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 123, 86, -1));

        centroReg.setText("Registra");
        centroReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centroRegActionPerformed(evt);
            }
        });
        getContentPane().add(centroReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 208, 86, -1));
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(out8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(out8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 530, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        AreaOperatore ao = new AreaOperatore(passato.getUserID(), passato.getPassword());
        ao.setLocation(this.getX(), this.getY());
        this.setVisible(false);
        ao.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void cliccaRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliccaRegActionPerformed
        out1.setText("");
        out2.setText("");
        out3.setText("");
        out4.setText("");
        out5.setText("");
        out6.setText("");
        out7.setText("");
        
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
        if(gc.centroGiaPresente(nome))
            out1.setText("Già presente");
        if(indirizzo.length()<=0)
            out2.setText("Troppo corto");
        if(!gc.controlloCap(cap))
            out4.setText("CAP invalido");
        if(comune.length()<=0)
            out5.setText("Troppo corto");
        if(provincia.length()!=2)
            out6.setText("inserire 2 lettere");
            
        if(nome.length()>0 && !gc.centroGiaPresente(nome) && indirizzo.length()>0 && numCivico != -1 && gc.controlloCap(cap) && comune.length()>0 && provincia.length()==2 && numAree>0){
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

    }//GEN-LAST:event_cliccaRegActionPerformed

    private void centroRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centroRegActionPerformed
        String nome = nomeReg.getText();
        String indirizzo = indReg.getText();
        int numCivico = Integer.parseInt(numcReg.getText());
        String cap = capReg.getText();
        String comune = comReg.getText();
        String provincia = proReg.getText();
        int numAree = Integer.parseInt(numaReg.getText());


        if(gc.registraCentroAree(new CentroMonitoraggio(nome, indirizzo, numCivico, cap, comune, provincia), aree)){
            logger.log("Nuovo centro registrato: " + aree.toString() + " " + nome + " " + indirizzo + " " + numCivico + " " + cap + " " + comune + " " + provincia + " " + numAree);

            try {
                go.setCentro(passato, nome);
            } catch (SQLException ex) {
                Logger.getLogger(RegistraCentro.class.getName()).log(Level.SEVERE, null, ex);
            }
            AreaOperatore ao = new AreaOperatore(passato.getUserID(), passato.getPassword());
            ao.setLocation(this.getX(), this.getY());
            this.setVisible(false);
            ao.setVisible(true);
        }

    }//GEN-LAST:event_centroRegActionPerformed

    private void insAreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insAreeActionPerformed
        out8.setText("");

        String asname = nomepReg.getText();
        String cc = codiceReg.getText();
        int numAree = Integer.parseInt(numaReg.getText());
        Paese p;

        p = gp.ricercaNomeCC(asname, cc);
        
        if(aree.contains(p)){
            out8.setText("Già inserito");
        }else if(p!=null){
            aree.add(p);
            count++;
            out8.setText("Paese inserito");
        }else
            out8.setText("Il paese non esiste");

        if(count==numAree){
            areeLabel.setVisible(false);
            nomepReg.setVisible(false);
            codiceReg.setVisible(false);
            insAree.setVisible(false);
            centroReg.setVisible(true);
        }
    }//GEN-LAST:event_insAreeActionPerformed

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
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextField proReg;
    // End of variables declaration//GEN-END:variables
}
