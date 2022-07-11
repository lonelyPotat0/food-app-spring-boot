package com.dom.food.order.models;

import javax.validation.constraints.Size;

public class CartModel {
    private Integer cartId;
    @Size(min = 1)
    private Integer userId;
    private CartItemModel cartItemModel;

    public Integer getCartId() {
        return this.cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public CartItemModel getCartItemModel() {
        return this.cartItemModel;
    }

    public void setCartItemModels(CartItemModel cartItemModel) {
        this.cartItemModel = cartItemModel;
    }

    @Override
    public String toString() {
        return "{" +
                " cartId='" + getCartId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", cartItemModels='" + getCartItemModel() + "'" +
                "}";
    }

}
