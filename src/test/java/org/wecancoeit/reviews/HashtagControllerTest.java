package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.wecancoeit.reviews.controllers.HashtagController;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


    @WebMvcTest(HashtagController.class)
    public class HashtagControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CuisineRepository cuisineRepo;

        @MockBean
        private ReviewRepository reviewRepo;

        @MockBean
        private RestaurantRepository restaurantRepo;

        @MockBean
        private HashtagRepository hashtagRepo;

        @Mock
        private Hashtag hashtagMock;
        @Mock
        private Model model;

    @Test
    public void shouldWorkForShowHashtags() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("hashtags"));
    }

    @Test
    public void shouldGetHashtagInModel() throws Exception {
        Collection<Hashtag> testHashtags = Arrays.asList(hashtagMock);
        when(hashtagRepo.findAll()).thenReturn(testHashtags);
        mockMvc.perform(get("/")).andExpect(model().attribute("hashtags", testHashtags));
    }

}