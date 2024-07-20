 package server.servizio.ricercapoi;

import commons.oggetti.PuntoInteresse;
import commons.servizio.RicercaPuntiInteresse;
import server.database.servizio.ImplPuntiInteresseDAO;
import server.database.dao.PuntiInteresseDAO;

import java.rmi.RemoteException;
import java.util.TreeMap;

 /**
 * Classe che utilizza una struttura dati per gestire,
 * per organizzare e salvare in un file tutti i paesi del mondo
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class RepositoryPuntiInteresse implements RicercaPuntiInteresse {
    private final PuntiInteresseDAO puntiInteresseDAO;
    private static final int PUNTI_INTERESSE_MAX_RICERCA_COORDINATE = 10;

    public RepositoryPuntiInteresse() {
        this.puntiInteresseDAO = new ImplPuntiInteresseDAO();
    }

    @Override
    public PuntoInteresse[] ottieniElencoPuntiInteresse() throws RemoteException {
        return puntiInteresseDAO.ottieniElencoPuntiInteresse();
    }

    @Override
    public PuntoInteresse[] ricercaPerNome(String nome) throws RemoteException {
        return puntiInteresseDAO.ottieniPuntiInteressePerNome(nome);
    }

    @Override
    public PuntoInteresse[] ricercaPerNazione(String codiceNazione) throws RemoteException {
        return puntiInteresseDAO.ottieniPuntiInteressePerCodiceNazione(codiceNazione);
    }

    @Override
    public PuntoInteresse[] ricercaPerCoordinate(double latitudine, double longitudine) throws RemoteException {
        PuntoInteresse[] elencoPuntiInteresse = puntiInteresseDAO.ottieniElencoPuntiInteresse();
        TreeMap<Double, PuntoInteresse> distanze = new TreeMap<>();

        for(PuntoInteresse puntoInteresse : elencoPuntiInteresse)
            distanze.put(CalcoloHaversine.haversine(latitudine, longitudine, puntoInteresse.getLatitudine(), puntoInteresse.getLongitudine()),
                    puntoInteresse);

        elencoPuntiInteresse = new PuntoInteresse[PUNTI_INTERESSE_MAX_RICERCA_COORDINATE];
        for(int i = 0; i < PUNTI_INTERESSE_MAX_RICERCA_COORDINATE; i++)
            elencoPuntiInteresse[i] = distanze.pollFirstEntry().getValue();

        return elencoPuntiInteresse;
    }

     @Override
     public PuntoInteresse[] ricercaPerNomeENazione(String nomePuntoInteresse, String codiceNazione) throws RemoteException {
         return puntiInteresseDAO.ottieniPuntiInteressePerNomeECodiceNazione(nomePuntoInteresse, codiceNazione);
     }

 }
