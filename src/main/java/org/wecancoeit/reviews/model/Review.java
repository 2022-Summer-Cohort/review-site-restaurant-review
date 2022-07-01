package org.wecancoeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;
    private String rating;

    @ManyToMany(mappedBy = "reviews")
    private Collection<Restaurant> restaurants;

    public Review(String rating) {
        this.rating = rating;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public Collection<Restaurant> getRestaurants() {
        return restaurants;
    }
}
