package com.dom.food.review.services;

import com.dom.food.review.mapper.ReviewMapper;
import com.dom.food.review.models.ReviewModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    public ReviewModel createReview(ReviewModel review) {
        return this.reviewMapper.createReview(review) ? review : null;
    }

    public List<ReviewModel> getAllMenuReview(Integer menuId) {
        return this.reviewMapper.getAllMenuReview(menuId);
    }

    public ReviewModel updateReview(ReviewModel review) {
        return this.reviewMapper.updateReview(review) ? review : null;
    }

    public Boolean deleteReview(ReviewModel reviewModel) {
        return this.reviewMapper.deleteReview(reviewModel) ? true : false;
    }
}
