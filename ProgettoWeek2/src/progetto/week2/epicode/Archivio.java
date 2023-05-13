package progetto.week2.epicode;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archivio {
    private List<ElementoCatalogo> catalogo;

    public Archivio() {
        catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(long isbn) {
        catalogo.removeIf(e -> e.getISBN() == isbn);
    }

    public Optional<ElementoCatalogo> ricercaPerISBN(long isbn) {
        return catalogo.stream()
                .filter(e -> e.getISBN() == isbn)
                .findFirst();
    }

    public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<ElementoCatalogo> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(e -> e instanceof Libro)
                .filter(e -> ((Libro) e).getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    public void salvataggioSuDisco() {
        File file = new File("archivio.dat");
        try {
            FileUtils.writeLines(file, catalogo.stream()
                    .map(e -> e.getISBN() + ";" + e.getTitolo() + ";" + e.getAnnoPubblicazione() + ";" + e.getNumeroPagine() + (e instanceof Libro ? ";" + ((Libro) e).getAutore() + ";" + ((Libro) e).getGenere() : ";" + ((Rivista) e).getPeriodicita()))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricamentoDalDisco() {
        File file = new File("archivio.dat");
        try {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            catalogo.clear();
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    long isbn = Long.parseLong(parts[0]);
                    String titolo = parts[1];
                    int annoPubblicazione = Integer.parseInt(parts[2]);
                    int numeroPagine = Integer.parseInt(parts[3]);
                    if (parts.length == 6) {
                        String autore = parts[4];
                        String genere = parts[5];
                        catalogo.add(new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere));
                    } else if (parts.length == 5) {
                        Periodicita periodicita = Periodicita.valueOf(parts[4]);
                        catalogo.add(new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicita));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
