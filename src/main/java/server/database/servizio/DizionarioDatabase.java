/**************************************
 * Matricola    Cognome     Nome
 * 753291       Massini     Riccardo
 * 753216       Abignano    Luca
 * 754696       Artale      Lorenzo
 * Sede: Como
 ***************************************/

package server.database.servizio;

/**
 * Classe {@code DizionarioDatabase} che contiene le costanti per le relazioni e gli attributi utilizzati
 * nelle operazioni con il database.
 * <p>
 * Questa classe fornisce una serie di costanti statiche che rappresentano i nomi delle tabelle e dei campi
 * nel database, utilizzate per facilitare l'accesso e la manipolazione dei dati attraverso le query.
 * Le costanti sono organizzate in gruppi per ciascun tipo di oggetto gestito nel database.
 * </p>
 *
 * <p>
 * La classe è progettata per essere utilizzata da tutte le classi che interagiscono con il database,
 * per mantenere coerenza e per facilitare eventuali modifiche alle strutture del database.
 * </p>
 *
 * @author Riccardo Massini
 * @author Luca Abignano
 * @author Lorenzo Artale
 */
 class DizionarioDatabase {

    /**
     * Nome della tabella che contiene le informazioni sui punti di interesse.
     */
     static final String PUNTIINTERESSE_RELAZIONE = "CoordinateMonitoraggio";

    /**
     * Nome dell'attributo per l'identificatore unico del punto di interesse.
     */
     static final String PUNTIINTERESSE_ATTRIBUTO_ID = "GeonameID";

    /**
     * Nome dell'attributo per il nome del paese del punto di interesse.
     */
     static final String PUNTIINTERESSE_ATTRIBUTO_NOME = "NomePaese";

    /**
     * Nome dell'attributo per il nome ASCII del paese del punto di interesse.
     */
     static final String PUNTIINTERESSE_ATTRIBUTO_NOMEASCII = "AsciiPaese";

    /**
     * Nome dell'attributo per il codice nazionale del punto di interesse.
     */
     static final String PUNTIINTERESSE_ATTRIBUTO_CODICENAZIONE = "CodiceStato";

    /**
     * Nome dell'attributo per il nome nazionale del punto di interesse.
     */
     static final String PUNTIINTERESSE_ATTRIBUTO_NOMENAZIONE = "NomeStato";

    /**
     * Nome dell'attributo per la latitudine del punto di interesse.
     */
     static final String PUNTIINTERESSE_LATITUDINE = "Latitudine";

    /**
     * Nome dell'attributo per la longitudine del punto di interesse.
     */
     static final String PUNTIINTERESSE_LONGITUDINE = "Longitudine";

    /**
     * Nome della tabella che contiene le informazioni sugli operatori.
     */
     static final String OPERATORI_RELAZIONE = "OperatoriRegistrati";

    /**
     * Nome dell'attributo per il nome utente dell'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_USERNAME = "UserID";

    /**
     * Nome dell'attributo per il nome dell'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_NOME = "Nome";

    /**
     * Nome dell'attributo per il cognome dell'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_COGNOME = "Cognome";

    /**
     * Nome dell'attributo per il codice fiscale dell'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_CF = "CodFisc";

    /**
     * Nome dell'attributo per l'email dell'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_EMAIL = "Email";

    /**
     * Nome dell'attributo per la password dell'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_PASSWORD = "Password";

    /**
     * Nome dell'attributo per il centro di monitoraggio associato all'operatore.
     */
     static final String OPERATORI_ATTRIBUTO_IDCENTROMONITORAGGIO = "NomeCentro";

     /**
     * Nome della tabella che contiene le informazioni sui centri di monitoraggio.
     */
     static final String CENTRIMONITORAGGIO_RELAZIONE = "CentriMonitoraggio";

    /**
     * Nome dell'attributo per il nome del centro di monitoraggio.
     */
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_NOMECENTRO = "NomeCentro";

    /**
     * Nome dell'attributo per l'indirizzo del centro di monitoraggio.
     */
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_INDIRIZZO = "Indirizzo";

    /**
     * Nome dell'attributo per il numero civico del centro di monitoraggio.
     */
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_NUMEROCIVICO = "numeroCivico";

    /**
     * Nome dell'attributo per il CAP del centro di monitoraggio.
     */
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_CAP = "cap";

    /**
     * Nome dell'attributo per il comune del centro di monitoraggio.
     */
     static final String CENTRIMONITORAGGIO_ATTRIBUTO_COMUNE = "Comune";
    /**
     * Nome dell'attributo per la provincia del centro di monitoraggio.
     */

     static final String CENTRIMONITORAGGIO_ATTRIBUTO_PROVINCIA = "Provincia";

    /**
     * Nome della tabella che contiene le misurazioni climatiche.
     */
     static final String MISURAZIONI_RELAZIONE = "ParametriClimatici";

    /**
     * Nome dell'attributo per l'identificatore del punto di interesse associato alla misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_IDPUNTOINTERESSE = "GeonameID";

    /**
     * Nome dell'attributo per il nome del centro di monitoraggio associato alla misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_IDCENTROMONITORAGGIO = "NomeCentro";

    /**
     * Nome dell'attributo per il timestamp della misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_TIMESTAMP = "DataInserimento";

    /**
     * Nome dell'attributo per la valutazione del vento nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_VENTO = "Vento";

    /**
     * Nome dell'attributo per il commento relativo alla valutazione del vento.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_VENTO = "VentoNote";

    /**
     * Nome dell'attributo per la valutazione dell'umidità nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_UMIDITA = "Umidita";

    /**
     * Nome dell'attributo per il commento relativo alla valutazione dell'umidità.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_UMIDITA = "UmiditaNote";

    /**
     * Nome dell'attributo per la valutazione della pressione nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRESSIONE = "Pressione";

    /**
     * Nome dell'attributo per il commento relativo alla valutazione della pressione.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_PRESSIONE = "PressioneNote";

    /**
     * Nome dell'attributo per la valutazione della temperatura nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_TEMPERATURA = "Temperatura";

    /**
     * Nome dell'attributo per il commento relativo alla valutazione della temperatura.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_TEMPERATURA = "TemperaturaNote";

    /**
     * Nome dell'attributo per la valutazione delle precipitazioni nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_PRECIPITAZIONI = "Precipitazioni";

    /**
     * Nome dell'attributo per il commento relativo alla valutazione delle precipitazioni.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_PRECIPITAZIONI = "PrecipitazioniNote";

    /**
     * Nome dell'attributo per la valutazione dell'altitudine dei ghiacciai nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_ALTEZZAGHIACCIAI = "AltitudineGhiacciai";

    /**
     * Nome dell'attributo per il commento relativo alla valutazione dell'altitudine dei ghiacciai.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_ALTEZZAGHIACCIAI = "AltitudineGhiacciaiNote";

    /**
     * Nome dell'attributo per la valutazione della massa dei ghiacciai nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_VALUTAZIONE_MASSAGHIACCIAI = "MassaGhiacciai";

    /**
     * Nome dell'attributo per il commento relativo alla massa dei ghiacciai nella misurazione.
     */
     static final String MISURAZIONI_ATTRIBUTO_COMMENTO_MASSAGHIACCIAI = "MassaGhiacciaiNote";

    /**
     * Nome della tabella che contiene le associazioni tra punti di interesse e centri di monitoraggio.
     */
     static final String PUNTIINTERESSEASSOCIATI_RELAZIONE = "AreeMonitorateDaCentri";

    /**
     * Nome dell'attributo per l'identificatore unico del punto di interesse associato.
     */
     static final String PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDPUNTOINTERESSE = "GeonameID";

    /**
     * Nome dell'attributo per il nome del centro di monitoraggio associato al punto di interesse.
     */
     static final String PUNTIINTERESSEASSOCIATI_ATTRIBUTO_IDCENTROMONITORAGGIO = "NomeCentro";
}