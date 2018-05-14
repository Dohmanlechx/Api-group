package com.dohman.apigrupparbete;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by anandsingh on 28/12/16.
 */

public class MovieDetails {

    String title;
    String release_year;
    String plot;
    String language;
    String imageString;
    String genre;
    String country;
    String runtime;
    String producer;
    String imageUrl;
    double rating;

    public Bitmap getMovieBitmap() {
        return movieBitmap;
    }

    public void setMovieBitmap(Bitmap movieBitmap) {
        this.movieBitmap = movieBitmap;
    }

    Bitmap movieBitmap;


    public MovieDetails(String title, String release_year, String plot, String language, String imageString, String genre, String country, String runtime, String producer, double rating, String imageUrl) {
        this.title = title;
        this.release_year = release_year;
        this.plot = plot;
        this.language = language;
        this.imageString = imageString;
        this.genre = genre;
        this.country = country;
        this.runtime = runtime;
        this.producer = producer;
        this.rating = rating;
        this.imageUrl = imageUrl;
        //this.movieBitmap = movieBitmap;
    }

    public MovieDetails() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public void setImagePath(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {

        return this.imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
