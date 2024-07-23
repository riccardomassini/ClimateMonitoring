package commons.servizio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestioneCentriMonitoraggio extends Remote {
    void registraCentroMonitoraggio(CentroMonitoraggio nuovoCentro) throws RemoteException;
    void associaPuntiInteresseCentroMonitoraggio(String nomeCentro, PuntoInteresse[] elencoPuntiInteresse) throws RemoteException;
    ArrayList<PuntoInteresse> ottieniAreeAssociate(String nomeCentro) throws RemoteException;
    void associaCentroMonitoraggioOperatore(int usernameOperatore, String nomeNuovoCentro) throws RemoteException;
    PuntoInteresse ottieniPaese(String nomePaese, String codice, String nomeCentro) throws RemoteException;
    ArrayList<CentroMonitoraggio> leggiCentri() throws RemoteException;
    //CentroMonitoraggio ottieniCentroMonitoraggioAssociatoOperatore(int usernameOperatore) throws RemoteException;
}
