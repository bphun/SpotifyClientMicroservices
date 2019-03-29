package com.bphan.moviecatalogservice;

public class Rating {

    private String movieId;
    private int rating;

    public Rating() {}

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public int getRating() {
        return this.rating;
    }
}