public class Libro {
    private String autore extends Risorsa;

    public Libro(String autore, String titolo, int annoPubblicazione, String codice) {
        super(titolo, annoPubblicazione, codice);
        this.autore = autore;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    @Override
    public String visualizzaDettagli() {
        return super.visualizzaDettagli() + " - Autore: " + this.autore;
    }
}