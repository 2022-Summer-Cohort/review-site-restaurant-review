package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Cuisine;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class Populator implements CommandLineRunner {

    private RestaurantRepository restaurantRepo;
    private CuisineRepository cuisineRepo;
    private HashtagRepository hashtagRepo;

    public Populator(RestaurantRepository restaurantRepo, CuisineRepository cuisineRepo, HashtagRepository hashtagRepo) {
        this.restaurantRepo = restaurantRepo;
        this.cuisineRepo = cuisineRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Cuisine mexican = new Cuisine("Mexican", "Powell, Ohio");
        cuisineRepo.save(mexican);
        Cuisine italian = new Cuisine ("Italian", "Columbus, Ohio");
        cuisineRepo.save(italian);

        Hashtag bestInColumbus = new Hashtag("#BestInColumbus");
        hashtagRepo.save(bestInColumbus);
        Hashtag poorService = new Hashtag("#PoorService");
        hashtagRepo.save(poorService);
        Hashtag bestService = new Hashtag("#BestService");
        hashtagRepo.save(bestService);
        Hashtag greatTakeOut = new Hashtag("#GreatTakeOut");
        hashtagRepo.save(greatTakeOut);

        Restaurant restaurant1 = new Restaurant("Olive Garden", "Columbus", italian, bestInColumbus, bestService);
        restaurantRepo.save(restaurant1);
        Restaurant restaurant2 = new Restaurant("Taco Bell", "Columbus", mexican, poorService, greatTakeOut);
        restaurantRepo.save(restaurant2);
    }
}
