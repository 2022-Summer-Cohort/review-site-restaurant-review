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

    @ManyToOne
    private Cuisine cuisine;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Restaurant(String name, String location, Cuisine cuisine, Hashtag... hashtags) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
        this.hashtags = Arrays.asList(hashtags);
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

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }
}
