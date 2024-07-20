package server.servizio.centrimonitoraggio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import commons.servizio.GestioneCentriMonitoraggio;
import server.database.dao.CentriMonitoraggioDAO;
import server.database.servizio.ImplCentriMonitoraggioDAO;

import java.rmi.RemoteException;

/**
 * Classe che utilizza una struttura dati di tipo CentroMonitoraggio per gestire,
 * per organizzare e salvare in un file tutti i parametri inseriti dall'utente
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class GestoreCentriMonitoraggio implements GestioneCentriMonitoraggio {
    private CentriMonitoraggioDAO centriMonitoraggioDAO;

    public GestoreCentriMonitoraggio() {
        this.centriMonitoraggioDAO = new ImplCentriMonitoraggioDAO();
    }

    @Override
    public void registraCentroMonitoraggio(CentroMonitoraggio nuovoCentro) throws RemoteException {
        centriMonitoraggioDAO.inserisciCentroMonitoraggio(nuovoCentro);
    }

    @Override
    public void associaPuntiInteresseCentroMonitoraggio(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse) throws RemoteException {
        centriMonitoraggioDAO.inserisciPuntiInteresseMonitoratiDaCentro(nomeCentro, elencoPuntiInteresse);
    }

    @Override
    public PuntoInteresse[] ottieniAreeAssociate(String nomeCentro) throws RemoteException{
        return centriMonitoraggioDAO.ottieniPuntiInteresseMonitoratiDaCentro(nomeCentro);
    }

    @Override
    public void associaCentroMonitoraggioOperatore(int usernameOperatore, String nomeNuovoCentro) throws RemoteException{
        centriMonitoraggioDAO.aggiornaCentroMonitoraggioAssociatoOperatore(usernameOperatore, nomeNuovoCentro);
    }

    /*
    @Override
    public CentroMonitoraggio ottieniCentroMonitoraggioAssociatoOperatore(int usernameOperatore) throws RemoteException {
        return centriMonitoraggioDAO.otteniCentroMonitoraggioAssociatoOperatore(usernameOperatore);
    }*/


}
