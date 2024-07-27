package server.database;

class ImpostazioniDatabase {
    static final int PORTA_DEFAULT_POSTGRESQL = 5432;
    static final String DRIVER_JDBC = "org.postgresql.Driver";
    static final String NOME_DATABASE = "climate";
    static final String URL = "jdbc:postgresql://localhost:" + PORTA_DEFAULT_POSTGRESQL + "/" + NOME_DATABASE;
    static final String USERNAME = "postgres";
    static final String PASSWORD = "root";
}
