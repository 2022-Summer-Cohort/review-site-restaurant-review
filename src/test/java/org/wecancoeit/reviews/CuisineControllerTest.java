package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.wecancoeit.reviews.controllers.CuisineController;
import org.wecancoeit.reviews.model.Cuisine;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CuisineController.class)
public class CuisineControllerTest {

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
    private Cuisine cuisineMock;
    @Mock
    private Model model;


    @Test
    public void shouldWorkForShowCuisines() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("cuisines"));
    }

    @Test
    public void shouldGetCuisinesInModel() throws Exception {
        Collection<Cuisine> testCuisines = Arrays.asList(cuisineMock);
        when(cuisineRepo.findAll()).thenReturn(testCuisines);
        mockMvc.perform(get("/")).andExpect(model().attribute("cuisines", testCuisines));

    }

}
