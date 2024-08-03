CREATE DATABASE ClimateMonitoringV2;

CREATE TABLE Nazioni (
    codiceNazione char(2),
    nomeNazione varchar(64) NOT NULL UNIQUE,

    PRIMARY KEY(codiceNazione)
);

CREATE TABLE PuntiInteresse (
    idPuntoInteresse int,
    nomePuntoInteresse varchar(128) NOT NULL,
    latitudine decimal(8,6) NOT NULL,
    longitudine decimal(9,6) NOT NULL,
    codiceNazione char(2) NOT NULL,

    --una coppia di coordinate geografiche deve essere unica
    CONSTRAINT coordinate_geografiche_uniche UNIQUE(latitudine, longitudine), 
    CONSTRAINT latitudine_valida CHECK(latitudine >= -90.0 AND latitudine <= 90.0),
    CONSTRAINT longitudine_valida CHECK(longitudine >= -180.0 AND longitudine <= 180.0),

    PRIMARY KEY(idPuntoInteresse),
    FOREIGN KEY(codiceNazione) REFERENCES Nazioni(codiceNazione)
);

CREATE TABLE CentriMonitoraggio (
    idCentroMonitoraggio smallserial,
    nomeCentroMonitoraggio varchar(64) NOT NULL,
    indirizzo varchar(128) NOT NULL,

    PRIMARY KEY(idCentroMonitoraggio)
);

CREATE TABLE PuntiInteresseMonitorati (
    idPuntoInteresse int NOT NULL,
    idCentroMonitoraggio smallint NOT NULL,
    
    PRIMARY KEY(idPuntoInteresse, idCentroMonitoraggio),
    FOREIGN KEY(idPuntoInteresse) REFERENCES PuntiInteresse(idPuntoInteresse),
    FOREIGN KEY(idCentroMonitoraggio) REFERENCES CentriMonitoraggio(idCentroMonitoraggio)
);

CREATE TABLE Operatori(
    CF varchar(16),
    nome varchar(64) NOT NULL,
    cognome varchar(64) NOT NULL,
    email varchar(128) NOT NULL UNIQUE, --email deve essere univoca
    username varchar(32) NOT NULL UNIQUE, --username deve essere univoco
    password varchar(60) NOT NULL, --viene conservato l'hash della password
    idCentroMonitoraggio smallint,

    --la lunghezza di una stringa hash calcolata tramite Bcrypt è di 60 caratteri
    CONSTRAINT lunghezza_password_valida CHECK(LENGTH(password) = 60),

    --il codice fiscale italiano ha lunghezza di 16 caratteri
    CONSTRAINT lunghezza_CF_valida CHECK(LENGTH(CF) = 16),

    --una email deve seguire un formato standard definito da RFC 2822
    CONSTRAINT formato_email_valido CHECK (email ~ '^[a-zA-Z0-9_!#$%&''*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$'), 
                                                
    PRIMARY KEY(CF),
    FOREIGN KEY(idCentroMonitoraggio) REFERENCES CentriMonitoraggio(idCentroMonitoraggio)
);

CREATE TABLE CategorieParametriClimatici (
    idCategoria smallserial,
    nomeCategoria varchar(64) NOT NULL, 
    descrizioneCategoria varchar(128) NOT NULL,
    unitaMisura varchar(16) NOT NULL,

    PRIMARY KEY(idCategoria)
);

CREATE TABLE Misurazioni(
    idMisurazione serial,
    dataOra timestamp NOT NULL,
    idCentroMonitoraggio smallint NOT NULL,
    idPuntoInteresse int NOT NULL,

    PRIMARY KEY(idMisurazione),
    FOREIGN KEY(idPuntoInteresse) REFERENCES PuntiInteresse(idPuntoInteresse),
    FOREIGN KEY(idCentroMonitoraggio) REFERENCES CentriMonitoraggio(idCentroMonitoraggio)
);

CREATE TABLE ValutazioniParametriClimatici(
    idMisurazione int NOT NULL,
    idCategoria smallint NOT NULL,
    valoreMisurato double precision NOT NULL,
    punteggio smallint NOT NULL,
    commento varchar(256), --il commento è opzionale

    PRIMARY KEY(idMisurazione, idCategoria),
    FOREIGN KEY(idMisurazione) REFERENCES Misurazioni(idMisurazione),
    FOREIGN KEY(idCategoria) REFERENCES CategorieParametriClimatici(idCategoria)
);











