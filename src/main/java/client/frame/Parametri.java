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
import commons.oggetti.*;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;

import commons.oggetti.misurazioni.CategorieParametriClimatici;
import commons.oggetti.misurazioni.Misurazione;
import commons.oggetti.misurazioni.PunteggioParametroClimatico;
import commons.oggetti.misurazioni.ValutazioneParametro;
import commons.servizio.GestioneMisurazioni;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 * La classe {@code Parametri} rappresenta il frame per la gestione dei parametri climatici dell'applicazione.
 * <p>Permette all'operatore di inserire e gestire misurazioni climatiche per un punto di interesse specifico.</p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public class Parametri extends javax.swing.JFrame {

    /** Oggetto per la gestione delle misurazioni tramite RMI */
    GestioneMisurazioni gestioneMisurazioni;

    /** Operatore passato per autenticazione e altre operazioni */
    Operatore operatorePassato;

    /** Nome del centro passato per la registrazione delle misurazioni */
    String nomeCentroPassato;

    /** Punto di interesse passato per la registrazione delle misurazioni */
    PuntoInteresse puntoInteressePassato;

    /** Valore di default per i commenti vuoti */
    private static final String FORMAT_COMMENTO_VUOTO = "/";

    /**
     * Costruttore predefinito che inizializza la finestra dei parametri.
     * <p>Non imposta alcun dato specifico.</p>
     */
    public Parametri(){
        initComponents();
    }

    /**
     * Costruttore che inizializza la finestra dei parametri con dati specifici.
     * <p>Imposta l'immagine di sfondo, aggiunge un listener per la chiusura della finestra e imposta la finestra come non ridimensionabile.</p>
     * <p>Configura i modelli dei combo box per le categorie di parametri climatici.</p>
     *
     * @param id ID dell'operatore
     * @param pass Password dell'operatore
     * @param nomeCentro Nome del centro per la registrazione delle misurazioni
     * @param paese Punto di interesse per la registrazione delle misurazioni
     */
    public Parametri(int id, String pass, String nomeCentro, PuntoInteresse paese){
        initComponents();
        setBackgroundImage("image/sfondo.jpg");
        addWindowListener(new Chiusura());
        this.setResizable(false);
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
        ventoReg = new javax.swing.JComboBox<>();
        umReg = new javax.swing.JComboBox<>();
        presReg = new javax.swing.JComboBox<>();
        teReg = new javax.swing.JComboBox<>();
        precReg = new javax.swing.JComboBox<>();
        altReg = new javax.swing.JComboBox<>();
        massaReg = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

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

        getContentPane().add(ventoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 65, -1, -1));

        getContentPane().add(umReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 93, -1, -1));

        getContentPane().add(presReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 121, -1, -1));

        getContentPane().add(teReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 149, -1, -1));

        getContentPane().add(precReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 177, -1, -1));

        getContentPane().add(altReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 205, -1, -1));

        getContentPane().add(massaReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 233, -1, -1));

        back.setText("Indietro");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));
        getContentPane().add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 370, 23));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 360));

        pack();
    }

    /**
     * Gestisce l'evento di azione del pulsante {@code inserisciParam}.
     * <p>Estrae i valori dai campi di input e li inserisce come una nuova misurazione tramite RMI.</p>
     * <p>Verifica la validità dei commenti e dei punteggi e gestisce eventuali errori di inserimento.</p>
     *
     * @param evt l'evento di azione generato dal pulsante {@code inserisciParam}.
     */
    private void inserisciParamActionPerformed(java.awt.event.ActionEvent evt) {
        gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
        if(gestioneMisurazioni != null){
        
            Misurazione nuovaMisurazione = new Misurazione();
            ValutazioneParametro valutazioneTemp = null;
            int categorieValutate = CategorieParametriClimatici.values().length;

            try {
                valutazioneTemp = valutazioneValida(estraiNumero((String) ventoReg.getSelectedItem()), ventoRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.VENTO, valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.VENTO)) ? categorieValutate - 1 : categorieValutate;

                valutazioneTemp = valutazioneValida(estraiNumero((String) teReg.getSelectedItem()), teRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.TEMPERATURA, valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.TEMPERATURA)) ? categorieValutate - 1 : categorieValutate;

                valutazioneTemp = valutazioneValida(estraiNumero((String) precReg.getSelectedItem()), precRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.PRECIPITAZIONI, valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.PRECIPITAZIONI)) ? categorieValutate - 1 : categorieValutate;

                valutazioneTemp = valutazioneValida(estraiNumero((String) presReg.getSelectedItem()), presRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.PRESSIONE,valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.PRESSIONE)) ? categorieValutate - 1 : categorieValutate;

                valutazioneTemp = valutazioneValida(estraiNumero((String) umReg.getSelectedItem()), umRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.UMIDITA, valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.UMIDITA)) ? categorieValutate - 1 : categorieValutate;

                valutazioneTemp = valutazioneValida(estraiNumero((String) altReg.getSelectedItem()), altRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.ALTITUDINE_GHIACCIAI, valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.ALTITUDINE_GHIACCIAI)) ? categorieValutate - 1 : categorieValutate;

                valutazioneTemp = valutazioneValida(estraiNumero((String) massaReg.getSelectedItem()), massaRegN.getText());
                valutazioneTemp.setCommento(formatCommento(valutazioneTemp.getCommento()));
                nuovaMisurazione.setParametroConCategoria(CategorieParametriClimatici.MASSA_GHIACCIAI, valutazioneTemp);
                categorieValutate = valutazioneNulla(nuovaMisurazione.getValutazioneParametroConCategoria(CategorieParametriClimatici.MASSA_GHIACCIAI)) ? categorieValutate - 1 : categorieValutate;

                if(categorieValutate == 0){
                    out.setText("Deve essere valutata almeno una categoria di parametri climatici");
                    return;
                }

            } catch(IllegalArgumentException ex) {
                out.setText("Impossibile inserire commenti per categorie con valutazione nulla");
                return;
            }


            for(CategorieParametriClimatici categoria : CategorieParametriClimatici.values())
                if(!ValutazioneParametro.lunghezzaCommentoValida(nuovaMisurazione.getCommentoParametroConCategoria(categoria))) {
                    out.setText("Lunghezza commento per " + categoria.name() + " non valida");
                    return;
                }

            nuovaMisurazione.setTimestampMisurazione(new Timestamp(new Date().getTime()));
            nuovaMisurazione.setIdPuntoInteresse(puntoInteressePassato.getIdPuntoInteresse());
            nuovaMisurazione.setNomeCentro(nomeCentroPassato);

            try {
                gestioneMisurazioni.inserisciNuovaMisurazione(nuovaMisurazione);
            } catch(RemoteException ex) {
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
    }

    /**
     * Gestisce l'azione del pulsante "Indietro".
     * <p>
     * Quando l'utente clicca sul pulsante "Indietro", questo metodo crea una nuova istanza di {@link AreaOperatore},
     * imposta la posizione della nuova finestra sulla stessa posizione della finestra corrente,
     * chiude la finestra corrente e rende visibile la nuova finestra di AreaOperatore.
     * </p>
     * <p>
     * Se l'oggetto di gestioneMisurazioni è nullo, il metodo chiama {@link ResetClient#spegniClient}
     * per spegnere il client.
     * </p>
     *
     * @param evt l'evento di azione generato dal clic sul pulsante
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        gestioneMisurazioni = ClientRMI.ottieniClientRMI().ottieniStubGestioneMisurazioni();
        if(gestioneMisurazioni != null){
            AreaOperatore ao = new AreaOperatore(operatorePassato.getUsername(), operatorePassato.getPassword());
            ao.setLocation(this.getX(), this.getY());
            this.dispose();
            ao.setVisible(true);
        }else{
            ResetClient.spegniClient(this);
        }
    }

    /**
     * Formatta il commento per una valutazione parametrica.
     * <p>Se il commento è vuoto, restituisce un valore di default; altrimenti, restituisce il commento fornito.</p>
     *
     * @param commento Il commento da formattare.
     * @return Il commento formattato o il valore di default se il commento è vuoto.
     */
    private String formatCommento(String commento) {
        return commento.isEmpty() ? FORMAT_COMMENTO_VUOTO : commento;
    }

    /**
     * Verifica se una valutazione ha un punteggio nullo.
     * <p>Un punteggio nullo è considerato uguale al punteggio definito come nullo nella classe {@code PunteggioParametroClimatico}.</p>
     *
     * @param punteggio Il punteggio da verificare.
     * @return {@code true} se il punteggio è nullo, {@code false} altrimenti.
     */
    private boolean valutazioneNulla(int punteggio) {
        return punteggio == PunteggioParametroClimatico.NULLO.getPunteggio();
    }

    /**
     * Crea un'istanza di {@code ValutazioneParametro} se il punteggio e il commento sono validi.
     * <p>Solleva un'eccezione {@code IllegalArgumentException} se il punteggio è nullo e il commento non è vuoto.</p>
     *
     * @param punteggio Il punteggio della valutazione.
     * @param commento Il commento associato alla valutazione.
     * @return Una nuova istanza di {@code ValutazioneParametro}.
     * @throws IllegalArgumentException Se il punteggio è nullo e il commento non è vuoto.
     */
    private ValutazioneParametro valutazioneValida(int punteggio, String commento) throws IllegalArgumentException {
        if(valutazioneNulla(punteggio) && !commento.isEmpty())
            throw new IllegalArgumentException("Impossibile inserire un commento in una valutazione con punteggio nullo");
        return new ValutazioneParametro(punteggio, commento);
    }

    /**
     * Estrae il numero intero dal valore di una stringa formattata.
     * <p>La stringa è suddivisa utilizzando " - " come separatore. Il numero è la parte prima del separatore.</p>
     *
     * @param valore La stringa che contiene il numero e la descrizione.
     * @return Il numero intero estratto dalla stringa.
     */
    private int estraiNumero(String valore) {
        String[] parti = valore.split(" - ");
        return Integer.parseInt(parti[0]);
    }

    /**
     * Metodo principale che avvia il frame {@code Parametri}.
     * <p>Crea e visualizza l'istanza di {@code Parametri}.</p>
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
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parametri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parametri().setVisible(true);
            }
        });
    }

    /** ComboBox per la selezione del parametro altitudine ghiacciai. */
    private javax.swing.JComboBox<String> altReg;

    /** Campo di testo per l'inserimento del commento sull'altitudine ghiacciai. */
    private javax.swing.JTextField altRegN;

    /** Pulsante per tornare alla schermata precedente. */
    private javax.swing.JButton back;

    /** Gruppo di pulsanti per la gestione di opzioni. */
    private javax.swing.ButtonGroup buttonGroup1;

    /** Gruppo di pulsanti per la gestione di opzioni. */
    private javax.swing.ButtonGroup buttonGroup2;

    /** Pulsante per inserire i parametri climatici. */
    private javax.swing.JButton inserisciParam;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel1;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel10;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel11;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel12;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel13;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel14;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel15;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel2;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel3;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel4;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel5;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel6;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel7;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel8;

    /** Etichetta per la visualizzazione del testo o delle informazioni. */
    private javax.swing.JLabel jLabel9;

    /** ComboBox per la selezione del parametro massa ghiacciai. */
    private javax.swing.JComboBox<String> massaReg;

    /** Campo di testo per l'inserimento del commento sulla massa ghiacciai. */
    private javax.swing.JTextField massaRegN;

    /** Etichetta per la visualizzazione di messaggi di output o errori. */
    private javax.swing.JLabel out;

    /** ComboBox per la selezione del parametro precipitazioni. */
    private javax.swing.JComboBox<String> precReg;

    /** Campo di testo per l'inserimento del commento sulle precipitazioni. */
    private javax.swing.JTextField precRegN;

    /** ComboBox per la selezione del parametro pressione. */
    private javax.swing.JComboBox<String> presReg;

    /** Campo di testo per l'inserimento del commento sulla pressione. */
    private javax.swing.JTextField presRegN;

    /** Etichetta per lo sfondo dell'interfaccia. */
    private javax.swing.JLabel sfondo;

    /** ComboBox per la selezione del parametro temperatura. */
    private javax.swing.JComboBox<String> teReg;

    /** Campo di testo per l'inserimento del commento sulla temperatura. */
    private javax.swing.JTextField teRegN;

    /** ComboBox per la selezione del parametro umidità. */
    private javax.swing.JComboBox<String> umReg;

    /** Campo di testo per l'inserimento del commento sull'umidità. */
    private javax.swing.JTextField umRegN;

    /** ComboBox per la selezione del parametro vento. */
    private javax.swing.JComboBox<String> ventoReg;

    /** Campo di testo per l'inserimento del commento sul vento. */
    private javax.swing.JTextField ventoRegN;
}