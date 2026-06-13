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

# 2) Perchè è utile?
Il codice sviluppato è un ottima base per la creazione di un gioco completo. Le classi sono state progettate in modo da poter 
essere estese grazie alle interfaccie che ne prevedono la creazione per ogni tipologia di classi di gestione.

Le classi JSon si basano su una struttura che può essere implementata su altre tipologie di gestione e archiviazione dei dati.

# 3) Come iniziare?
## Prerequisiti
- **JDK 25**: il progetto usa una toolchain Gradle impostata su Java 25.
- **Git**: necessario per clonare il repository.

## Dopo l'avvio del gioco

Dopo l'avvio, il gioco parte dalla schermata introduttiva: seleziona i reparti dell'ospedale e prendi le tue decisioni per far progredire la storia ed evitare il Game Over.
A ogni game over si ritornerà all'inizio della cariera ma mantenendo gli oggetti già ottenuti.
