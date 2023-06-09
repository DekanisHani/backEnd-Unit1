package com.progettoWeek4.epicode.GestionePrenotazioni.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Utente;
import com.progettoWeek4.epicode.GestionePrenotazioni.repository.UtenteRepository;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Optional<Utente> getUtenteByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }
}