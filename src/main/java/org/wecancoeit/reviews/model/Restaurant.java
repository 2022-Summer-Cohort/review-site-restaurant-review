package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    // other fields for classification?
    @ManyToOne
    private Cuisine cuisine;
    @ManyToMany
    private Collection<Review> reviews;

    public Restaurant(String name, Cuisine cuisine, Review... reviews) {
        this.name = name;
        this.cuisine = cuisine;
        this.reviews = Arrays.asList(reviews);
    }

    public Restaurant() {
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
