package com.dom.food.user.controllers;

import com.dom.food.user.models.UserModel;
import com.dom.food.user.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public UserModel createUser(@Valid @RequestBody UserModel userModel) {
        if (this.userService.isExistByPhoneNumber(userModel)) {
            this.Exception(HttpStatus.BAD_REQUEST, "phone number already taken");
        }
        if (this.userService.existsByEmail(userModel.getEmail())) {
            this.Exception(HttpStatus.BAD_REQUEST, "email already taken");
        }
        UserModel user = this.userService.createUser(userModel);
        return user != null ? user : this.Exception(HttpStatus.BAD_REQUEST, "fail");
    }

    @GetMapping("/{id}")
    public UserModel getUserInformation(@PathVariable("id") String id) {
        return this.userService.getUserInformation(Integer.parseInt(id));
    }

    @PutMapping()
    public UserModel updateUser(@Valid @RequestBody UserModel userModel) {
        if (this.userService.isExistByPhoneNumber(userModel)) {
            this.Exception(HttpStatus.BAD_REQUEST, "phone number already taken");
        }
        UserModel user = this.userService.updateUser(userModel);
        return user != null ? user : this.Exception(HttpStatus.BAD_REQUEST, "fail");
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable("id") String id) {
        return this.userService.deleteUser(Integer.parseInt(id));
    }

    private UserModel Exception (HttpStatus status, String message)  {
        throw new HttpClientErrorException( status , message);
    }

}
