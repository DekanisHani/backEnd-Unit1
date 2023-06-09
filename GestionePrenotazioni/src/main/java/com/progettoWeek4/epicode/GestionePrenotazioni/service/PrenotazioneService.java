package com.progettoWeek4.epicode.GestionePrenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Postazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.model.Prenotazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.model.Utente;
import com.progettoWeek4.epicode.GestionePrenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public boolean existsPrenotazione(LocalDate data, Postazione postazione) {
        return prenotazioneRepository.existsByDataAndPostazione(data, postazione);
    }

    public List<Prenotazione> getPrenotazioniByUtente(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }
}
