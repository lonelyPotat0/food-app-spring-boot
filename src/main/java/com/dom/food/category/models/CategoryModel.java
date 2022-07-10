package com.dom.food.category.models;

public class CategoryModel {
    private Integer categoryId;
    private String categoryName;
    private String createAt;
    private String updateAt;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // public String getDetail() {
    // return this.detail;
    // }

    // public void setDetail(String detail) {
    // this.detail = detail;
    // }

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

}
