package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantRepository restaurantRepo;

    public RestaurantController(RestaurantRepository restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }
}
