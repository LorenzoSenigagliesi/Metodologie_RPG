# Metodologie_RPG
di senigagliesi Lorenzo

matricola:122755
## 1) Introduzione
Il gioco RPG sviluppato prende ispirazione dal videogioco mobile Lapse. La storia è incentrata su un uomo che si risveglia 
nel proprio ufficio: è il direttore di un ospedale, ma qualcosa sembra non andare per il verso giusto.

Durante il gioco, l'utente deve selezionare i vari reparti dell'ospedale. Per ogni reparto vengono presentate delle carte 
contenenti eventi o richieste, e il giocatore è costretto a prendere una decisione tra le opzioni disponibili.

Ogni scelta influisce sulle caratteristiche dell'ospedale, che possono aumentare o diminuire in base alle conseguenze delle decisioni prese. 
Se una qualsiasi caratteristica raggiunge il valore zero, la partita termina con un Game Over e il giocatore dovrà ricominciare dall'inizio.

Oltre alla gestione delle risorse, il gioco include una trama narrativa. Per scoprire l'intera storia e raggiungere il finale,
il giocatore dovrà completare una serie di eventi speciali che si attivano nel corso della partita.

# 2) Funzionalità implementate 
## 2.1) Grafica
Per la realizzazione dell'interfaccia grafica del progetto ho utilizzato file FXML, che consentono di definire e modificare
la grafica senza dover scrivere un elevato numero di righe di codice. Inoltre, permettono una gestione più ordinata e pulita degli eventi.

Per la modifica dei file FXML ho utilizzato Scene Builder, un'applicazione che consente di visualizzare e progettare le 
interfacce in modo grafico, senza la necessità di intervenire direttamente sul codice sorgente.

## 2.2) Gson
Per la gestione dei file JSON ho utilizzato la libreria Gson, che semplifica notevolmente le operazioni di serializzazione
e deserializzazione dei dati. Grazie a questa libreria, la gestione della persistenza risulta più semplice ed efficiente,
poiché la lettura e la scrittura di file JSON possono essere effettuate con poche istruzioni.

## 3) Responsabilità
Ho diviso le classi in tre gruppi principali in modo da renderlo più facilmente estendendibilee coprensibile ad altri.
Questa organizzazione segue il pattern MVC (Model-View-Controller), consentendo di mantenere separata la logica di 
presentazione dalla logica di gestione dei dati e delle funzionalità del gioco.

## 3.1) Model
In questo modulo sono incluse tutte le classi che rappresentano il modello dei dati
dell'applicazione (un esempio sono Ospedale, Scelte, Testi). Queste classi vengono serializzate e deserializzate
in formato JSON per la persistenza dei dati.
## 3.2) Gestione
Nella gestione troviamo tutte le classi u

## 4) Classi e interfaccie sviluppate

## 5) Dati e persistenza
Per la persistenza dei dati è stato adottato il formato JSON, supportato dall’utilizzo della libreria
GSON. Tale scelta permette una gestione dei file efficiente, sicura e flessibile, facilitando le operazioni
di lettura, scrittura e aggiornamento delle informazioni relative a utenti, famiglie e movimenti
finanziari.

## 5) Strumenti AI