package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;

import java.util.Optional;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantRepository restaurantRepo;
    private HashtagRepository hashtagRepo;

    public RestaurantController(RestaurantRepository restaurantRepo, HashtagRepository hashtagRepo) {
        this.restaurantRepo = restaurantRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/{id}")
    public String showRestaurant(Model model, @PathVariable Long id) {
        model.addAttribute("whatEverIwant", restaurantRepo.findById(id).get());
        return "restaurant";
    }

    @RequestMapping("/")
    public String showAllRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantRepo.findAll());
        return "allRestaurants";
    }

    @PostMapping("/{id}/addHashtag")
    public String addHashtagToRestaurant(@PathVariable Long id, @RequestParam String hashtag) {
        Restaurant restaurant = restaurantRepo.findById(id).get();
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByNameIgnoreCase(hashtag);
        if (hashtagOptional.isPresent()) {
            if (!restaurant.getHashtags().contains(hashtagOptional.get())) {
                restaurant.addHashtag(hashtagOptional.get());
            }
        } else {
            Hashtag hashtag1 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag1);
            restaurant.addHashtag(hashtag1);
        }
        restaurantRepo.save(restaurant);

        return "redirect:/restaurant/"+id;
    }
}