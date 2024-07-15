package server.servizio.autenticazione;


import commons.oggetti.Operatore;

public class Sessione {
    private Operatore operatore;

    public Sessione(Operatore operatore) {
        this.operatore = operatore;
    }

    public Operatore getOperatore() {
        return operatore;
    }
}
