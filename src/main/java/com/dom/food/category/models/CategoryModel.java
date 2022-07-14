package com.dom.food.category.models;

public class CategoryModel {
    private Integer categoryId;
    private String categoryName;
    private String createAt;
    private String updateAt;


    public CategoryModel() {
    }

    public CategoryModel(Integer categoryId, String categoryName, String createAt, String updateAt) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public CategoryModel setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
            " categoryId='" + getCategoryId() + "'" +
            ", categoryName='" + getCategoryName() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }

    
}
