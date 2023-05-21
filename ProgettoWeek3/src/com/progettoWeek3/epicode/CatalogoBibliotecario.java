package com.progettoWeek3.epicode;

import javax.persistence.*;
import java.util.List;

public class CatalogoBibliotecario {
    private EntityManagerFactory emf;
    
    public CatalogoBibliotecario() {
        emf = Persistence.createEntityManagerFactory("biblioteca");
    }
    
    public void aggiungiElemento(Elemento elemento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            em.persist(elemento);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public void rimuoviElemento(String codiceISBN) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            Elemento elemento = em.find(Elemento.class, codiceISBN);
            if (elemento != null) {
                em.remove(elemento);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public Elemento ricercaPerISBN(String codiceISBN) {
        EntityManager em = emf.createEntityManager();
        Elemento elemento = em.find(Elemento.class, codiceISBN);
        em.close();
        return elemento;
    }
    
    public List<Elemento> ricercaPerAnnoPubblicazione(int annoPubblicazione) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Elemento> query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno", Elemento.class);
        query.setParameter("anno", annoPubblicazione);
        List<Elemento> risultati = query.getResultList();
        em.close();
        return risultati;
    }
    
    public List<Elemento> ricercaPerAutore(String autore) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Elemento> query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.autore = :autore", Elemento.class);
        query.setParameter("autore", autore);
        List<Elemento> risultati = query.getResultList();
        em.close();
        return risultati;
    }
    
    public List<Elemento> ricercaPerTitolo(String titolo) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Elemento> query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo", Elemento.class);
        query.setParameter("titolo", "%" + titolo + "%");
        List<Elemento> risultati = query.getResultList();
        em.close();
        return risultati;
    }
    
    public List<Prestito> ricercaPrestitiUtente(String numeroTessera) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :tessera", Prestito.class);
        query.setParameter("tessera", numeroTessera);
        List<Prestito> risultati = query.getResultList();
        em.close();
        return risultati;
    }
    
    public List<Prestito> ricercaPrestitiScadutiNonRestituiti() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class);
        List<Prestito> risultati = query.getResultList();
        em.close();
        return risultati;
    }
    
    public void chiudi() {
        emf.close();
    }
}

