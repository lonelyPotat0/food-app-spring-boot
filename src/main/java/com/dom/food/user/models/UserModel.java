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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return this.role;
    }

    public void setRole(ERole role) {
        this.role = role;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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