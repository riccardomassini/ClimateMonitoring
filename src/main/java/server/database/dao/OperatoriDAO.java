package server.database.dao;

import commons.oggetti.Operatore;

public interface OperatoriDAO {
    boolean inserisciNuovoOperatore(Operatore nuovoOperatore);
    Operatore ottieniOperatoreDaUsername(int username);
}
