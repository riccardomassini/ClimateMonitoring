package server.database.dao;

import commons.oggetti.Misurazione;

public interface MisurazioniDAO {
    void inserisciNuovaMisurazione(Misurazione nuovaMisurazione);
    Misurazione[] ottieniMisurazioniPuntoInteresse(int idPuntoInteresse);
}
