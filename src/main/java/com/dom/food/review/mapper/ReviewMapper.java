package com.dom.food.review.mapper;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.review.models.ReviewModel;

@Mapper
public interface ReviewMapper {

    boolean createReview(@Valid ReviewModel review);

    List<ReviewModel> getAllMenuReview(Integer menuId);

    boolean deleteReview(ReviewModel review);

    boolean updateReview(ReviewModel review);
}
