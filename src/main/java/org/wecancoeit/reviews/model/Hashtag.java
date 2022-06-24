package org.wecancoeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String name;
//    @ManyToMany(mappedBy = "hashtags")
//    private Collection<Restaurant> restaurants;

    public Hashtag(String name) {
        this.name = name;
    }

    public Hashtag() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Collection<Restaurant> getRestaurants() {
//        return restaurants;
//    }
}
