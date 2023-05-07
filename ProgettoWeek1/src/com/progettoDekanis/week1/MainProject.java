package com.progettoDekanis.week1;

import java.util.Scanner;

public class MainProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Multimedia[] elements = new Multimedia[5];

        
        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci il tipo di elemento multimediale (1=Immagine, 2=Video, 3=RegistrazioneAudio): ");
            int type = input.nextInt();
            input.nextLine(); 
            System.out.print("Inserisci il titolo: ");
            String titolo = input.nextLine();

            switch (type) {
                case 1:
                    System.out.print("Inserisci la luminosita': ");
                    int luminosita = input.nextInt();
                    input.nextLine(); 
                    elements[i] = new Image(titolo, luminosita, luminosita);
                    break;
                case 2:
                    System.out.print("Inserisci la durata in secondi: ");
                    int durata = input.nextInt();
                    input.nextLine(); 
                    System.out.print("Inserisci il volume: ");
                    int volume = input.nextInt();
                    input.nextLine(); 
                    elements[i] = new Video(titolo, durata, volume, 0);
                    break;
                case 3:
                    System.out.print("Inserisci la durata in secondi: ");
                    durata = input.nextInt();
                    input.nextLine(); 
                    System.out.print("Inserisci il volume: ");
                    volume = input.nextInt();
                    input.nextLine(); 
                    elements[i] = new Audio(titolo, durata, volume);
                    break;
                default:
                    System.out.println("Tipo non valido.");
                    i--; 
            }
        }
    }
}

