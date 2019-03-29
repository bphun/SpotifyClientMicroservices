package com.bphan.movieinfoservice;

public class Movie {

    private String movieId;
    private String movieDesc;
    private String name;

    public Movie() {}

    public Movie(String movieId, String movieDesc, String name) {
        this.movieId = movieId;
        this.movieDesc = movieDesc;
        this.name = name;
    }

    public String getMovieId() {
        return this.movieId;
    }
    
    public String getMovieDesc() {
        return this.movieDesc;
    }

    public String getName() {
        return this.name;
    }
}