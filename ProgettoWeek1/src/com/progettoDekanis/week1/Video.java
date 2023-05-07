package com.progettoDekanis.week1;

public class Video extends MediaItem {
    private int durata;
    private int luminosita;

    public Video(String titolo, int volume, int durata, int luminosita) {
        super(titolo, volume);
        this.durata = durata;
        this.luminosita = luminosita;
    }

    public void play() {
        System.out.println(this.titolo);
        String sequenzaVolume = "!".repeat(this.volume);
        String sequenzaLuminosita = "*".repeat(this.luminosita);
        for (int i = 0; i < this.durata; i++) {
            System.out.println(sequenzaVolume + sequenzaLuminosita);
        }
    }

    public void aumentaLuminosita() {
        this.luminosita++;
    }

    public void diminuisciLuminosita() {
        this.luminosita--;
    }

	@Override
	public void show() {
		
	}
}

