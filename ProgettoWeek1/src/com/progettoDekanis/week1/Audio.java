package com.progettoDekanis.week1;

public class Audio extends MediaItem {
    private int durata;

    public Audio(String titolo, int volume, int durata) {
        super(titolo, volume);
        this.durata = durata;
    }

    public void play() {
        System.out.println(this.titolo);
        String sequenzaVolume = "!".repeat(this.volume);
        for (int i = 0; i < this.durata; i++) {
            System.out.println(sequenzaVolume);
        }
    }

	@Override
	public void show() {
		
	}
}

