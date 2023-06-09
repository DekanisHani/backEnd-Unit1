package com.progettoWeek4.epicode.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettoWeek4.epicode.GestionePrenotazioni.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
