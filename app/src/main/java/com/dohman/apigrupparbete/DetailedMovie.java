package com.dohman.apigrupparbete;

public class DetailedMovie {

    private String releaseYear;
    private String title;
    private double rating;
    private String genre;
    private int runtime;
    private String plot;
    private String countryOfOrigin;
    private String spokenLanguage;
    private String poster;

    public DetailedMovie(String releaseYear, String title, double rating, String genre, int runtime, String plot, String countryOfOrigin, String spokenLanguage, String poster) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.runtime = runtime;
        this.plot = plot;
        this.countryOfOrigin = countryOfOrigin;
        this.spokenLanguage = spokenLanguage;
        this.poster = poster;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getSpokenLanguage() {
        return spokenLanguage;
    }

    public void setSpokenLanguage(String spokenLanguage) {
        this.spokenLanguage = spokenLanguage;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
