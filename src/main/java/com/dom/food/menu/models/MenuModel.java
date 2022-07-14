package com.dom.food.menu.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MenuModel {
    private Integer menuId;
    @NotBlank(message = "name can't be blank")
    private String name;
    // @NotBlank(message = "price can't be blank")
    @NotNull
    private double price;
    @NotBlank(message = "shopId can't be blank")
    private Integer shopId;
    @NotBlank(message = "categoryId can't be blank")
    private Integer categoryId;
    private String createAt;
    private String updateAt;
    private String image;



    public MenuModel() {
    }

    public MenuModel(Integer menuId, String name, double price, Integer shopId, Integer categoryId, String createAt, String updateAt, String image) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.shopId = shopId;
        this.categoryId = categoryId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.image = image;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public MenuModel setMenuId(Integer menuId) {
        this.menuId = menuId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public MenuModel setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return this.price;
    }

    public MenuModel setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getImage() {
        return this.image;
    }

    public MenuModel setImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getShopId() {
        return this.shopId;
    }

    public MenuModel setShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public MenuModel setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public MenuModel setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public MenuModel setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
        return this;
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
