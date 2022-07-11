package com.dom.food.review.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dom.food.review.mapper.ReviewMapper;
import com.dom.food.review.models.ReviewModel;

@Service
public class ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    public ResponseEntity<?> createReview(ReviewModel review) {
        return this.reviewMapper.createReview(review) ? ResponseEntity.ok().body("created")
                : ResponseEntity.badRequest().body("failed");
    }

    public List<ReviewModel> getAllMenuReview(Integer menuId) {
        return this.reviewMapper.getAllMenuReview(menuId);
    }

    public ResponseEntity<?> deleteReview(ReviewModel reviewModel) {
        return this.reviewMapper.deleteReview(reviewModel) ? ResponseEntity.ok().body("deleted")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> updateReview(ReviewModel review) {
        return this.reviewMapper.updateReview(review) ? ResponseEntity.ok().body("updated")
                : ResponseEntity.badRequest().body("failed");
    }
}
