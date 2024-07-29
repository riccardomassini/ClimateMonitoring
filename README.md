# ClimateMonitoring
ClimateMonitoring è un applicazione per la gestione e la rilevazioni di parametri climatici su determinate aree di interesse.

## Descrizione
Puoi utilizzare ClimateMonitoring come operatore oppure come cittadino. I primi possono registrarsi all'applicazione e successivamente effettuare il log-in avendo la possibilità di registrare o scegliere un centro di monitoraggio dove è possibile effettuare delle operazioni di rilevazione su determinate aree di interesse. I cittadini possono invece osservare le rilevazioni fatte dagli operatori e cercare tramite un interfaccia apposita tutti i paesi del mondo per nome, codice stato oppure per coordinate.

## Prerequisiti
Elenco prerequisiti...

## Installazione
Per installare e configurare ClimateMonitoring sul tuo ambiente locale, segui questi passaggi:

1. Clona la repository tramite il seguente comando:
    ```bash
    git clone https://github.com/riccardomassini/ClimateMonitoring.git
    ```
    oppure cliccando il seguente link: [https://github.com/riccardomassini/ClimateMonitoring/archive/refs/heads/main.zip](https://github.com/riccardomassini/ClimateMonitoring/archive/refs/heads/main.zip)
   
2. Se hai usato il comando ```git``` per scaricare il progetto allora puoi accedere alla root direttamente con:
    ```bash
    cd ClimateMonitoring
    ```
    Se invece hai scaricato il file zip:
    * estrai la cartella
    * accedi come mostrato precedentemente

## Inizializzazione del progetto
1. Una volta entrati nella cartella principale del progetto occorre creare e inizializzare il database utilizzando 2 comandi da terminale, è fondamentale trovarsi nella stessa directory del file pom.xml:
   * ```mvn clean```
   * ```mvn install```
2. Una volta eseguiti questi due comandi il progetto sarà perfettamente configurato ed eseguibili, infatti sarà stata creata una cartella ```jar``` contenente 2 file eseguibili nel formato ```.jar```.

## Utilizzo
Per utilizzare l'applicazione è necessario eseguire entrambi i file ```.jar```, sia il server che il client.
Si può fare in due modi:
* accedendo alla cartella ```jar``` e facendo doppio click su i due file.
* accedendo alla cartella ```jar``` da terminale e digitando i seguenti comandi: ```java -jar serverCM.jar``` e ```java -jar clientCM.jar```, un alternativa a questo è eseguire direttamente i processi ```./serverCM``` e ```./clientCM```
