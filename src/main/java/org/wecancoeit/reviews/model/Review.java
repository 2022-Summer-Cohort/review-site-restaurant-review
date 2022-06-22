package org.wecancoeit.reviews.model;

import javax.annotation.processing.Generated;
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
    private String name;
    @ManyToMany(mappedBy = "reviews")
    private Collection<Restaurant> restaurants;

    public Review(String name) {
        this.name = name;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Restaurant> getRestaurants() {
        return restaurants;
    }
}
