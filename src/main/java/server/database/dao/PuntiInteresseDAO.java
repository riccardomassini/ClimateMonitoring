package server.database.dao;

import commons.oggetti.PuntoInteresse;

public interface PuntiInteresseDAO {
    PuntoInteresse[] ottieniElencoPuntiInteresse();
    PuntoInteresse[] ottieniPuntiInteressePerNome(String nome);
    PuntoInteresse[] ottieniPuntiInteressePerCodiceNazione(String codiceNazione);
    PuntoInteresse[] ottieniPuntiInteressePerNomeECodiceNazione(String nomePuntoInteresse, String codiceNazione);
}
