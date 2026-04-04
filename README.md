# Scrum Practice - Calculator

Progetto accademico sviluppato nell'ambito del corso di Software Architecture and Design (A.A. 2025/26) presso l'Università degli Studi di Salerno (UNISA) durante una simulazione Scrum, con obiettivo la realizzazione di una calcolatrice da terminale senza interfaccia grafica.
<div align="center">
  <img src="https://github.com/user-attachments/assets/811a1a5a-88ab-4bb0-a749-ebf3f7ce8c5c">
</div>

## Problem Description

L'obiettivo è creare un programma che permetta di usare il computer come calcolatrice.  
Il programma non richiede un'interfaccia grafica.  
Deve supportare le principali operazioni aritmetiche sui numeri reali e consentire il riutilizzo del risultato dell'ultima operazione come operando per quella successiva.  
Sono apprezzate funzionalità avanzate, come comportamenti simili alla memoria e funzioni da calcolatrice scientifica (ad esempio le funzioni trigonometriche).

## Funzionalità implementate

- Operazioni base sui numeri reali: somma, sottrazione, prodotto, divisione
- Riutilizzo del risultato precedente tramite input `res`
- Funzioni trigonometriche: `sin/seno`, `cos/coseno`, `tan/tangente`
- Supporto modalità angoli in radianti o gradi
- Validazioni su input non numerici e casi non ammessi (divisione per zero, tangente non definita)
- Test automatici con JUnit 4 per operazioni aritmetiche, trigonometriche, conversioni e gestione errori

## Requisiti

- [Java JDK](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html) (nel progetto NetBeans è impostato `JDK_24`; in ambiente locale è consigliato usare JDK compatibile)
- [NetBeans](https://www.codelerity.com/netbeans/) (opzionale ma consigliato per import diretto del progetto)

## Scrum Process Practice

Il progetto è stato sviluppato come esercitazione Scrum con team da 3-4 persone. La gestione del flusso di lavoro è stata interamente affidata a una board Trello, utilizzata non solo come task board, ma come vero strumento di pianificazione agile:

- Definizione delle User Stories: Ogni esigenza dell'utente è stata formalizzata come User Story all'interno del Backlog.
- Etichette e Priorità: Abbiamo utilizzato il sistema di etichette (Labels) di Trello per classificare le storie in base alla priorità (Alta, Media, Bassa) e per assegnare gli Story Points, permettendo una stima immediata del carico di lavoro.
- Scomposizione Granulare: Ogni User Story è stata scomposta in ulteriori schede tecniche indipendenti. Questo ha permesso di gestire ogni sotto-task come un'entità autonoma, facilitandone lo spostamento tra le fasi di sviluppo (To Do, Doing, Done).
- Assegnazione e Responsabilità: Grazie al sistema di assegnazione dei membri, ogni task è stato preso in carico dai diversi componenti del gruppo, garantendo trasparenza sullo stato di avanzamento e una divisione equa del lavoro durante gli Sprint.

### Prerequisiti della pratica

- Team di 3-4 persone
- Conoscenza base Scrum
- Accesso a Trello
- Ambiente di sviluppo scelto dal team

### Fasi della simulazione

- **Step 1 – Preparation (45 min, pre-aula)**  
  Definizione ruoli (Product Owner + Team), setup board Trello, creazione backlog iniziale user stories, Definition of Done, accordo tecnico.

- **Sprint 1**
  - Planning (10 min)
  - Development (40 min) + Delivery 1 (incremento potenzialmente rilasciabile)
  - Review (5 min)
  - Retrospective (5 min)

- **Sprint 2**
  - Planning (10 min)
  - Development (40 min) + Delivery 2 (incremento potenzialmente rilasciabile)
  - Review (5 min)
  - Retrospective (5 min)

- **Sprint 3 (simulazione estesa dal team)**  
  Iterazione aggiuntiva utilizzata per consolidare integrazione, qualità del codice e verifica funzionale.

- **Consegna finale (Delivery 3)**  
  Report riassuntivo dell’attività svolta secondo template fornito.

## Report Scrum

Link al report (read-only): [Report Scrum - Google Docs](https://docs.google.com/document/d/1lbCg9Yh2O5zoObNZSU_qRbngo5bRLm3kLhqnRN6rXKQ/edit?usp=sharing)

## Board Trello realizzata durante lo sviluppo
<img width="1917" height="931" alt="Screenshot 2026-04-05 002432" src="https://github.com/user-attachments/assets/f4e64504-e4aa-4639-b6ab-98d0f089adfc" />


