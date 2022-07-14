package com.dom.food.review.controllers;

import com.dom.food.review.models.ReviewModel;
import com.dom.food.review.services.ReviewService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class ReviewControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ReviewService reviewService;

    Gson gson = new Gson();

    @Test
    void createReview() throws Exception {
        ReviewModel insertReview = new ReviewModel();
        insertReview.setComment("hello there").setRating(4).setMenuId(1).setCustomerId(1);
        ReviewModel responseReview = insertReview;
        responseReview.setReviewId(1);
        Mockito.when(reviewService.createReview(insertReview)).thenReturn(responseReview);
        String content = gson.toJson(insertReview);
        mvc.perform(post("/review/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllMenuReviews() throws Exception {
        List<ReviewModel> reviews = new ArrayList<>();
        reviews.add(new ReviewModel( 1, "good", 4 , 1 , 1 , "2022-07-10T13:51:27" , "2022-07-10T06:51:27.000+00:00"));
        reviews.add(new ReviewModel( 2, "excellent", 5 , 1 , 1 , "2022-07-10T13:51:27" , "2022-07-10T06:51:27.000+00:00"));
        Mockito.when(reviewService.getAllMenuReview(1)).thenReturn(reviews);
        mvc.perform(get("/review/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].comment").value("good"));
    }

    @Test
    void updateReview() throws Exception {
        ReviewModel review = new ReviewModel( 1, "good", 4 , 1 , 1 , null , null);
        Mockito.when(reviewService.updateReview(review)).thenReturn(review);
        String content = gson.toJson(review);
        mvc.perform(put("/review")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].comment").value("good"));
    }

    @Test
    void deleteReview() throws Exception {
        ReviewModel review = new ReviewModel();
        review.setReviewId(1).setCustomerId(1);
        Mockito.when(reviewService.deleteReview(review)).thenReturn(true);
        String content = gson.toJson(review);
        mvc.perform(delete("/review")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk());

    }


}