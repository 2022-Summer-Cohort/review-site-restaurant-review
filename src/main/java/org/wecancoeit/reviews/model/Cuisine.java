package org.wecancoeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Cuisine {
    @Id
    @GeneratedValue
    private long id;
    private String foodType;
    private String location;

//    @OneToMany(mappedBy = "cuisine")
//    private Collection<Restaurant> restaurants;

    public Cuisine(String foodType, String location) {
        this.foodType = foodType;
//        this.restaurants = new ArrayList<>();
    }

    public Cuisine() {
    }

    public String getFoodType() {
        return foodType;
    }

//    public Collection<Restaurant> getRestaurants() {
//        return restaurants;
//    }
}
