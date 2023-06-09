package com.progettoWeek4.epicode.GestionePrenotazioni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Postazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.model.TipoPostazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> getPostazioniByTipoAndCitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificioCitta(tipo, citta);
    }
}
