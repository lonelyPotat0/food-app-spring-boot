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
    private float price;
    private Integer categoryId;
    private Integer shopId;
    private float totalPrice;

    public Integer getCartItemId() {
        return this.cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getShopId() {
        return this.shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
                "}";
    }

}
