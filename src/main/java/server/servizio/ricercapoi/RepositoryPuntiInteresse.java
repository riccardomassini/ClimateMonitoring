 package server.servizio.ricercapoi;

import commons.oggetti.PuntoInteresse;
import server.database.servizio.ImplPuntiInteresseDAO;
import server.database.dao.PuntiInteresseDAO;

import java.util.TreeMap;

 /**
 * Classe che utilizza una struttura dati per gestire,
 * per organizzare e salvare in un file tutti i paesi del mondo
 * @author Nome: Riccardo Massini   Matricola: 753291   Sede: CO
 * @version 1.0
 */
public class RepositoryPuntiInteresse  {
    private final PuntiInteresseDAO puntiInteresseDAO;
    private static final int PUNTI_INTERESSE_MAX_RICERCA_COORDINATE = 10;

    public RepositoryPuntiInteresse() {
        this.puntiInteresseDAO = new ImplPuntiInteresseDAO();
    }

    //TODO rmi
    public PuntoInteresse[] ottieniElencoPuntiInteresse(){
        return puntiInteresseDAO.ottieniElencoPuntiInteresse();
    }

    //TODO rmi
    public PuntoInteresse[] ricercaPerNome(String nome) {
        return puntiInteresseDAO.ottieniPuntiInteressePerNome(nome);
    }

    //TODO rmi
    public PuntoInteresse[] ricercaPerNazione(String codiceNazione){
        return puntiInteresseDAO.ottieniPuntiInteressePerCodiceNazione(codiceNazione);
    }

    //TODO rmi
    public PuntoInteresse[] ricercaPerCoordinate(double latitudine, double longitudine){
        PuntoInteresse[] elencoPuntiInteresse = puntiInteresseDAO.ottieniElencoPuntiInteresse();
        TreeMap<Double, PuntoInteresse> distanze = new TreeMap<>();

        for(PuntoInteresse puntoInteresse : elencoPuntiInteresse) {
            Double distanza = CalcoloHaversine.haversine(latitudine, longitudine, puntoInteresse.getLatitudine(), puntoInteresse.getLongitudine());
            distanze.put(distanza, puntoInteresse);
        }

        elencoPuntiInteresse = new PuntoInteresse[PUNTI_INTERESSE_MAX_RICERCA_COORDINATE];
        for(int i = 0; i < PUNTI_INTERESSE_MAX_RICERCA_COORDINATE; i++)
            elencoPuntiInteresse[i] = distanze.pollFirstEntry().getValue();

        return elencoPuntiInteresse;
    }
    

}
