package server.database.dao;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import java.util.ArrayList;

public interface CentriMonitoraggioDAO {
    void inserisciCentroMonitoraggio(CentroMonitoraggio nuovoCentro);
    void inserisciPuntiInteresseMonitoratiDaCentro(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse);
    ArrayList<PuntoInteresse> ottieniPuntiInteresseMonitoratiDaCentro(String nomeCentro);
    void aggiornaCentroMonitoraggioAssociatoOperatore(int username, String nomeCentro);
    PuntoInteresse ottieniPaeseDaCentro(String nomePaese, String codice, String nomeCentro);
    ArrayList<CentroMonitoraggio> leggiTuttiCentri();
    //CentroMonitoraggio otteniCentroMonitoraggioAssociatoOperatore(int username);
}
