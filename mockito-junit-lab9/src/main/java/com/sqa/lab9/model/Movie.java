package com.sqa.lab9.model;

/**
 * Movie model class
 * kriangkrai prasert
 * 663380616-4
 */
public class Movie {
    private String title;
    private String genre;
    private String playlist;

    public Movie(String title, String genre, String playlist) {
        this.title = title;
        this.genre = genre;
        this.playlist = playlist;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlaylist() {
        return playlist;
    }

    @Override
    public String toString() {
        return title;
    }
}
