package com.progettoWeek4.epicode.GestionePrenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Postazione;
import com.progettoWeek4.epicode.GestionePrenotazioni.model.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificioCitta(TipoPostazione tipo, String citta);
}