package com.progettoWeek3.epicode;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Elemento {
    @Id
    protected String codiceISBN;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;
	public String getCodiceISBN() {
		return codiceISBN;
	}
	
	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	

    // Costruttori, getter e setter
    
}

