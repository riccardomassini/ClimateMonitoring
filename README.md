# ClimateMonitoring
ClimateMonitoring è un applicazione per la gestione e la rilevazioni di parametri climatici su determinate aree di interesse.

## Descrizione
Puoi utilizzare ClimateMonitoring come operatore oppure come cittadino. I primi possono registrarsi all'applicazione e successivamente effettuare il log-in avendo la possibilità di registrare o scegliere un centro di monitoraggio dove è possibile effettuare delle operazioni di rilevazione su determinate aree di interesse. I cittadini possono invece osservare le rilevazioni fatte dagli operatori e cercare tramite un interfaccia apposita tutti i paesi del mondo per nome, codice stato oppure per coordinate.

## Prerequisiti
* java 17 o versioni più rceneti.
* PostgreSQL versione 16.
* username e password default di postgres -> username: ```postgres``` e password: ```root```.

## Cambiare username e password con PostgreSQL
Innanzitutto è necessario collegarsi a PostgreSQL utilizzando il seguente comando: ```psql -U username```.
Dopo aver inserito la password corretta procedere con i seguenti passaggi.

### Username
Se si vuole cambiare nome utente è necessario cambiare la ROLE nel seguente modo: ```ALTER TABLE username RENAME TO new_username;```.

### Password
Se si vuole cambiare password bisogna procedere nel seguente modo: ```ALTER USER username PASSWORD 'new_password';```.

### Da pgadmin
Tutto questo può essere fatto anche da interfaccia grafica su pgadmin, infatti cliccando su ```Object - Change Password``` possiamo modificare la password. La stessa cosa vale per l'username, cliccando con il tasto destro sul nome del server e andando su ```Connection``` possiamo notare host, porta e username. Da qui si può modificare l'username e salvare.

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
    Se invece hai scaricato il file ```.zip```:
    * estrai la cartella.
    * accedi come mostrato precedentemente.

## Inizializzazione del progetto
1. Una volta entrati nella cartella principale del progetto occorre creare e inizializzare il database utilizzando 2 comandi da terminale, è fondamentale trovarsi nella stessa directory del file pom.xml.

   Su Windows:
   * ```mvnw.cmd clean```
   * ```mvnw.cmd install```
   * oppure tutto attaccato ```mvnw.cmd clean install```
  
   Su Unix/MacOS:
   * attiva i permessi con ```chmod +x mvnw```
   * ```./mvnw clean```
   * ```./mvnw install```
   * oppure tutto attaccato ```./mvnw clean install```
  
3. Se avete installato maven sia su Windows sia su Unix/MacOS potete semplicemente digitare:
   * ```mvn clean```
   * ```mvn install```
   * oppure tutto attaccato ```mvn clean install```

4. Una volta eseguiti questi comandi il progetto sarà perfettamente configurato ed eseguibile, infatti sarà stata creata una cartella ```"Eseguibili"``` contenente 2 file eseguibili nel formato ```.jar```.

## Utilizzo
Per utilizzare l'applicazione è necessario eseguire entrambi i file ```.jar```, sia il server che il client.
Si può fare in diversi modi.

Su Windows:
* accedendo alla cartella ```Eseguibili``` e facendo doppio click su i due file.
* accedendo alla cartella contenente i file ```Eseguibili``` e digitando il nome dei due file su terminale: ```serverCM.jar``` e ```clientCM.jar```.
* accedendo alla cartella ```Eseguibili``` da terminale e digitando i seguenti comandi: ```java -jar serverCM.jar``` e ```java -jar clientCM.jar```, un alternativa a questo è eseguire direttamente i file ```.bat``` nella stessa cartella: ```serverCM.bat``` e ```clientCM.bat```.

Su Unix/MacOS:
* accedendo alla cartella ```Eseguibili``` da terminale e digitando i seguenti comandi: ```java -jar serverCM.jar``` e ```java -jar clientCM.jar```, un alternativa a questo è eseguire direttamente i file ```.bat``` nella stessa cartella: ```./serverCM.bat``` e ```./clientCM.bat```. Prima di eseguire i due processi ricordarsi di abilitare i permessi con ```chmod +x serverCM.bat``` e ```chmod +x clientCM.bat```.

Una volta eseguiti i ```jar``` è importante avviare il server per poter utilizzare l'applicazione, i dati necessari sono i seguenti:
* username: admin
* password: root
* host: 127.0.0.1
* porta: è possibile sceglierla tra il range di indirizzi validi per porte TCP/UDP, da 1024 a 65535
