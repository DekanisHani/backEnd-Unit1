package progetto.week2.epicode;

public class Rivista implements ElementoCatalogo {
    private long isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private Periodicita periodicita;
    
    public Rivista(long isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicità) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicità;
    }
    
    public Rivista(long isbn2, String titolo2, int annoPubblicazione2, int numeroPagine2, String periodicità) {
		// TODO Auto-generated constructor stub
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
    
    public Periodicita getPeriodicita() {
        return periodicita;
    }
}
