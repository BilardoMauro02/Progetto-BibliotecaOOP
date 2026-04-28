import java.util.ArrayList;

public class Bibiloteca{
    private String name;
    private ArrayList<Risorsa> risorse;
    private ArrayList<Utente> utenti;

    public Bibiloteca(String name) {
        this.name = name;
        this.risorse = new ArrayList<>();
        this.utenti = new ArrayList<>();
    }

    public void aggiungiRisorsa(Risorsa r) {
        risorse.add(r);
    }

    public void aggiungiUtente(Utente u) {
        utenti.add(u);
    }

    public ArrayList<Risorsa> getRisorse() {
        return risorse;
    }

    public void stampaRisorse() {
        System.out.println("Risorse disponibili in " + name);
        for (Risorsa risorsa : risorse) {
            risorsa.visualizzaDettagli();
        }
    }

    public void stampaRisorsa(String titolo) {
        boolean exist = false;
        for (Risorsa risorsa : risorse) {
            if (risorsa.getTitolo().equalsIgnoreCase(titolo)) {
                risorsa.visualizzaDettagli();
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("Risorsa non trovata");
        }
    }
}
