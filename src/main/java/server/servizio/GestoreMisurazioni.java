package server.servizio;

import commons.oggetti.Misurazione;
import commons.servizio.GestioneMisurazioni;
import server.database.dao.MisurazioniDAO;
import server.database.servizio.ImplMisurazioniDAO;

import java.rmi.RemoteException;

/**
 * Classe che utilizza una struttura dati di tipo Misurazione per gestire,
 * per organizzare e salvare in un file tutti i parametri inseriti dall'utente
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class GestoreMisurazioni implements GestioneMisurazioni {
    private MisurazioniDAO misurazioniDAO ;

    public GestoreMisurazioni() {
        misurazioniDAO = new ImplMisurazioniDAO();
    }

    @Override
    public void inserisciNuovaMisurazione(Misurazione nuovaMisurazione) throws RemoteException {
        misurazioniDAO.inserisciNuovaMisurazione(nuovaMisurazione);
    }

    @Override
    public Misurazione[] ottieniMisurazioniSuPuntoInteresse(int idPuntoInteresse) throws RemoteException {
        return misurazioniDAO.ottieniMisurazioniPuntoInteresse(idPuntoInteresse);
    }

}
