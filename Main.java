import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bibiloteca biblioteca = new Bibiloteca("Biblioteca Centrale");

        boolean running = true;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Aggiungi Rivista");
            System.out.println("3. Aggiungi Ebook");
            System.out.println("4. Aggiungi Utente");
            System.out.println("5. Prestito Risorsa");
            System.out.println("6. Restituzione Risorsa");
            System.out.println("7. Stampa Risorse");
            System.out.println("8. Stampa Prestiti Utente");
            System.out.println("9. Cerca Risorsa per titolo");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();             //pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.print("Titolo: ");
                    String titoloL = scanner.nextLine();

                    System.out.print("Anno: ");
                    int annoL = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice: ");
                    String codiceL = scanner.nextLine();

                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();

                    biblioteca.aggiungiRisorsa(new Libro(autore, titoloL, annoL, codiceL));
                    break;

                case 2:
                    System.out.print("Titolo: ");
                    String titoloR = scanner.nextLine();

                    System.out.print("Anno: ");
                    int annoR = scanner.nextInt();

                    System.out.print("Numero rivista: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice: ");
                    String codiceR = scanner.nextLine();

                    biblioteca.aggiungiRisorsa(new Rivista(numero, titoloR, annoR, codiceR));
                    break;

                case 3:
                    System.out.print("Titolo: ");
                    String titoloE = scanner.nextLine();

                    System.out.print("Anno: ");
                    int annoE = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice: ");
                    String codiceE = scanner.nextLine();

                    System.out.print("Formato: ");
                    String formato = scanner.nextLine();

                    biblioteca.aggiungiRisorsa(new Ebook(formato, titoloE, annoE, codiceE));
                    break;

                case 4:
                    System.out.print("Nome utente: ");
                    String nome = scanner.nextLine();

                    biblioteca.aggiungiUtente(new Utente(nome));
                    break;

                case 5:
                    System.out.print("Titolo risorsa da prestare: ");
                    String titoloPrestito = scanner.nextLine();

                    System.out.print("Nome utente: ");
                    String nomeUtente = scanner.nextLine();

                    Risorsa risorsaDaPrestare = trovaRisorsa(biblioteca, titoloPrestito);
                    Utente utentePrestito = trovaUtente(biblioteca, nomeUtente);

                    if (risorsaDaPrestare != null && utentePrestito != null) {
                        utentePrestito.prendiInPrestito(risorsaDaPrestare);
                    } else {
                        System.out.println("Errore: risorsa o utente non trovato");
                    }
                    break;

                case 6:
                    System.out.print("Titolo risorsa da restituire: ");
                    String titoloRest = scanner.nextLine();

                    System.out.print("Nome utente: ");
                    String nomeRest = scanner.nextLine();

                    Risorsa risorsaRest = trovaRisorsa(biblioteca, titoloRest);
                    Utente utenteRest = trovaUtente(biblioteca, nomeRest);

                    if (risorsaRest != null && utenteRest != null) {
                        utenteRest.restituisci(risorsaRest);
                    } else {
                        System.out.println("Errore: risorsa o utente non trovato");
                    }
                    break;

                case 7:
                    biblioteca.stampaRisorse();
                    break;

                case 8:
                    System.out.print("Nome utente: ");
                    String nomeStampa = scanner.nextLine();

                    Utente u = trovaUtente(biblioteca, nomeStampa);
                    if (u != null) {
                        u.stampaPrestiti();
                    } else {
                        System.out.println("Utente non trovato");
                    }
                    break;

                case 9:
                    System.out.print("Titolo da cercare: ");
                    String titolo = scanner.nextLine();
                    biblioteca.stampaRisorsa(titolo);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (running);

        scanner.close();
    }

    // Metodi statici:
    public static Risorsa trovaRisorsa(Bibiloteca biblioteca, String titolo) {
        for (Risorsa risorsa : biblioteca.getRisorse()) {
            if (risorsa.getTitolo().equalsIgnoreCase(titolo)) {
                return risorsa;
            }
        }
        return null;
    }

    public static Utente trovaUtente(Bibiloteca biblioteca, String nome) {
        for (Utente utente : biblioteca.getUtenti()) {
            if (utente.getNome().equalsIgnoreCase(nome)) {
                return utente;
            }
        }
        return null;
    }
}
