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

    public Risorsa prendiRisorsa(String titolo) {
        if (this.titolo.equalsIgnoreCase(titolo)) {
            return this;
        }
        return null;
    }

    // Classe astratta che implementeranno le sottoclassi: Libro, Rivista, Ebook:
    public abstract void visualizzaDettagli();
}
