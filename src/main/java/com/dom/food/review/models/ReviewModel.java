package com.dom.food.review.models;

import javax.validation.constraints.Size;

// import lombok.Data;

// @Data
public class ReviewModel {
    private Integer reviewId;
    private String comment;
    @Size(min = 1, max = 5)
    private Integer rating;
    @Size(min = 1)
    private Integer menuId;
    @Size(min = 1)
    private Integer customerId;
    private String createAt;
    private String updateAt;


    public ReviewModel() {
    }

    public ReviewModel(Integer reviewId, String comment, Integer rating, Integer menuId, Integer customerId, String createAt, String updateAt) {
        this.reviewId = reviewId;
        this.comment = comment;
        this.rating = rating;
        this.menuId = menuId;
        this.customerId = customerId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }


    public Integer getReviewId() {
        return this.reviewId;
    }

    public ReviewModel setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
        return this;
    }

    public String getComment() {
        return this.comment;
    }

    public ReviewModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Integer getRating() {
        return this.rating;
    }

    public ReviewModel setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public ReviewModel setMenuId(Integer menuId) {
        this.menuId = menuId;
        return this;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public ReviewModel setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public ReviewModel setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public ReviewModel setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " reviewId='" + getReviewId() + "'" +
                ", comment='" + getComment() + "'" +
                ", rating='" + getRating() + "'" +
                ", menuId='" + getMenuId() + "'" +
                ", customerId='" + getCustomerId() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                "}";
    }

}
