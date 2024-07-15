package commons.servizio;

import commons.oggetti.CentroMonitoraggio;
import commons.oggetti.PuntoInteresse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestioneCentriMonitoraggio extends Remote {
    void registraCentroMonitoraggio(CentroMonitoraggio centro, ArrayList<PuntoInteresse> aree) throws RemoteException;
    PuntoInteresse trovaAreaAssociata(String nomeP, String code, String centroOp) throws RemoteException;
    PuntoInteresse ricercaPuntiInteresseAssociati(String scelta1, String scelta2) throws RemoteException;
}
