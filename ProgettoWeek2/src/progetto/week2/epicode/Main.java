package progetto.week2.epicode;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        boolean continua = true;
        while (continua) {
            System.out.println("Scegli un'operazione:");
            System.out.println("1. Aggiunta di un elemento");
            System.out.println("2. Rimozione di un elemento");
            System.out.println("3. Ricerca per ISBN");
            System.out.println("4. Ricerca per anno di pubblicazione");
            System.out.println("5. Ricerca per autore");
            System.out.println("6. Salvataggio su disco dell'archivio");
            System.out.println("7. Caricamento dal disco dell'archivio");
            System.out.println("0. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    // Aggiunta di un elemento
                    System.out.println("Inserisci i dati dell'elemento:");
                    System.out.println("Codice ISBN:");
                    long isbn = scanner.nextLong();
                    scanner.nextLine(); 
                    System.out.println("Titolo:");
                    String titolo = scanner.nextLine();
                    System.out.println("Anno di pubblicazione:");
                    int annoPubblicazione = scanner.nextInt();
                    System.out.println("Numero pagine:");
                    int numeroPagine = scanner.nextInt();
                    scanner.nextLine(); 

                    ElementoCatalogo elemento;
                    System.out.println("L'elemento è un libro o una rivista? (L/R)");
                    String tipoElemento = scanner.nextLine();
                    if (tipoElemento.equalsIgnoreCase("L")) {
                        System.out.println("Autore:");
                        String autore = scanner.nextLine();
                        System.out.println("Genere:");
                        String genere = scanner.nextLine();
                        elemento = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
                    } else if (tipoElemento.equalsIgnoreCase("R")) {
                        System.out.println("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE):");
                        String periodicità = scanner.nextLine();
                        elemento = new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicità);
                    } else {
                        System.out.println("Tipo di elemento non valido.");
                        continue;
                    }

                    archivio.aggiungiElemento(elemento);
                    System.out.println("Elemento aggiunto con successo.");
                    break;
                case 2:
                    // Rimozione di un elemento
                    System.out.println("Inserisci il codice ISBN dell'elemento da rimuovere:");
                    long isbnRimozione = scanner.nextLong();
                    scanner.nextLine(); 

                    archivio.rimuoviElemento(isbnRimozione);
                    System.out.println("Elemento rimosso con successo.");
                    break;
                    case 3:
                    // Ricerca per ISBN
                    System.out.println("Inserisci il codice ISBN da cercare:");
                    long isbnRicerca = scanner.nextLong();
                    scanner.nextLine(); 

                    Optional<ElementoCatalogo> risultatoISBN = archivio.ricercaPerISBN(isbnRicerca);
                    if (risultatoISBN.isPresent()) {
                    System.out.println("Risultato:");
                    System.out.println(risultatoISBN.get());
                    } else {
                    System.out.println("Nessun elemento trovato per il codice ISBN specificato.");
                    }
                    break;
                    case 4:
                    // Ricerca per anno di pubblicazione
                    System.out.println("Inserisci l'anno di pubblicazione da cercare:");
                    int annoRicerca = scanner.nextInt();
                    scanner.nextLine(); 

                    List<ElementoCatalogo> risultatiAnno = archivio.ricercaPerAnnoPubblicazione(annoRicerca);
                    if (!risultatiAnno.isEmpty()) {
                    System.out.println("Risultati:");
                    for (ElementoCatalogo elemento1 : risultatiAnno) {
                    System.out.println(elemento1);
                    }
                    } else {
                    System.out.println("Nessun elemento trovato per l'anno di pubblicazione specificato.");
                    }
                    break;
                    case 5:
                    // Ricerca per autore
                    System.out.println("Inserisci l'autore da cercare:");
                    String autoreRicerca = scanner.nextLine();

                    List<ElementoCatalogo> risultatiAutore = archivio.ricercaPerAutore(autoreRicerca);
                    if (!risultatiAutore.isEmpty()) {
                    System.out.println("Risultati:");
                    for (ElementoCatalogo elemento1 : risultatiAutore) {
                    System.out.println(elemento1);
                    }
                    } else {
                    System.out.println("Nessun elemento trovato per l'autore specificato.");
                    }
                    break;
                    case 6:
                    // Salvataggio su disco dell'archivio
                    archivio.salvataggioSuDisco();
                    System.out.println("Archivio salvato su disco.");
                    break;
                    case 7:
                    // Caricamento dal disco dell'archivio
                    archivio.caricamentoDalDisco();
                    System.out.println("Archivio caricato dal disco.");
                    break;
                    case 0:
                    // Esci
                    continua = false;
                    break;
                    default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
               }
           }

                    scanner.close();
       }
}

