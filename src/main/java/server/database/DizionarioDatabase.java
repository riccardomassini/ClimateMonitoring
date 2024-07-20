package server.database;

public class DizionarioDatabase {
    public static final String PUNTIINTERESSE_RELAZIONE = "CoordinateMonitoraggio";
    public static final String PUNTIINTERESSE_ATTRIBUTO_ID = "GeonameID";
    public static final String PUNTIINTERESSE_ATTRIBUTO_NOME = "NomePaese";
    public static final String PUNTIINTERESSE_ATTRIBUTO_NOMEASCII = "AsciiPaese";
    public static final String PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE = "CodiceStato";
    public static final String PUNTIINTERESSE_ATTRIBUTO_NOMENAZIONE = "NomeStato";
    public static final String PUNTIINTERESSE_LATITUDINE = "Latitudine";
    public static final String PUNTIINTERESSE_LONGITUDINE = "Longitudine";

    public static final String OPERATORI_RELAZIONE = "OperatoriRegistrati";
    public static final String OPERATORI_ATTRIBUTO_USERNAME = "UserID";
    public static final String OPERATORI_ATTRIBUTO_NOME = "Nome";
    public static final String OPERATORI_ATTRIBUTO_COGNOME = "Cognome";
    public static final String OPERATORI_ATTRIBUTO_CF = "CodFisc";
    public static final String OPERATORI_ATTRIBUTO_EMAIL = "Email";
    public static final String OPERATORI_ATTRIBUTO_PASSWORD = "Password";
    public static final String OPERATORI_ATTRIBUTO_IDCENTROMONITORAGGIO = "Centro";

    public static final String CENTRIMONITORAGGIO_RELAZIONE = "CentriMonitoraggio";
    public static final String CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO = "NomeCentro";
    public static final String CENTRIMONITORAGGIO_ATTRIBUTO_INDIRIZZO = "Indirizzo";
    public static final String CENTRIMONITORAGGIO_ATTRIBUTO_NUMEROCIVICO = "numeroCivico";
    public static final String CENTRIMONITORAGGIO_ATTRIBUTO_CAP = "cap";
    public static final String CENTRIMONITORAGGIO_ATTRIBUTO_COMUNE = "Comune";
    public static final String CENTRIMONITORAGGIO_ATTRIBUTO_PROVINCIA = "Provincia";

    public static final String MISURAZIONI_RELAZIONE = "ParametriClimatici";
    public static final String MISURAZIONI_ATTRIBUTO_IDPUNTOINTERESSE = "GeonameID";
    public static final String MISURAZIONI_ATTRIBUTO_IDCENTROMONITORAGGIO = "Centro";
    public static final String MISURAZIONI_ATTRIBUTO_TIMESTAMP = "DataInserimento";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_VENTO = "Vento";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_VENTO = "VentoNote";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_UMIDITA = "Umidita";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_UMIDITA = "UmiditaNote";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRESSIONE = "Pressione";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_PRESSIONE = "PressioneNote";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_TEMPERATURA = "Temperatura";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_TEMPERATURA = "TemperaturaNote";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRECIPITAZIONI = "Precipitazioni";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_PRECIPITAZIONI = "PrecipitazioniNote";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_ALTEZZAGHIACCIAI = "AltitudineGhiacciai";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_ALTEZZAGHIACCIAI = "AltitudineGhiacciaiNote";
    public static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_MASSAGHIACCIAI = "MassaGhiacciai";
    public static final String MISURAZIONI_ATTRIBUTO_COMMENTO_MASSAGHIACCIAI = "MassaGhiacciaiNote";

    public static final String PUNTIINTERESSEASSOCIATI_RELAZIONE = "AreeMonitorateDaCentri";
    public static final String PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDPUNTOINTERESSE = "GeonameID";
    public static final String PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDCENTROMONITORAGGIO = "Centro";


}
