package com.dom.food.user.controllers;

import com.dom.food.user.models.UserModel;
import com.dom.food.user.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserModel userModel) {
        return this.userService.createUser(userModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInformation(@PathVariable("id") String id) {
        System.out.println("======> " + id);
        return this.userService.getUserInformation(Integer.parseInt(id));
    }

    @GetMapping()
    public ResponseEntity<?> getUserInformation() {
        return ResponseEntity.badRequest().body("no user");
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserModel userModel) {
        return this.userService.updateUser(userModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        return this.userService.deleteUser(Integer.parseInt(id));
    }

    // @PostMapping
    // public ResponseEntity<?> createUser() {
    // return userService.createUser();
    // }

}
