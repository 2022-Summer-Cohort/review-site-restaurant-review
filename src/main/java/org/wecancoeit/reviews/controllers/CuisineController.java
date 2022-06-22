package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;

@Controller
public class CuisineController {

    private CuisineRepository cuisineRepo;
    private RestaurantRepository restaurantRepository;

    public CuisineController(CuisineRepository cuisineRepo, RestaurantRepository restaurantRepository) {
        this.cuisineRepo = cuisineRepo;
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping("/")
    public String showAllCuisines(Model model) {
        model.addAttribute("cuisines",cuisineRepo.findAll());
        return "cuisines";
    }



}
