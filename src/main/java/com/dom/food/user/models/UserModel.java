package com.dom.food.user.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
// import java.util.List;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

@Entity
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
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "role_id")
    // private RoleModel role;
    private String role;

    // private boolean isAvailable;
    private String createAt;
    private String updateAt;

    public String getPassword() {
        return this.password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}