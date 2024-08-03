INSERT INTO CentriMonitoraggio(nomeCentroMonitoraggio, indirizzo) VALUES ('centro1', 'via prova, 1'); 

/*
password = Prova_1234
*/
INSERT INTO Operatori VALUES ('PRVDMN00A01H501I', 'Admin', 'Prova', 'admin.prova@mail.it', 'Admin1', '$2a$15$cIKmT1YJZhvCLsqs8fTzMORYQ1okIZ1kTwOBtYQ9/WbsTYnPGOsVe', 1); 

INSERT INTO CategorieParametriClimatici 
    VALUES 
    (1, 'vento', 'velocità del vento', 'Km/h'),
    (2, 'umidità', ' ', '%'),
    (3, 'pressione', ' ', 'hPa'),
    (4, 'temperatura', ' ', '°C'),
    (5, 'precipitazioni', ' ', 'mm'),
    (6, 'altitudine ghiacciai', ' ', 'm'),
    (7, 'massa ghiaccia', ' ', 'Kg');


INSERT INTO PuntiInteresseMonitorati 
    VALUES
    (3178229 , 1), --Como
    (3164699 , 1);  --Varese

INSERT INTO Misurazioni
    VALUES 
    (1, CURRENT_TIMESTAMP, 1, 3178229), --misurazione 1 per como
    (2, CURRENT_TIMESTAMP, 1, 3178229), --misurazione 2 per como
    (3, CURRENT_TIMESTAMP, 1, 3164699); --misurazione 1 per varese

INSERT INTO ValutazioniParametriClimatici
    VALUES 
    (1, 1, 20.0, 1, 'vento moderato a Como'),
    (1, 4, 35.3, 4, null),
    (1, 2, 40, 2, null),
    (2, 1, 55, 4, 'vento estremamente forte'),
    (2, 4, 5.2, 3, 'temperatura fredda');