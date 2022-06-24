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
    private String location;
    @ManyToOne
    private Cuisine cuisine;
    @ManyToMany
    private Collection<Review> reviews;

    public Restaurant(String name, String location, Cuisine cuisine, Review... reviews) {
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
