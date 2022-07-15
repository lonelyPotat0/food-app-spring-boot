package com.dom.food.user.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePasswordRequest {

    @NotBlank(message = "old password required")
    @Size(min = 1)
    private Integer userId;

    @NotBlank(message = "old password required")
    private String oldPassword;
    @NotBlank(message = "old password required")
    private String newPassword;


    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", oldPassword='" + getOldPassword() + "'" +
            ", newPassword='" + getNewPassword() + "'" +
            "}";
    }

    
}
