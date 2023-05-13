package progetto.week2.epicode;

public class Libro implements ElementoCatalogo {
    private long isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private String autore;
    private String genere;
    
    public Libro(long isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genere;
    }
    
    @Override
    public long getISBN() {
        return isbn;
    }
    
    @Override
    public String getTitolo() {
        return titolo;
    }
    
    @Override
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    
    @Override
    public int getNumeroPagine() {
        return numeroPagine;
    }
    
    public String getAutore() {
        return autore;
    }
    
    public String getGenere() {
        return genere;
    }
}
