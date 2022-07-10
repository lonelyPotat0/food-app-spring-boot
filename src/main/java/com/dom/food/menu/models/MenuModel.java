package com.dom.food.menu.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MenuModel {
    private Integer menuId;
    @NotBlank(message = "name can't be blank")
    private String name;
    // @NotBlank(message = "price can't be blank")
    @NotNull
    private float price;
    @NotBlank(message = "shopId can't be blank")
    private Integer shopId;
    @NotBlank(message = "categoryId can't be blank")
    private Integer categoryId;
    private String createAt;
    private String updateAt;
    private String image;

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getShopId() {
        return this.shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
                " menuId='" + getMenuId() + "'" +
                ", name='" + getName() + "'" +
                ", price='" + getPrice() + "'" +
                ", shopId='" + getShopId() + "'" +
                ", categoryId='" + getCategoryId() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                ", image='" + getImage() + "'" +
                "}";
    }

}
