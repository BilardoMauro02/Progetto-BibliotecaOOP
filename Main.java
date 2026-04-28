public class Main {
    
    public static void main(String[] args) {

        Bibiloteca biblioteca = new Bibiloteca("Biblioteca Centrale");
        Risorsa l1 = new Libro("Orwell", "1984", 1949, "Orwell");
        Risorsa r1 = new Rivista(120, "Rivista Focus", 2023, "EPUB");
        Risorsa e1 = new Ebook("PDF", "Java Guide", 2022, "E1");

        biblioteca.aggiungiRisorsa(l1);
        biblioteca.aggiungiRisorsa(r1);
        biblioteca.aggiungiRisorsa(e1);

        Utente u1 = new Utente("Mario");
        Utente u2 = new Utente("Luigi");

        // Prestiti
        u1.prendiInPrestito(l1);
        u1.prendiInPrestito(e1);

        u2.prendiInPrestito(r1);
        u2.prendiInPrestito(l1);

        // Stampe
        biblioteca.stampaRisorse();

        u1.stampaPrestiti();
        u2.stampaPrestiti();

        // Restituzione
        u1.restituisci(l1);

        System.out.println("\nDopo restituzione:");
        biblioteca.stampaRisorse();

        System.out.println("------------------------");
        System.out.println(u1.getIdUtente());
        System.out.println(u2.getIdUtente());
    }
}
