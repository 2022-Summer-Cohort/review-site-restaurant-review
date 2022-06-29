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
        model.addAttribute("cuisines", cuisineRepo.findAll());
        return "cuisines";
    }

    @RequestMapping("/cuisines/{id}")
    public String findByID(Model model, @PathVariable long id) {
        model.addAttribute("cuisine", cuisineRepo.findById(id).get());
        return "cuisine";
    }
}