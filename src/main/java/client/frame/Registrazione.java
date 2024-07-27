/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.frame;

import client.clientrmi.ClientRMI;
import client.clientrmi.ResetClient;
import client.registraeventi.Chiusura;
import commons.oggetti.Operatore;
import commons.oggetti.ValidatorePassword;
import commons.servizio.Autenticazione;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

public class Registrazione extends javax.swing.JFrame {
    Autenticazione autenticazione;
    
    public Registrazione() {
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
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("REGISTRAZIONE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 38));
        getContentPane().add(nomeReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 50, 85, -1));
        getContentPane().add(cfReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 118, 85, -1));

        mailReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailRegActionPerformed(evt);
            }
        });
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
        getContentPane().add(out2, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 84, 210, 22));
        getContentPane().add(cognomeReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 84, 85, -1));

        jLabel7.setText("Cognome");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 84, 67, 22));
        getContentPane().add(out3, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 118, 270, 22));
        getContentPane().add(out1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 50, 250, 22));

        out4.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(out4, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 152, 310, 22));
        getContentPane().add(out5, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 186, 210, 22));
        getContentPane().add(out6, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 220, 340, 22));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mailRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailRegActionPerformed

    }//GEN-LAST:event_mailRegActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        autenticazione = ClientRMI.ottieniClientRMI().ottieniStubAutenticazione();
        
        if(autenticazione != null){
            FrameOperatore op = new FrameOperatore();
            op.setLocation(this.getX(), this.getY());
            this.dispose();
            op.setVisible(true); 
        } else {
             ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_backActionPerformed

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
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
                out5.setText("l'ID inserito non è un numero valido");
                valido = false;
            }

            if(nome == null || nome.isEmpty()) {
                out1.setText("Il nome inserito non è valido");
                valido = false;
            }
            if(cognome == null || cognome.isEmpty()) {
                out2.setText("Il cognome inserito non è valido");
                valido = false;
            }
            if(id < 0) {
                out5.setText("L'ID utente deve essere un intero positivo");
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
                    out5.setText("Un operatore con ID " + id + " è gia registrato");
            } catch(RemoteException ex) {
                System.err.println("Errore RMI: impossibile registrare un nuovo operatore");
                ex.printStackTrace();
                System.exit(1);
            }

        } else
            ResetClient.spegniClient(this);
    }//GEN-LAST:event_regActionPerformed

    private boolean passwordValida(String password) {
        if(password == null) {
            out6.setText("Inserire una password valida");
            return false;
        }
        if(!ValidatorePassword.rispettaLunghezzaMinima(password)) {
            out6.setText("La password deve contenere un minimo di " + ValidatorePassword.LUNGHEZZA_MINIMA + " caratteri");
            return false;
        }
        if(!ValidatorePassword.contieneCifra(password)) {
            out6.setText("La password deve contenere almeno una cifra");
            return false;
        }
        if(!ValidatorePassword.contieneLetteraMinuscola(password)) {
            out6.setText("La password deve contenere almeno una lettera minuscola");
            return false;
        }
        if(!ValidatorePassword.contieneLetteraMaiuscola(password)) {
            out6.setText("La password deve contenere almeno una lettera maiuscola");
            return false;
        }
        if(!ValidatorePassword.contieneCarattereSpeciale(password)) {
            out6.setText("La password deve contenere almeno un carattere speciale:");
            for(Character c : ValidatorePassword.caratteriSpecialiAmmessi)
                out6.setText(out6.getText() + " " + c.toString() + ";");
            return false;
        }
        return true;
    }

    /**
     * Metodo che controlla se la email inserita durante la registrazione è valida
     * @param email email dell'operatore
     * @return valore booleano, true se la email è valida, false altrimenti
     */
    private boolean emailValida(String email) {
        String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (email == null) {
            out4.setText("Inserire una email valida");
            return false;
        }
        if (!Pattern.compile(REGEX_EMAIL).matcher(email).matches()) {
            out4.setText("La stringa inserita non corrisponde ad una email valida");
            return false;
        }
        return true;
    }

    /**
     * Metodo che controlla se il codice fiscale è valido
     * @param codiceFiscale codice fiscale da controllare
     * @return valore booleano, true se il codice fiscale è valido, false altrimenti
     */
    private boolean codiceFiscaleValido(String codiceFiscale){
        String REGEX_CODICEFISCALE = "/^(?:[A-Z][AEIOU][AEIOUX]|[AEIOU]X{2}|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$/i";
        int LUNGHEZZA_CF = 16;

        if (codiceFiscale == null) {
            out3.setText("Inserire un CF valido");
            return false;
        }
        if (codiceFiscale.length() != LUNGHEZZA_CF) {
            out3.setText("La stringa inserita deve contenere " + LUNGHEZZA_CF + " caratteri");
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
            return false;

        return true;
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrazione().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField cfReg;
    private javax.swing.JTextField cognomeReg;
    private javax.swing.JTextField idReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mailReg;
    private javax.swing.JTextField nomeReg;
    private javax.swing.JLabel out1;
    private javax.swing.JLabel out2;
    private javax.swing.JLabel out3;
    private javax.swing.JLabel out4;
    private javax.swing.JLabel out5;
    private javax.swing.JLabel out6;
    private javax.swing.JTextField passReg;
    private javax.swing.JButton reg;
    // End of variables declaration//GEN-END:variables
}
