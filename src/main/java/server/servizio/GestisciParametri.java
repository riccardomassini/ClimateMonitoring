package server.servizio;

import commons.oggetti.PuntoInteresse;
import commons.oggetti.ParametriClimatici;
import server.database.ConnettoreDatabase;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che utilizza una struttura dati di tipo ParametriClimatici per gestire,
 * per organizzare e salvare in un file tutti i parametri inseriti dall'utente
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class GestisciParametri{
    
    /**
     * Vettore dove sono salvate le medie aritmetiche di ogni parametro
     */
    private double[] medie = new double[7];
    
    /**
     * Vettore dove sono salvate le mode di ogni parametro
     */
    private int[] moda = new int[7];
    
    //TODO rmi
    public void inserisciNuovaMisurazione(ParametriClimatici parametri){
        try {
            Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            
            String query = "INSERT INTO parametriClimatici " +
                    "(geonameid, centro, datainserimento, vento, " +
                    "ventonote, umidita, umiditanote, pressione, " +
                    "pressionenote, temperatura, temperaturanote, " +
                    "precipitazioni, precipitazioninote, altitudineghiacciai, " +
                    "altitudineghiacciainote, massaghiacciai, massaghiacciainote) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement esegui = connessione.prepareStatement(query);
            esegui.setInt(1, parametri.getGeonameid());
            esegui.setString(2, parametri.getNomeC());
            esegui.setTimestamp(3, parametri.getData());
            esegui.setInt(4, Integer.parseInt(parametri.getVento().toString()));
            esegui.setString(5, parametri.getNoteV());
            esegui.setInt(6, Integer.parseInt(parametri.getUmidita().toString()));
            esegui.setString(7, parametri.getNoteU());
            esegui.setInt(8, Integer.parseInt(parametri.getPressione().toString()));
            esegui.setString(9, parametri.getNotePres());
            esegui.setInt(10, Integer.parseInt(parametri.getTemperatura().toString()));
            esegui.setString(11, parametri.getNoteT());
            esegui.setInt(12, Integer.parseInt(parametri.getPrecipitazioni().toString()));
            esegui.setString(13, parametri.getNotePrec());
            esegui.setInt(14, Integer.parseInt(parametri.getAltitudine().toString()));
            esegui.setString(15, parametri.getNoteA());
            esegui.setInt(16, Integer.parseInt(parametri.getMassa().toString()));
            esegui.setString(17, parametri.getNoteM());
            esegui.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestisciParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*private ArrayList<String> convertiPaese(Paese paese){
        StringTokenizer token = null;
        ResultSet set = null;
        ArrayList<String> paesi = new ArrayList<>();
        
        try {   
            Connection connessione = ConnettoreDatabase.ottieniConnessioneDatabase();
            String query = "SELECT paese FROM parametriclimatici";
            PreparedStatement esegui = connessione.prepareStatement(query);
            set = esegui.executeQuery();
            
            while(set.next()){
                String area = set.getString("paese");
                token = new StringTokenizer(area, ",");
                
                while(token.hasMoreTokens()){
                    String asname = token.nextToken();
                    String cc = token.nextToken();
                    double lat = Double.parseDouble(token.nextToken());
                    double lon = Double.parseDouble(token.nextToken());
                    if(asname.equals(paese.getNomePuntoInteresseASCII()) && cc.equals(paese.getCodiceNazione()))
                        paesi.add(asname + "," + cc + "," +lat+ "," +lon);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestisciParametri.class.getNomePuntoInteresse()).log(Level.SEVERE, null, ex);
        }
        return paesi;
    }*/
    
    //TODO rmi
    public ArrayList<ParametriClimatici> ottieniMisurazioniSuPuntoInteresse(PuntoInteresse paese){
        ResultSet set = null;
        Connection connessione = null;
        
        //ArrayList<String> paesi = convertiPaese(paese);
        ArrayList<ParametriClimatici> parametri = new ArrayList<>();
        
        int somme[] = new int[7];
        int cont[][] = new int[7][7];
        int max[] = new int[7];
        
        
        for(int i=0; i<medie.length; i++){
            medie[i] = 0;
        }
        
        for(int i=0; i<moda.length; i++){
            moda[i] = 0;
        }
        
        try{
            connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
            String query = "SELECT * FROM parametriclimatici";
            PreparedStatement esegui = connessione.prepareStatement(query);
            set = esegui.executeQuery();

            while(set.next()){
                String nomeC = set.getString("centro");
                int geonameid = set.getInt("geonameid");
                Timestamp data = set.getTimestamp("datainserimento");
                int vento = set.getInt("vento");
                int umidita = set.getInt("umidita");
                int pres = set.getInt("pressione");
                int tempe = set.getInt("temperatura");
                int prec = set.getInt("precipitazioni");
                int alt = set.getInt("altitudineghiacciai");
                int massa = set.getInt("massaghiacciai");
                String noteV = set.getString("ventonote");
                String noteU = set.getString("umiditanote");
                String notePres = set.getString("pressionenote");
                String noteT = set.getString("temperaturanote");
                String notePrec = set.getString("precipitazioninote");
                String noteA = set.getString("altitudineghiacciainote");
                String noteM = set.getString("massaghiacciainote");
                
                
                if(paese.getIdPuntoInteresse() == geonameid){
                    cont[0][vento]++;
                    cont[1][umidita]++;
                    cont[2][pres]++;
                    cont[3][tempe]++;
                    cont[4][prec]++;
                    cont[5][alt]++;
                    cont[6][massa]++;

                    somme[0] = somme[0] + vento;
                    somme[1] = somme[1] + umidita;
                    somme[2] = somme[2] + pres;
                    somme[3] = somme[3] + tempe;
                    somme[4] = somme[4] + prec;
                    somme[5] = somme[5] + alt;
                    somme[6] = somme[6] + massa;

                    parametri.add(new ParametriClimatici(paese.getIdPuntoInteresse(), nomeC, data, vento, noteV, umidita, noteU, pres, notePres, tempe, noteT, prec, notePrec, alt, noteA, massa, noteM));
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestisciParametri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int posmax[] = new int[7];

        for(int i=0; i<cont.length; i++){
            for(int j=0; j<cont[i].length; j++){
                if(cont[i][j]>max[i]){
                    max[i] = cont[i][j];
                    posmax[i] = j;
                }
            }
            moda[i] = posmax[i];
        }
        
        double n = parametri.size();
        for(int i=0; i<medie.length; i++){
            medie[i] = somme[i]/n;
        }
        
        return parametri;
    }

    //TODO rmi
    public double[] ottieniMediaMisurazioni() {
        return medie;
    }

    //TODO Rmi
    public int[] ottieniModaMisurazioni() {
        return moda;
    }
}
