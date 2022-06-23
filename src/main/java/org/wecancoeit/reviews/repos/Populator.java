package org.wecancoeit.reviews.repos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Cuisine;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.model.Review;

@Component
public class Populator implements CommandLineRunner {

    private ReviewRepository reviewRepo;
    private RestaurantRepository restaurantRepo;
    private CuisineRepository cuisineRepo;

    public Populator(ReviewRepository reviewRepo, RestaurantRepository restaurantRepo, CuisineRepository cuisineRepo) {
        this.reviewRepo = reviewRepo;
        this.restaurantRepo = restaurantRepo;
        this.cuisineRepo = cuisineRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Cuisine mexican = new Cuisine("Mexican", "Powell, Ohio");
        cuisineRepo.save(mexican);
        Cuisine italian = new Cuisine ("Italian", "Dublin, Ohio");
        cuisineRepo.save(italian);
        Cuisine mediterranean = new Cuisine("Mediterranean", "Columbus, Ohio");
        cuisineRepo.save(mediterranean);
        Cuisine asian = new Cuisine("Asian", "Dublin, Ohio");
        cuisineRepo.save(asian);

        Review best = new Review("Best");
        reviewRepo.save(best);
        Review good = new Review("Good");
        reviewRepo.save(good);
        Review fair = new Review("Fair");
        reviewRepo.save(fair);
        Review poor = new Review("Poor");
        reviewRepo.save(poor);

        Restaurant chileVerde = new Restaurant("Chile Verde",mexican, good);
        restaurantRepo.save(chileVerde);
        Restaurant theOliveGarden = new Restaurant("The Olive Garden",italian, best);
        restaurantRepo.save(theOliveGarden);
        Restaurant eatGreek = new Restaurant("Eat Greek",mediterranean, good);
        restaurantRepo.save(eatGreek);
        Restaurant pandaExpress = new Restaurant("Panda Express",mexican, poor);
        restaurantRepo.save(pandaExpress);

    }
}
