package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.wecancoeit.reviews.repos.ReviewRepository;



@Controller
public class ReviewController {

    private ReviewRepository reviewRepo;

    public ReviewController(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }


//    @RequestMapping("/reviews/{id}")
//    private String showReview(Model model, @PathVariable long id) {
//        model.addAttribute("review", reviewRepo.findById(id).get());
//        return "review";
//    }

}
