/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package commons.servizio;

import commons.oggetti.misurazioni.Misurazione;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaccia {@code GestioneMisurazioni} per la gestione delle misurazioni climatiche.
 * <p>
 * Questa interfaccia definisce i metodi per inserire nuove misurazioni e ottenere le misurazioni effettuate su un
 * punto di interesse specifico.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
public interface GestioneMisurazioni extends Remote {

    /**
     * Inserisce una nuova misurazione nel sistema.
     *
     * @param nuovaMisurazione la misurazione da inserire
     * @throws RemoteException se si verifica un errore di comunicazione durante l'inserimento
     */
    void inserisciNuovaMisurazione(Misurazione nuovaMisurazione) throws RemoteException;

    /**
     * Ottiene tutte le misurazioni effettuate su un punto di interesse specifico.
     *
     * @param idPuntoInteresse l'identificativo del punto di interesse per cui ottenere le misurazioni
     * @return un array di {@code Misurazione} contenente tutte le misurazioni effettuate sul punto di interesse
     * @throws RemoteException se si verifica un errore di comunicazione durante il recupero delle misurazioni
     */
    Misurazione[] ottieniMisurazioniSuPuntoInteresse(int idPuntoInteresse) throws RemoteException;
}