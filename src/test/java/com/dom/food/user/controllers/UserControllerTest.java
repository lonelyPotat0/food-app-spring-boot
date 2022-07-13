package com.dom.food.user.controllers;

import com.dom.food.user.mapper.UserMapper;
import com.dom.food.user.models.ERole;
import com.dom.food.user.models.UserModel;
import com.dom.food.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {


    @MockBean
    UserService userService;

    @MockBean
    private UserMapper userMapper;

    ERole role;

    @Test
    void createUser() {
        UserModel insertUser = new UserModel(null, "dom", "dddddddom@mail.com" , "0921115", "123456" , ERole.ROLE_CUSTOMER, "phnom penh", null, null);
        UserModel responseUser = new UserModel(1, "dom", "dddddddom@mail.com" , "0921115", "$2a$10$DbEnFQQUZG.vDbrwXhru..UTjjmGGu2oV2IqpWPU0d.m1EdzVN.0a" , ERole.ROLE_CUSTOMER, "phnom penh", null, null);
        when(userService.createUser(insertUser)).thenReturn(responseUser);
        assertEquals(1, responseUser.getUserId());
    }

    @Test
    void getUserInformation() {
        UserModel user = new UserModel(1, "dom", "dom@mail.com" , "0123456789", null , ERole.ROLE_CUSTOMER, "phnom penh", "2022-07-11 12:35:52", "2022-07-11 12:35:52");
        when(userService.getUserInformation(1)).thenReturn(user);
        assertEquals(1, user.getUserId());
    }

    @Test
    void updateUser() {
        UserModel user = new UserModel();
        user.setPhone("01244556").setFullname("yim dom").setUserId(1);
        when(userService.getUserInformation(1)).thenReturn(user);
    }

    @Test
    void deleteUser() {
    }
}