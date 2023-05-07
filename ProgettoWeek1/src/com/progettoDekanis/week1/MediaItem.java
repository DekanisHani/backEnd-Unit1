package com.progettoDekanis.week1;

public abstract class MediaItem implements Multimedia {
    protected String titolo;
    protected int volume;

    public MediaItem(String titolo, int volume) {
        this.titolo = titolo;
        this.volume = volume;
    }

    public String getTitle() {
        return this.titolo;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void increaseVolume() {
        this.volume++;
    }

    public void decreaseVolume() {
        this.volume--;
    }

	public String getTitolo() {
		return null;
	}
}

