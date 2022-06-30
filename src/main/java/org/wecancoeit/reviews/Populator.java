package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Cuisine;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

        Cuisine mexican = new Cuisine("Mexican", "/images/mexicanfood.jpg");
        cuisineRepo.save(mexican);
        Cuisine italian = new Cuisine("Italian", "/images/italianfood.jpg");
        cuisineRepo.save(italian);
        Cuisine mediterranean = new Cuisine("Mediterranean", "/images/mediterraneanfood.jpeg");
        cuisineRepo.save(mediterranean);
        Cuisine asian = new Cuisine("Asian", "/images/asianfood.jpg");
        cuisineRepo.save(asian);

        Review best = new Review("Best");
        reviewRepo.save(best);
        Review good = new Review("Good");
        reviewRepo.save(good);
        Review fair = new Review("Fair");
        reviewRepo.save(fair);
        Review poor = new Review("Poor");
        reviewRepo.save(poor);

        Hashtag bestInColumbus = new Hashtag("#BestInColumbus");
        hashtagRepo.save(bestInColumbus);
        Hashtag poorService = new Hashtag("#PoorService");
        hashtagRepo.save(poorService);
        Hashtag bestService = new Hashtag("#BestService");
        hashtagRepo.save(bestService);
        Hashtag greatTakeOut = new Hashtag("#GreatTakeOut");
        hashtagRepo.save(greatTakeOut);

        List<Hashtag> testArrayList1 = new ArrayList<>();
        testArrayList1.add(bestInColumbus);
        List<Hashtag> testArrayList2 = new ArrayList<>();
        testArrayList1.add(poorService);
        List<Hashtag> testArrayList3 = new ArrayList<>();
        testArrayList1.add(greatTakeOut);

        Restaurant chileVerde = new Restaurant("Chile Verde", "Powell, Ohio", mexican, testArrayList1, best);
        restaurantRepo.save(chileVerde);
        Restaurant theOliveGarden = new Restaurant("The Olive Garden", "Columbus, Ohio", italian, testArrayList2, best);
        restaurantRepo.save(theOliveGarden);
        Restaurant eatGreek = new Restaurant("Eat Greek", "columbus, Ohio", mediterranean, testArrayList3, good);
        restaurantRepo.save(eatGreek);
        Restaurant blueGinger = new Restaurant("Blue Ginger", "Dublin, Ohio", mexican, testArrayList1, poor);
        restaurantRepo.save(blueGinger);

    }
}
