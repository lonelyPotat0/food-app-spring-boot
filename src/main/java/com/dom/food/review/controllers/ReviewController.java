package com.dom.food.review.controllers;

import com.dom.food.review.models.ReviewModel;
import com.dom.food.review.services.ReviewService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




// import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/review")
// @RequiredArgsConstructor
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@Valid @RequestBody ReviewModel reviewModel) {
        return new ResponseEntity<ReviewModel>(this.reviewService.createReview(reviewModel), HttpStatus.CREATED);
    }

    @GetMapping("/{menuId}")
    public List<ReviewModel> getAllMenuReviews(@PathVariable("menuId") String menuId) {
        return this.reviewService.getAllMenuReview(Integer.parseInt(menuId));
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteReview(@RequestBody ReviewModel reviewModel) {
        return new ResponseEntity<Boolean>(this.reviewService.deleteReview(reviewModel) , HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateReview(@RequestBody ReviewModel reviewModel) {
        // return this.reviewService.updateReview(reviewModel);
        ReviewModel review = this.reviewService.updateReview(reviewModel);
        return review != null ?
            new ResponseEntity<ReviewModel>(review, HttpStatus.OK) :
            new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
    }
}
