package com.progettoWeek4.epicode.GestionePrenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Postazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.model.Prenotazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.model.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDataAndPostazione(LocalDate data, Postazione postazione);
    List<Prenotazione> findByUtente(Utente utente);
}
