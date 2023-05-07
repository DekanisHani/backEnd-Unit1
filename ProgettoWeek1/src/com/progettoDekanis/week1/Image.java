package com.progettoDekanis.week1;

public class Image extends MediaItem {
    private int luminosita;

    public Image(String titolo, int volume, int luminosita) {
        super(titolo, volume);
        this.luminosita = luminosita;
    }

    public void show() {
        System.out.println(this.titolo);
        String sequenzaLuminosità = "*".repeat(this.luminosita);
        System.out.println(sequenzaLuminosità);
    }

    public void aumentaLuminosita() {
        this.luminosita++;
    }

    public void diminuisciLuminosita() {
        this.luminosita--;
    }

	@Override
	public void play() {
		
	}
}

