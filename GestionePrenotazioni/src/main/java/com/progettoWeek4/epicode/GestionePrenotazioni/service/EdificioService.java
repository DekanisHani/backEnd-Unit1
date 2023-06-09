package com.progettoWeek4.epicode.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Edificio;
import com.progettoWeek4.epicode.GestionePrenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public List<Edificio> getAllEdifici() {
        return edificioRepository.findAll();
    }
}