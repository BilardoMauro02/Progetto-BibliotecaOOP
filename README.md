# 📚 Biblioteca Digitale - Progetto Java OOP

## 📌 Descrizione

Questo progetto rappresenta un sistema di gestione per una **Biblioteca Digitale**, sviluppato in Java applicando i principi fondamentali della programmazione orientata agli oggetti (OOP):

- Incapsulamento  
- Ereditarietà  
- Polimorfismo  

L'applicazione permette di:

- Gestire diverse tipologie di risorse (Libri, Riviste, Ebook)
- Registrare utenti
- Effettuare prestiti e restituzioni
- Visualizzare l'inventario della biblioteca
- Cercare risorse per titolo

---

## 🧱 Struttura del Progetto

### 🔹 Classe Astratta: `Risorsa`
- Attributi:
  - `titolo`
  - `annoPubblicazione`
  - `codice`
- Metodi:
  - Getter
  - Metodo astratto `visualizzaDettagli()`

---

### 🔹 Sottoclassi di `Risorsa`

#### 📖 `Libro`
- Attributo: `autore`
- Override di `visualizzaDettagli()`

#### 📰 `Rivista`
- Attributo: `numeroRivista`
- Override di `visualizzaDettagli()`

#### 💻 `Ebook`
- Attributo: `formato`
- Override di `visualizzaDettagli()`

---

### 👤 Classe `Utente`
- Attributi:
  - `nome`
  - `idUtente`
  - Lista `prestiti`
- Funzionalità:
  - Prendere in prestito una risorsa
  - Restituire una risorsa
  - Visualizzare i prestiti

---

### 🏛️ Classe `Biblioteca`
- Attributi:
  - `nome`
  - Lista `risorse`
  - Lista `utenti`
- Funzionalità:
  - Aggiungere risorse e utenti
  - Stampare inventario (uso del polimorfismo)
  - Cercare risorse per titolo

---

### ▶️ `Main`
Gestisce l'interazione con l'utente tramite menu:

- Inserimento risorse
- Registrazione utenti
- Prestiti e restituzioni
- Visualizzazione dati

---

## 🧠 Principi OOP Applicati

### 🔒 Incapsulamento
Tutti gli attributi sono `private` e accessibili tramite getter/setter.

### 🧬 Ereditarietà
Le classi:
- `Libro`
- `Rivista`
- `Ebook`  
estendono la classe astratta `Risorsa`.

### 🔄 Polimorfismo
Utilizzo del metodo `visualizzaDettagli()` nelle collezioni di tipo `ArrayList<Risorsa>`.

---

## 👥 Suddivisione dei Compiti

| Componente | Sviluppatore |
|-----------|-------------|
| Classe `Risorsa` (astratta) | Danilo |
| Classi `Libro`, `Rivista`, `Ebook` | Mauro |
| Classe `Utente` | Danilo |
| Classe `Biblioteca` | Mauro |
| Classe `Main` | Danilo |

---

## ▶️ Come Eseguire il Progetto

1. Clonare la repository: