package com.bphan.moviecatalogservice;

import java.util.List;

public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public UserRating() {}

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserRating(List<Rating> ratings, String userId) {
        this.ratings = ratings;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}