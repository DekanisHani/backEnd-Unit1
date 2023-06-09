package com.progettoWeek4.epicode.GestionePrenotazioni.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne
    private Postazione postazione;

    @ManyToOne
    private Utente utente;

	public Prenotazione(Long id, LocalDate data, Postazione postazione, Utente utente) {
		super();
		this.id = id;
		this.data = data;
		this.postazione = postazione;
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Postazione getPostazione() {
		return postazione;
	}

	public void setPostazione(Postazione postazione) {
		this.postazione = postazione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}