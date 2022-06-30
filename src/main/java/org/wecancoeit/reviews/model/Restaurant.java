package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String location;
    private String imgUrl;

    @ManyToOne
    private Cuisine cuisine;
    @ManyToMany
    private List<Hashtag> hashtags;
    @ManyToMany
    private Collection<Review> reviews;

    public Restaurant(String name, String location, String imgUrl, Cuisine cuisine, List<Hashtag> hashtags, Review... reviews) {
        this.name = name;
        this.location = location;
        this.imgUrl = imgUrl;
        this.cuisine = cuisine;
        this.hashtags = hashtags;
        this.reviews = Arrays.asList(reviews);
    }

    public Restaurant() {
    }

    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }
    public Collection<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
    }
}
