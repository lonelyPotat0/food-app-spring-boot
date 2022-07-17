package com.dom.food.order.models;

import javax.validation.constraints.Size;

public class CartItemModel {
    // private Integer cartId;

    private Integer cartItemId;
    @Size(min = 1)
    private Integer menuId;
    @Size(min = 1)
    private Integer userId;
    @Size(min = 1)
    private Integer quantity;
    private String name;
    private String image;
    private double price;
    private Integer categoryId;
    private Integer shopId;
    private double totalPrice;
    private String createAt;
    private String updateAt;


    public CartItemModel() {
    }

    public CartItemModel(Integer cartItemId, Integer menuId, Integer userId, Integer quantity, String name, String image, float price, Integer categoryId, Integer shopId, double totalPrice) {
        this.cartItemId = cartItemId;
        this.menuId = menuId;
        this.userId = userId;
        this.quantity = quantity;
        this.name = name;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
        this.shopId = shopId;
        this.totalPrice = totalPrice;
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

    public Integer getCartItemId() {
        return this.cartItemId;
    }

    public CartItemModel setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
        return this;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public CartItemModel setMenuId(Integer menuId) {
        this.menuId = menuId;
        return this;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public CartItemModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public CartItemModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return this.image;
    }

    public CartItemModel setImage(String image) {
        this.image = image;
        return this;
    }

    public double getPrice() {
        return this.price;
    }

    public CartItemModel setPrice(float price) {
        this.price = price;
        return this;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public CartItemModel setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getShopId() {
        return this.shopId;
    }

    public CartItemModel setShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public CartItemModel setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public CartItemModel setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " cartItemId='" + getCartItemId() + "'" +
            ", menuId='" + getMenuId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", price='" + getPrice() + "'" +
            ", categoryId='" + getCategoryId() + "'" +
            ", shopId='" + getShopId() + "'" +
            ", totalPrice='" + getTotalPrice() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }
    

}
