package server.servizio.centrimonitoraggio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;
import commons.servizio.GestioneCentriMonitoraggio;
import server.database.dao.CentriMonitoraggioDAO;
import server.database.servizio.ImplCentriMonitoraggioDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
    public synchronized void registraCentroMonitoraggio(CentroMonitoraggio nuovoCentro) throws RemoteException {
        centriMonitoraggioDAO.inserisciCentroMonitoraggio(nuovoCentro);
    }

    @Override
    public synchronized void associaPuntiInteresseCentroMonitoraggio(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse) throws RemoteException {
        centriMonitoraggioDAO.inserisciPuntiInteresseMonitoratiDaCentro(nomeCentro, elencoPuntiInteresse);
    }

    @Override
    public synchronized ArrayList<PuntoInteresse> ottieniAreeAssociate(String nomeCentro) throws RemoteException{
        return centriMonitoraggioDAO.ottieniPuntiInteresseMonitoratiDaCentro(nomeCentro);
    }

    @Override
    public synchronized void associaCentroMonitoraggioOperatore(int usernameOperatore, String nomeNuovoCentro) throws RemoteException{
        centriMonitoraggioDAO.aggiornaCentroMonitoraggioAssociatoOperatore(usernameOperatore, nomeNuovoCentro);
    }
    
    @Override
    public synchronized PuntoInteresse ottieniPaese(String nomePaese, String codice, String nomeCentro) throws RemoteException{
        return centriMonitoraggioDAO.ottieniPaeseDaCentro(nomePaese, codice, nomeCentro);
    }
    
    @Override
    public synchronized ArrayList<CentroMonitoraggio> leggiCentri() throws RemoteException{
        return centriMonitoraggioDAO.leggiTuttiCentri();
    }

    /*
    @Override
    public CentroMonitoraggio ottieniCentroMonitoraggioAssociatoOperatore(int usernameOperatore) throws RemoteException {
        return centriMonitoraggioDAO.otteniCentroMonitoraggioAssociatoOperatore(usernameOperatore);
    }*/


}
