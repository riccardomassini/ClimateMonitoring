/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.frame;

import client.clientrmi.ClientRMI;
import client.clientrmi.ResetClient;
import client.registraeventi.Chiusura;
import commons.oggetti.*;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;

import commons.oggetti.misurazioni.CategorieParametriClimatici;
import commons.oggetti.misurazioni.Misurazione;
import commons.oggetti.misurazioni.PunteggioParametroClimatico;
import commons.oggetti.misurazioni.ValutazioneParametro;
import commons.servizio.GestioneMisurazioni;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class Parametri extends javax.swing.JFrame {
    GestioneMisurazioni gestioneMisurazioni;
    Operatore operatorePassato;
    String nomeCentroPassato;
    PuntoInteresse puntoInteressePassato;
    
    
    public Parametri(){
        initComponents();
    }
    
    public Parametri(int id, String pass, String nomeCentro, PuntoInteresse paese){
        initComponents();
        addWindowListener(new Chiusura());
        operatorePassato = new Operatore(id, pass);
        this.nomeCentroPassato = nomeCentro;
        this.puntoInteressePassato = paese;
        
        ArrayList<String> punti = new ArrayList<>();

        for (PunteggioParametroClimatico parametro : PunteggioParametroClimatico.values()) {
            punti.add(String.valueOf(parametro.getPunteggio()) + " - " + parametro.getDescrizione());
        }

        String[] puntiArray = punti.toArray(new String[0]);
        DefaultComboBoxModel<String> modelVento = new DefaultComboBoxModel<>(puntiArray);
        DefaultComboBoxModel<String> modelUm = new DefaultComboBoxModel<>(puntiArray);
        DefaultComboBoxModel<String> modelPres = new DefaultComboBoxModel<>(puntiArray);
        DefaultComboBoxModel<String> modelTe = new DefaultComboBoxModel<>(puntiArray);
        DefaultComboBoxModel<String> modelPrec = new DefaultComboBoxModel<>(puntiArray);
        DefaultComboBoxModel<String> modelAlt = new DefaultComboBoxModel<>(puntiArray);
        DefaultComboBoxModel<String> modelMassa = new DefaultComboBoxModel<>(puntiArray);

        ventoReg.setModel(modelVento);
        umReg.setModel(modelUm);
        presReg.setModel(modelPres);
        teReg.setModel(modelTe);
        precReg.setModel(modelPrec);
        altReg.setModel(modelAlt);
        massaReg.setModel(modelMassa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        precRegN = new javax.swing.JTextField();
        altRegN = new javax.swing.JTextField();
        massaRegN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ventoRegN = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        umRegN = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        presRegN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        teRegN = new javax.swing.JTextField();
        inserisciParam = new javax.swing.JButton();
        back = new javax.swing.JButton();
        ventoReg = new javax.swing.JComboBox<>();
        umReg = new javax.swing.JComboBox<>();
        presReg = new javax.swing.JComboBox<>();
        teReg = new javax.swing.JComboBox<>();
        precReg = new javax.swing.JComboBox<>();
        altReg = new javax.swing.JComboBox<>();
        massaReg = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("PARAMETRI CLIMATICI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 15, -1, 32));

        jLabel2.setText("Vento");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, 71, 22));

        jLabel3.setText("Umidità");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 93, 71, 22));

        jLabel4.setText("Pressione");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 121, 71, 22));

        jLabel5.setText("Temperatura");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 149, 71, 22));

        jLabel6.setText("Precipitazioni");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 177, -1, 22));

        jLabel7.setText("Altitudine");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 205, 71, 22));

        jLabel8.setText("Massa");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 233, 71, 22));
        getContentPane().add(precRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 177, 71, -1));
        getContentPane().add(altRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 205, 71, -1));
        getContentPane().add(massaRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 233, 71, -1));

        jLabel9.setText("Note");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 68, -1, -1));

        jLabel10.setText("Note");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 96, -1, -1));

        jLabel11.setText("Note");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 124, -1, -1));

        jLabel12.setText("Note");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 152, -1, -1));
        getContentPane().add(ventoRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 65, 71, -1));

        jLabel13.setText("Note");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 180, -1, -1));
        getContentPane().add(umRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 93, 71, -1));

        jLabel14.setText("Note");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 208, -1, -1));
        getContentPane().add(presRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 121, 71, -1));

        jLabel15.setText("Note");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 236, -1, -1));
        getContentPane().add(teRegN, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 149, 71, -1));

        inserisciParam.setText("Inserisci");
        inserisciParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserisciParamActionPerformed(evt);
            }
        });
        getContentPane().add(inserisciParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 267, -1, -1));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 295, -1, -1));

        ventoReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventoRegActionPerformed(evt);
            }
        });
        getContentPane().add(ventoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 65, -1, -1));

        getContentPane().add(umReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 93, -1, -1));

        getContentPane().add(presReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 121, -1, -1));

        getContentPane().add(teReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 149, -1, -1));

        getContentPane().add(precReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 177, -1, -1));

        getContentPane().add(altReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 205, -1, -1));

        getContentPane().add(massaReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 233, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 420, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
        if(gestioneMisurazioni != null){
            AreaOperatore ao = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
            ao.setLocation(this.getX(), this.getY());
            this.dispose();
            ao.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }//GEN-LAST:event_backActionPerformed

    private void inserisciParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserisciParamActionPerformed
        gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
        if(gestioneMisurazioni != null){
        
            Misurazione nuovaMisurazione = new Misurazione();
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.VENTO, new ValutazioneParametro(estraiNumero((String) ventoReg.getSelectedItem()), formatCommento(ventoRegN.getText())));
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.TEMPERATURA, new ValutazioneParametro(estraiNumero((String)   teReg.getSelectedItem()), formatCommento(teRegN.getText())));
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.PRECIPITAZIONI, new ValutazioneParametro(estraiNumero((String) precReg.getSelectedItem()), formatCommento(precRegN.getText())));
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.PRESSIONE,new ValutazioneParametro(estraiNumero((String) presReg.getSelectedItem()), formatCommento(presRegN.getText())));
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.UMIDITA, new ValutazioneParametro(estraiNumero((String) umReg.getSelectedItem()), formatCommento(umRegN.getText())));
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.ALTITUDINE_GHIACCIAI, new ValutazioneParametro(estraiNumero((String) altReg.getSelectedItem()), formatCommento(altRegN.getText())));
            nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.MASSA_GHIACCIAI, new ValutazioneParametro(estraiNumero((String) massaReg.getSelectedItem()), formatCommento(massaRegN.getText())));

            for(CategorieParametriClimatici categoria : CategorieParametriClimatici.values())
                if(!ValutazioneParametro.lunghezzaCommentoValida(nuovaMisurazione.getCommentoParametroConCategoria(categoria))) {
                    System.err.println("Lunghezza commento per " + categoria.name() + " non valida");
                    return;
                }

            nuovaMisurazione.setTimestampMisurazione(new Timestamp(new Date().getTime()));
            nuovaMisurazione.setIdPuntoInteresse(puntoInteressePassato.getIdPuntoInteresse());
            nuovaMisurazione.setNomeCentro(nomeCentroPassato);

            try {
                gestioneMisurazioni.inserisciNuovaMisurazione(nuovaMisurazione);
            } catch(RemoteException ex) {
                System.err.println("Errore RMI: registrazione di una nuova misurazione fallita");
                ex.printStackTrace();
                System.exit(1);
            }

            AreaOperatore ao = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
            ao.setLocation(this.getX(), this.getY());
            this.dispose();
            ao.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
            
    }//GEN-LAST:event_inserisciParamActionPerformed

    private void ventoRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventoRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ventoRegActionPerformed

    private String formatCommento(String commento) {
        return commento.isEmpty() ? "/" : commento;
    }
    
    private int estraiNumero(String valore) {
        String[] parti = valore.split(" - ");
        return Integer.parseInt(parti[0]);
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
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parametri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> altReg;
    private javax.swing.JTextField altRegN;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton inserisciParam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> massaReg;
    private javax.swing.JTextField massaRegN;
    private javax.swing.JComboBox<String> precReg;
    private javax.swing.JTextField precRegN;
    private javax.swing.JComboBox<String> presReg;
    private javax.swing.JTextField presRegN;
    private javax.swing.JComboBox<String> teReg;
    private javax.swing.JTextField teRegN;
    private javax.swing.JComboBox<String> umReg;
    private javax.swing.JTextField umRegN;
    private javax.swing.JComboBox<String> ventoReg;
    private javax.swing.JTextField ventoRegN;
    // End of variables declaration//GEN-END:variables
}
