/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.frame;

import client.clientrmi.ClientRMI;
import client.registraeventi.Chiusura;

import java.rmi.RemoteException;

import commons.oggetti.Operatore;
import commons.servizio.Autenticazione;

/**
 *
 * @author hew15bc502nl
 */
public class Login extends javax.swing.JFrame {
    Autenticazione autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
    
    public Login() {
        initComponents();
        addWindowListener(new Chiusura());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        log = new javax.swing.JLabel();
        ident = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        log.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        log.setText("LOGIN");
        getContentPane().add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 14, 70, 35));

        ident.setAlignmentY(0.0F);
        ident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identActionPerformed(evt);
            }
        });
        getContentPane().add(ident, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 89, 109, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        FrameOperatore op = new FrameOperatore();
        op.setLocation(this.getX(), this.getY());
        this.setVisible(false);
        op.setVisible(true); 
    }//GEN-LAST:event_backActionPerformed

    private void identActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identActionPerformed

    }//GEN-LAST:event_identActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        out.setText("");

        int usernameOperatore = 0;

        try{
            usernameOperatore = Integer.parseInt(ident.getText());
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }

        Operatore operatore = new Operatore(usernameOperatore, String.copyValueOf(password.getPassword()));

        //TODO rmi client
        try {
            if (autenticazione.login(operatore.getUsername(), operatore.getPassword())) {
                AreaOperatore ao = new AreaOperatore(operatore.getUsername(), operatore.getPassword());
                ao.setLocation(this.getX(), this.getY());
                this.setVisible(false);
                ao.setVisible(true);
            } else {
                if (usernameOperatore == 0)
                    out.setText("ID non valido");
                else
                    out.setText("Utente non registrato");
            }
        } catch(RemoteException ex) {
            System.err.println("Errore RMI");
            ex.printStackTrace();
            System.exit(1);
        }
            
    }//GEN-LAST:event_okActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField ident;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel log;
    private javax.swing.JButton ok;
    private javax.swing.JLabel out;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}