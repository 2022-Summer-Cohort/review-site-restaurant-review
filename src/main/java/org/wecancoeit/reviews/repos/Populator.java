package org.wecancoeit.reviews.repos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Cuisine;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.model.Review;

@Component
public class Populator implements CommandLineRunner {

    private ReviewRepository reviewRepo;
    private RestaurantRepository restaurantRepo;
    private CuisineRepository cuisineRepo;
    private HashtagRepository hashtagRepo;

    public Populator(ReviewRepository reviewRepo, RestaurantRepository restaurantRepo, CuisineRepository cuisineRepo, HashtagRepository hashtagRepo) {
        this.reviewRepo = reviewRepo;
        this.restaurantRepo = restaurantRepo;
        this.cuisineRepo = cuisineRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //All objects are just for the sake of orientation and can/will be changed

        Cuisine mexican = new Cuisine("Mexican", "Powell, Ohio");
        cuisineRepo.save(mexican);
        Cuisine italian = new Cuisine ("Italian", "Columbus, Ohio");
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

        Restaurant chileVerde = new Restaurant("Chile Verde", "Powell, Ohio", mexican, good);
        restaurantRepo.save(chileVerde);
        Restaurant theOliveGarden = new Restaurant("The Olive Garden", "Columbus, Ohio", italian, best);
        restaurantRepo.save(theOliveGarden);
        Restaurant eatGreek = new Restaurant("Eat Greek", "columbus, Ohio", mediterranean,  good);
        restaurantRepo.save(eatGreek);
        Restaurant blueGinger = new Restaurant("Blue Ginger", "Dublin, Ohio", mexican, poor);
        restaurantRepo.save(blueGinger);

        Hashtag bestInColumbus = new Hashtag("#BestInColumbus");
        hashtagRepo.save(bestInColumbus);
        Hashtag poorService = new Hashtag("#PoorService");
        hashtagRepo.save(poorService);
        Hashtag bestService = new Hashtag("#BestService");
        hashtagRepo.save(bestService);
        Hashtag greatTakeOut = new Hashtag("#GreatTakeOut");
        hashtagRepo.save(greatTakeOut);


    }
}
