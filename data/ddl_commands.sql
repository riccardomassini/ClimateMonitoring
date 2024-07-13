CREATE TABLE CentriMonitoraggio (
    NomeCentro varchar(20) PRIMARY KEY,
    Indirizzo varchar(50) NOT NULL,
    numeroCivico int NOT NULL,
    cap char(5) NOT NULL,
    Comune varchar(20) NOT NULL,
    Provincia char(2)
);

CREATE TABLE OperatoriRegistrati (
    UserID SERIAL PRIMARY KEY, -- Utilizzare SERIAL per PostgreSQL, o AUTO_INCREMENT per MySQL
    Nome varchar(30) NOT NULL,
    Cognome varchar(30) NOT NULL,
    CodFisc char(16) NOT NULL,
    Email varchar(30) NOT NULL,
    Password varchar(20) NOT NULL,
    Centro varchar(20) REFERENCES CentriMonitoraggio(NomeCentro)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE TABLE CoordinateMonitoraggio (
    GeonameID char(10) PRIMARY KEY,
    NomePaese varchar(70) NOT NULL,
    AsciiPaese varchar(70) NOT NULL,
    CodiceStato char(2) NOT NULL,
    NomeStato varchar(70) NOT NULL,
    Latitudine float NOT NULL CHECK (Latitudine >= -90 AND Latitudine <= 90),
    Longitudine float NOT NULL CHECK (Longitudine >= -180 AND Longitudine <= 180)
);

CREATE TABLE ParametriClimatici (
    GeonameID char(7) REFERENCES CoordinateMonitoraggio(GeonameID)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    Centro varchar(20) REFERENCES CentriMonitoraggio(NomeCentro)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    DataInserimento timestamp NOT NULL,
    Vento int NOT NULL CHECK (Vento >= 0),
    VentoNote varchar(256),
    Umidita int NOT NULL CHECK (Umidita >= 0),
    UmiditaNote varchar(256),
    Pressione int NOT NULL CHECK (Pressione >= 0),
    PressioneNote varchar(256),
    Temperatura int NOT NULL CHECK (Temperatura >= 0),
    TemperaturaNote varchar(256),
    Precipitazioni int NOT NULL CHECK (Precipitazioni >= 0),
    PrecipitazioniNote varchar(256),
    AltitudineGhiacciai int NOT NULL CHECK (AltitudineGhiacciai >= 0),
    AltitudineGhiacciaiNote varchar(256),
    MassaGhiacciai int NOT NULL CHECK (MassaGhiacciai >= 0),
    MassaGhiacciaiNote varchar(256),
    PRIMARY KEY (GeonameID, Centro, DataInserimento)
);

CREATE TABLE AreeMonitorateDaCentri (
    Centro varchar(20) REFERENCES CentriMonitoraggio(NomeCentro)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    GeonameID char(7) REFERENCES CoordinateMonitoraggio(GeonameID)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    PRIMARY KEY (Centro, GeonameID)
);
