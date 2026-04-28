import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner myScannerInt = new Scanner(System.in);
        Scanner myScannerString = new Scanner(System.in);

        boolean loop = true;
        int menu = 0;
        Bibiloteca biblioteca = new Bibiloteca("Biblioteca Centrale");
        ArrayList<Utente> utenti = new ArrayList<>();

        do{
            System.out.println("Benvenuto nella biblioteca! Scegli un'opzione:");
            System.err.println("1. Aggiungi utente");
            System.out.println("2. Aggiungi Libro");
            System.out.println("3. Aggiungi Rivista");
            System.out.println("4. Aggiungi Ebook");
            System.out.println("5. Visualizza risorse");
            System.out.println("6. Prendi in prestito");
            System.out.println("7. Restituisci");
            System.out.println("8. Esci");

            menu = myScannerInt.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Inserisci il nome dell'utente:");
                    String nomeUtente = myScannerString.nextLine();
                    // Qui si potrebbe creare un nuovo utente e aggiungerlo alla biblioteca
                    Utente nuovoUtente = new Utente(nomeUtente);
                    utenti.add(nuovoUtente);
                    break;
                case 2:
                    System.out.println("Inserisci il titolo del libro:");
                    String titoloLibro = myScannerString.nextLine();
                    System.out.println("Inserisci l'autore del libro:");
                    String autoreLibro = myScannerString.nextLine();
                    System.out.println("Inserisci l'anno di pubblicazione del libro:");
                    int annoLibro = myScannerInt.nextInt();
                    System.out.println("Inserisci il codice del libro:");
                    String codiceLibro = myScannerString.nextLine();
                    Risorsa nuovoLibro = new Libro(titoloLibro, autoreLibro, annoLibro, codiceLibro);
                    biblioteca.aggiungiRisorsa(nuovoLibro);
                    break;
                case 3:
                    System.out.println("Inserisci il numero della rivista:");
                    int numeroRivista = myScannerInt.nextInt();
                    System.out.println("Inserisci il titolo della rivista:");
                    String titoloRivista = myScannerString.nextLine();
                    System.out.println("Inserisci l'anno di pubblicazione della rivista:");
                    int annoRivista = myScannerInt.nextInt();
                    System.out.println("Inserisci il codice della rivista:");
                    String codiceRivista = myScannerString.nextLine();
                    Risorsa nuovaRivista = new Rivista(numeroRivista, titoloRivista, annoRivista, codiceRivista);
                    biblioteca.aggiungiRisorsa(nuovaRivista);
                    break;
                case 4:
                    System.out.println("Inserisci il formato dell'ebook:");
                    String formatoEbook = myScannerString.nextLine();
                    System.out.println("Inserisci il titolo dell'ebook:");
                    String titoloEbook = myScannerString.nextLine();
                    System.out.println("Inserisci l'anno di pubblicazione dell'ebook:");
                    int annoEbook = myScannerInt.nextInt();
                    System.out.println("Inserisci il codice dell'ebook:");
                    String codiceEbook = myScannerString.nextLine();
                    Risorsa nuovoEbook = new Ebook(formatoEbook, titoloEbook, annoEbook, codiceEbook);
                    biblioteca.aggiungiRisorsa(nuovoEbook);
                    break;
                case 5:
                    biblioteca.stampaRisorse();
                    break;
                case 6:
                    System.out.println("Quale utente deve prendere in prestito una risorsa?");
                    for (Utente utente : utenti) {
                        System.out.println("- " + utente.getNome());
                    }
                    String nomeUtentePrestito = myScannerString.nextLine();
                    Utente utentePrestito = null;
                    for (Utente utente : utenti) {
                        if (utente.trovaUtente(nomeUtentePrestito) != null) {
                            utentePrestito = utente;
                            break;
                        }
                    }
                    if (utentePrestito == null) {
                        System.out.println("Utente non trovato");
                    }

                    if (utentePrestito != null) {
                        System.out.println("Quale risorsa vuoi prendere in prestito?");
                        for (Risorsa risorsa : biblioteca.getRisorse()) {
                            System.out.println("- " + risorsa.getTitolo());
                        }
                        String titoloRisorsa = myScannerString.nextLine();
                        Risorsa risorsa = null;
                        for (Risorsa r : biblioteca.getRisorse()) { 
                            if (r.getTitolo().equalsIgnoreCase(titoloRisorsa)) {
                                risorsa = r;
                                break;
                            }
                        }
                        utentePrestito.prendiInPrestito(risorsa);
                        System.out.println("Risorsa " + risorsa.getTitolo() + " presa in prestito da " + utentePrestito.getNome());
                    } else {
                        System.out.println("Utente non trovato.");
                    }
                    break;
                case 7:
                    System.out.println("Quale utente deve restituire una risorsa?");
                    for (Utente utente : utenti) {
                        System.out.println("- " + utente.getNome());
                    }
                    String nomeUtenteRestituzione = myScannerString.nextLine();
                    Utente utenteRestituzione = null;
                    for (Utente utente : utenti) {
                        if (utente.trovaUtente(nomeUtenteRestituzione) != null) {
                            utenteRestituzione = utente;
                            break;
                        }else {
                            System.out.println("Utente non trovato");
                        }
                    }
                    if (utenteRestituzione != null) {
                        System.out.println("Quale risorsa vuoi restituire?");
                        String titoloRisorsaRestituzione = myScannerString.nextLine();
                        Risorsa risorsaRestituzione = null;
                        for (Risorsa r : biblioteca.getRisorse()) { 
                            if (r.getTitolo().equalsIgnoreCase(titoloRisorsaRestituzione)) {
                                risorsaRestituzione = r;
                                break;
                            }
                        }
                        risorsaRestituzione.prendiRisorsa(titoloRisorsaRestituzione);
                        utenteRestituzione.restituisci(risorsaRestituzione);
                    }else {
                        System.out.println("Utente non trovato.");
                    }
                    break;
                case 8:
                    loop = false;
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }while(loop);
    }
}
