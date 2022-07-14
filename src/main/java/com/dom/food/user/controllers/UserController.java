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
        if (this.userService.isExistByPhoneNumber(userModel)) {
            return ResponseEntity.badRequest().body( "phone number already taken");
        }
        if (this.userService.existsByEmail(userModel.getEmail())) {
            return ResponseEntity.badRequest().body( "email already taken");
        }
        UserModel createdUser = this.userService.createUser(userModel);
        return createdUser != null ? 
                            ResponseEntity.created(null).body(createdUser) : 
                            ResponseEntity.badRequest().body("failed"); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserInformation(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(this.userService.getUserInformation(Integer.parseInt(id)));
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserModel userModel) {
        if (this.userService.isExistByPhoneNumber(userModel)) {
            ResponseEntity.badRequest().body( "phone number already taken");
        }
        UserModel upatedUser = this.userService.updateUser(userModel);
        return upatedUser != null ? 
                            ResponseEntity.ok().body(upatedUser) : 
                            ResponseEntity.badRequest().body("failed"); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(this.userService.deleteUser(Integer.parseInt(id)));
    }


}
