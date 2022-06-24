package org.wecancoeit.reviews.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.repos.HashtagRepository;

@Controller
public class HashtagController {

    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/hashtags/{id}")
    private String showHashtag(Model model, @PathVariable long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "hashtag";
    }

}
