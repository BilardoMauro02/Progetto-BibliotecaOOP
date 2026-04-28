import java.util.ArrayList;

public class Utente {
    private String nome;
    private int idUtente;
    private static int contatoreUtente = 1;
    // Lista delle risorse prese in prestito:
    private ArrayList<Risorsa> prestiti = new ArrayList<>();

    // Costruttore:
    public Utente(String nome) {
        this.nome = nome;
        this.idUtente = contatoreUtente;
        contatoreUtente++;
    }

    public String getNome() {
        return nome;
    }

    public Utente trovaUtente(String utente) {
        if (this.nome.equalsIgnoreCase(utente)) {
            System.out.println("Utente trovato: " + this.nome);
            return this;
        } else {
            System.out.println("Utente non trovato");
            return null;
        }
    }

    // Metodo prendi in prestito:
    public void prendiInPrestito(Risorsa r) {
        prestiti.add(r);
    }

    // Metodo restituisci:
    public void restituisci(Risorsa r) {
        prestiti.remove(r);
    }

    public void stampaPrestiti() {
        System.out.println("Prestiti di " + nome);
        for (Risorsa risorsa : prestiti) {
            risorsa.visualizzaDettagli(); 
        }
    }
}
