public abstract class Risorsa {
    private String titolo;
    private int annoPubblicazione;
    private String codice;

    // Costruttore:
    public Risorsa(String titolo, int annoPubblicazione, String codice) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.codice = codice;
    }

    // Getter e setter:
    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public String getCodice() {
        return codice;
    }

    // Classe astratta che implementeranno le sottoclassi: Libro, Rivista, Ebook:
    public abstract String visualizzaDettagli();

    // Override del metodo ereditato dalla superclasse generica Object:
    @Override
    public String toString() {
        return visualizzaDettagli();
    }
}
