package com.progettoWeek3.epicode;

import javax.persistence.Entity;

@Entity
public class Libro extends Elemento {
    private String autore;
    private String genere;

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	
    
    
}

