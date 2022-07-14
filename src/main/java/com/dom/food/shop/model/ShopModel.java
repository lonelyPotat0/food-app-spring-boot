package com.dom.food.shop.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ShopModel {
    private Integer shopId;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @Size(min = 1)
    private Integer userId;
    private String createAt;
    private String updateAt;
    private String name;
    @Email
    @NotBlank
    private String email;


    public ShopModel() {
    }

    public ShopModel(Integer shopId, String address, String phone, Integer userId, String name, String email) {
        this.shopId = shopId;
        this.address = address;
        this.phone = phone;
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // public ShopModel(Integer shopId, String address, String phone , String name) {
    //     this.shopId = shopId;
    //     this.address = address;
    //     this.phone = phone;
    //     this.name = name;
    // }
    



    public String getEmail() {
        return this.email;
    }

    public ShopModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ShopModel setName(String name) {
        this.name = name;
        return this;
    };

    public Integer getShopId() {
        return this.shopId;
    }

    public ShopModel setShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public ShopModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public ShopModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public ShopModel setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public ShopModel setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public ShopModel setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " shopId='" + getShopId() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", userId='" + getUserId() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }


}
