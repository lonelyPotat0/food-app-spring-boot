package com.dom.food.review.services;

import com.dom.food.review.mapper.ReviewMapper;
import com.dom.food.review.models.ReviewModel;
import java.util.List;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    public ReviewModel createReview(ReviewModel review) throws HttpResponseException {
        // return  ? review : null;
        if (this.reviewMapper.createReview(review)) {
            return review;
        }
        throw new HttpResponseException(400, "fail");
    }

    public List<ReviewModel> getAllMenuReview(Integer menuId) {
        return this.reviewMapper.getAllMenuReview(menuId);
    }

    public ReviewModel updateReview(ReviewModel review) throws HttpResponseException {
        if (this.reviewMapper.updateReview(review)) {
            return review;
        }
        throw new HttpResponseException(400, "fail");
    }

    public Boolean deleteReview(ReviewModel review) throws HttpResponseException {
        if (this.reviewMapper.deleteReview(review)) {
            return true;
        }
        throw new HttpResponseException(400, "fail");
    }
}
