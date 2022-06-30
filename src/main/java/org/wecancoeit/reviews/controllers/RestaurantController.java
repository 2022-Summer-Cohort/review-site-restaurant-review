package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repos.RestaurantRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

import java.util.Optional;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private ReviewRepository reviewRepo;
    private RestaurantRepository restaurantRepo;

    public RestaurantController(ReviewRepository reviewRepo, RestaurantRepository restaurantRepo) {
        this.reviewRepo = reviewRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @RequestMapping("/{id}")
    public String showRestaurant(Model model, @PathVariable Long id){
        model.addAttribute("LosGuachos", restaurantRepo.findById(id).get());
        return "restaurant";
    }

    @RequestMapping("/")
    public String showAllRestaurants(Model model){
        model.addAttribute("restaurants", restaurantRepo.findAll());
        return "allRestaurants";
    }
    @RequestMapping("/restaurants/{id}") //remove if doesnt work
    public String findByID(Model model, @PathVariable long id) {
        model.addAttribute("cuisine", restaurantRepo.findById(id).get());
        return "restaurant";
    }
    @PostMapping("/{id}/addReview")
    public String addReviewToRestaurant(@PathVariable Long id, @RequestParam String review) {
        Restaurant restaurant = restaurantRepo.findById(id).get();
        Optional<Review> reviewOptional = reviewRepo.findByRatingIgnoreCase(review);
        if (!reviewOptional.isPresent()) {
            if (!restaurant.getReviews().contains(reviewOptional.get())) {
                 restaurant.addReview(reviewOptional.get());
            }
        }
        else {
            Review review1 = new Review(review);
            reviewRepo.save(review1);
            restaurant.addReview(review1);
        }
        restaurantRepo.save(restaurant);
        return "redirect:/restaurants/"+id;
    }
}
