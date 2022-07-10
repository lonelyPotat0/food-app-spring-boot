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

    public Integer getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
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
