package com.dom.food.user.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// @Entity
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotBlank(message = "fullname|require")
    private String fullname;
    @NotEmpty(message = "email|require")
    private String email;
    @NotEmpty(message = "phone|requrie")
    // @Size(min = 9)
    private String phone;
    @NotEmpty(message = "password|requrie")
    private String password;

    @NotEmpty(message = "role|not empty")
    @Size(min = 1, max = 3)
    private ERole role;
    private String address;
    private String createAt;
    private String updateAt;

    public Integer getUserId() {
        return this.userId;
    }

    public UserModel setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getFullname() {
        return this.fullname;
    }

    public UserModel setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public UserModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public ERole getRole() {
        return this.role;
    }

    public UserModel setRole(ERole role) {
        this.role = role;
        return this;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public UserModel setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public UserModel setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public UserModel setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " userId='" + getUserId() + "'" +
                ", fullname='" + getFullname() + "'" +
                ", email='" + getEmail() + "'" +
                ", phone='" + getPhone() + "'" +
                ", password='" + getPassword() + "'" +
                ", role='" + getRole() + "'" +
                ", address='" + getAddress() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                "}";
    }

}