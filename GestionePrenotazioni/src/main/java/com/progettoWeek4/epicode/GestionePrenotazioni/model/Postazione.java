package com.progettoWeek4.epicode.GestionePrenotazioni.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String descrizione;
    private TipoPostazione tipo;
    private int numeroMassimoOccupanti;

    @ManyToOne
    private Edificio edificio;

	public Postazione(Long id, String codice, String descrizione, TipoPostazione tipo, int numeroMassimoOccupanti,
			Edificio edificio) {
		super();
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.numeroMassimoOccupanti = numeroMassimoOccupanti;
		this.edificio = edificio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoPostazione getTipo() {
		return tipo;
	}

	public void setTipo(TipoPostazione tipo) {
		this.tipo = tipo;
	}

	public int getNumeroMassimoOccupanti() {
		return numeroMassimoOccupanti;
	}

	public void setNumeroMassimoOccupanti(int numeroMassimoOccupanti) {
		this.numeroMassimoOccupanti = numeroMassimoOccupanti;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

}
