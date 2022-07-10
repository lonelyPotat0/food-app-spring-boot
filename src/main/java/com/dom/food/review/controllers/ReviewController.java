package com.dom.food.review.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.food.review.models.ReviewModel;
import com.dom.food.review.services.ReviewService;

// import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/review")
// @RequiredArgsConstructor
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@Valid @RequestBody ReviewModel reviewModel) {
        return this.reviewService.createReview(reviewModel);
    }

    @GetMapping("/{menuId}")
    public List<ReviewModel> getAllMenuReviews(@PathVariable("menuId") String menuId) {
        return this.reviewService.getAllMenuReview(Integer.parseInt(menuId));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewId") String reviewId) {
        return this.reviewService.deleteReview(Integer.parseInt(reviewId));
    }

    @PutMapping()
    public ResponseEntity<?> updateReview(@RequestBody ReviewModel reviewModel) {
        return this.reviewService.updateReview(reviewModel);
    }
}
