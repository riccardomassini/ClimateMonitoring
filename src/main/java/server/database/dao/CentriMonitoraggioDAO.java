package server.database.dao;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;

public interface CentriMonitoraggioDAO {
    void inserisciCentroMonitoraggio(CentroMonitoraggio nuovoCentro);
    void inserisciPuntiInteresseMonitoratiDaCentro(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse);
    PuntoInteresse[] ottieniPuntiInteresseMonitoratiDaCentro(String nomeCentro);
    void aggiornaCentroMonitoraggioAssociatoOperatore(int username, String nomeCentro);
    //CentroMonitoraggio otteniCentroMonitoraggioAssociatoOperatore(int username);
}
