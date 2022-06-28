package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;

@Controller
public class CuisineController {
    private CuisineRepository cuisineRepo;
    private RestaurantRepository restaurantRepo;

    public CuisineController(CuisineRepository cuisineRepo, RestaurantRepository restaurantRepo) {
        this.cuisineRepo = cuisineRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @RequestMapping("/")
    public String showAllCuisines(Model model) {
        model.addAttribute("cuisine", cuisineRepo.findAll());
        return "cuisines";
    }

    @RequestMapping("/location/{locationName}")
    public String showCuisinesByLocation(Model model, @PathVariable String locationName) {
        model.addAttribute("cuisines", cuisineRepo.findByLocationIgnoreCase(locationName));
        return "cuisines";
    }
}