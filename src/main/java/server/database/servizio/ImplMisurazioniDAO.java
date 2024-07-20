package server.database.servizio;

import commons.oggetti.Misurazione;
import server.database.ConnettoreDatabase;
import server.database.dao.MisurazioniDAO;

import java.sql.*;
import java.util.ArrayList;

import static server.database.DizionarioDatabase.*;

public class ImplMisurazioniDAO implements MisurazioniDAO {
    private static final String QUERY_INSERIMENTO_NUOVA_MISURAZIONE = "INSERT INTO " +  MISURAZIONI_RELAZIONE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_ELENCO_MISURAZIONI_PUNTO_INTERESSE = "SELECT * FROM " + MISURAZIONI_RELAZIONE + " NATURAL JOIN " + PUNTIINTERESSEASSOCIATI_RELAZIONE + " WHERE " + MISURAZIONI_ATTRIBUTO_IDPUNTOINTERESSE + " = ?";

    @Override
    public void inserisciNuovaMisurazione(Misurazione nuovaMisurazione) {
        try (
                Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
                PreparedStatement stmt = connessione.prepareStatement(QUERY_INSERIMENTO_NUOVA_MISURAZIONE)
        ) {
            stmt.setInt(1, nuovaMisurazione.getIdPuntoInteresse());
            stmt.setString(2, nuovaMisurazione.getNomeCentro());
            stmt.setTimestamp(3, nuovaMisurazione.getTimestampMisurazione());
            stmt.setInt(4, Integer.parseInt(nuovaMisurazione.getValutazioneVento().toString()));
            stmt.setString(5, nuovaMisurazione.getCommentoVento());
            stmt.setInt(6, Integer.parseInt(nuovaMisurazione.getValutazioneUmidita().toString()));
            stmt.setString(7, nuovaMisurazione.getCommentoUmidita());
            stmt.setInt(8, Integer.parseInt(nuovaMisurazione.getValutazionePressione().toString()));
            stmt.setString(9, nuovaMisurazione.getCommentoPressione());
            stmt.setInt(10, Integer.parseInt(nuovaMisurazione.getValutazioneTemperatura().toString()));
            stmt.setString(11, nuovaMisurazione.getCommentoTemperatura());
            stmt.setInt(12, Integer.parseInt(nuovaMisurazione.getValutazionePrecipitazioni().toString()));
            stmt.setString(13, nuovaMisurazione.getCommentoPrecipitazioni());
            stmt.setInt(14, Integer.parseInt(nuovaMisurazione.getValutazioneAltitudineGhiacciai().toString()));
            stmt.setString(15, nuovaMisurazione.getCommentoAltitudineGhiacciai());
            stmt.setInt(16, Integer.parseInt(nuovaMisurazione.getValutazioneMassaGhiacciai().toString()));
            stmt.setString(17, nuovaMisurazione.getCommentoMassaGhiacciai());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Impossibile inserire una nuova misurazione");
            e.printStackTrace();
        }
    }

    @Override
    public Misurazione[] ottieniMisurazioniPuntoInteresse(int idPuntoInteresse) {
        ArrayList<Misurazione> elencoMisurazioni = new ArrayList<>();
        Misurazione misurazione = null;

        try (Connection connessione = ConnettoreDatabase.ottieniConnettore().ottieniConnessioneDatabase();
             PreparedStatement stmt = connessione.prepareStatement(QUERY_ELENCO_MISURAZIONI_PUNTO_INTERESSE);
        ) {
            stmt.setString(1, "" + idPuntoInteresse);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    misurazione = new Misurazione();
                    misurazione.setIdPuntoInteresse(idPuntoInteresse);
                    misurazione.setNomeCentro(rs.getString(MISURAZIONI_ATTRIBUTO_IDCENTROMONITORAGGIO));
                    misurazione.setTimestampMisurazione(rs.getTimestamp(MISURAZIONI_ATTRIBUTO_TIMESTAMP));
                    misurazione.setValutazioneVento(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_VENTO));
                    misurazione.setCommentoVento(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_VENTO));
                    misurazione.setValutazionePrecipitazioni(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRECIPITAZIONI));
                    misurazione.setCommentoPrecipitazioni(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_PRECIPITAZIONI));
                    misurazione.setValutazioneUmidita(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_UMIDITA));
                    misurazione.setCommentoUmidita(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_UMIDITA));
                    misurazione.setValutazionePressione(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRESSIONE));
                    misurazione.setCommentoPressione(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_PRESSIONE));
                    misurazione.setValutazioneTemperatura(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_TEMPERATURA));
                    misurazione.setCommentoTemperatura(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_TEMPERATURA));
                    misurazione.setValutazioneMassaGhiacciai(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_MASSAGHIACCIAI));
                    misurazione.setCommentoMassaGhiacciai(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_MASSAGHIACCIAI));
                    misurazione.setValutazioneAltitudineGhiacciai(rs.getInt(MISURAZIONI_ATTRIBUTO_VALUTAZIONE_ALTEZZAGHIACCIAI));
                    misurazione.setCommentoAltitudineGhiacciai(rs.getString(MISURAZIONI_ATTRIBUTO_COMMENTO_ALTEZZAGHIACCIAI));
                    elencoMisurazioni.add(misurazione);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Impossibile recuperare le misurazioni associate al punto di interesse fornito");
            ex.printStackTrace();
        }
        return elencoMisurazioni.toArray(new Misurazione[elencoMisurazioni.size()]);

    }


        /* TODO rivedere per calcolo media/moda
        ResultSet set = null;
        Connection connessione = null;

        //ArrayList<String> paesi = convertiPaese(paese);
        ArrayList<Misurazione> parametri = new ArrayList<>();

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

                    parametri.add(new Misurazione(paese.getIdPuntoInteresse(), nomeC, data, vento, noteV, umidita, noteU, pres, notePres, tempe, noteT, prec, notePrec, alt, noteA, massa, noteM));
                }

            }
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

        return parametri;ù

         */


}
