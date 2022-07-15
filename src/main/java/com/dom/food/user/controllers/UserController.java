package com.dom.food.user.controllers;

import com.dom.food.user.models.ChangePasswordRequest;
import com.dom.food.user.models.UserModel;
import com.dom.food.user.services.UserService;
import javax.validation.Valid;
import org.apache.http.client.HttpResponseException;
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
    public ResponseEntity<?> createUser(@Valid @RequestBody UserModel userModel) throws HttpResponseException {
        return ResponseEntity.created(null).body(this.userService.createUser(userModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserInformation(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(this.userService.getUserInformation(Integer.parseInt(id)));
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserModel userModel) throws HttpResponseException {
        return ResponseEntity.ok().body(this.userService.updateUser(userModel));
    }

    @PutMapping("/password")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody ChangePasswordRequest password) throws HttpResponseException {
        return ResponseEntity.ok().body(this.userService.updatePassword(password));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") String id) throws HttpResponseException, NumberFormatException {
        return ResponseEntity.ok().body(this.userService.deleteUser(Integer.parseInt(id)));
    }


}
