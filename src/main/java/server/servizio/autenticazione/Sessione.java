package server.servizio.autenticazione;


import commons.oggetti.Operatore;

public class Sessione {
    private Operatore operatore;

    private Sessione(Operatore operatore) {
        this.operatore = operatore;
    }

    private static class contenitoreSingletonSessione {
        private static final Sessione singleton = new Sessione(null);
    }

    public static Sessione ottieniSessione() {
        return Sessione.contenitoreSingletonSessione.singleton;
    }

    public void setOperatore(Operatore operatore) {
        this.operatore = operatore;
    }

    public Operatore getOperatore() {
        return operatore;
    }

}
