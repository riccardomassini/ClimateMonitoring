package server.database.servizio;

 class DizionarioDatabase {
     static final String PUNTIINTERESSE_RELAZIONE = "CoordinateMonitoraggio";
     static final String PUNTIINTERESSE_ATTRIBUTO_ID = "GeonameID";
     static final String PUNTIINTERESSE_ATTRIBUTO_NOME = "NomePaese";
     static final String PUNTIINTERESSE_ATTRIBUTO_NOMEASCII = "AsciiPaese";
     static final String PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE = "CodiceStato";
     static final String PUNTIINTERESSE_ATTRIBUTO_NOMENAZIONE = "NomeStato";
     static final String PUNTIINTERESSE_LATITUDINE = "Latitudine";
     static final String PUNTIINTERESSE_LONGITUDINE = "Longitudine";

     static final String OPERATORI_RELAZIONE = "OperatoriRegistrati";
     static final String OPERATORI_ATTRIBUTO_USERNAME = "UserID";
     static final String OPERATORI_ATTRIBUTO_NOME = "Nome";
     static final String OPERATORI_ATTRIBUTO_COGNOME = "Cognome";
     static final String OPERATORI_ATTRIBUTO_CF = "CodFisc";
     static final String OPERATORI_ATTRIBUTO_EMAIL = "Email";
     static final String OPERATORI_ATTRIBUTO_PASSWORD = "Password";
     static final String OPERATORI_ATTRIBUTO_IDCENTROMONITORAGGIO = "NomeCentro";

     static final String CENTRIMONITORAGGIO_RELAZIONE = "CentriMonitoraggio";
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO = "NomeCentro";
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_INDIRIZZO = "Indirizzo";
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_NUMEROCIVICO = "numeroCivico";
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_CAP = "cap";
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_COMUNE = "Comune";
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_PROVINCIA = "Provincia";

     static final String MISURAZIONI_RELAZIONE = "ParametriClimatici";
     static final String MISURAZIONI_ATTRIBUTO_IDPUNTOINTERESSE = "GeonameID";
     static final String MISURAZIONI_ATTRIBUTO_IDCENTROMONITORAGGIO = "NomeCentro";
     static final String MISURAZIONI_ATTRIBUTO_TIMESTAMP = "DataInserimento";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_VENTO = "Vento";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_VENTO = "VentoNote";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_UMIDITA = "Umidita";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_UMIDITA = "UmiditaNote";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRESSIONE = "Pressione";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_PRESSIONE = "PressioneNote";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_TEMPERATURA = "Temperatura";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_TEMPERATURA = "TemperaturaNote";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRECIPITAZIONI = "Precipitazioni";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_PRECIPITAZIONI = "PrecipitazioniNote";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_ALTEZZAGHIACCIAI = "AltitudineGhiacciai";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_ALTEZZAGHIACCIAI = "AltitudineGhiacciaiNote";
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_MASSAGHIACCIAI = "MassaGhiacciai";
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_MASSAGHIACCIAI = "MassaGhiacciaiNote";

     static final String PUNTIINTERESSEASSOCIATI_RELAZIONE = "AreeMonitorateDaCentri";
     static final String PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDPUNTOINTERESSE = "GeonameID";
     static final String PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDCENTROMONITORAGGIO = "NomeCentro";


}
