import java.util.ArrayList;

public class Utente {
    private String nome;
    private String idUtente;
    // Lista delle risorse prese in prestito:
    private ArrayList<Risorsa> prestiti = new ArrayList<>();

    // Costruttore:
    public Utente(String nome, String idUtente) {
        this.nome = nome;
        this.idUtente = idUtente;
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
