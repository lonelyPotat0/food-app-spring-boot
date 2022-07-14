package com.dom.food.user.controllers;

import com.dom.food.user.models.ERole;
import com.dom.food.user.models.UserModel;
import com.dom.food.user.services.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    ERole role;

    Gson gson = new Gson();

    @Test
    void createUser() throws Exception {
        UserModel insertUser = new UserModel(null, "dom", "dddddddom@mail.com" , "0921115", "123456" , ERole.ROLE_CUSTOMER, "phnom penh", null, null);
        UserModel responseUser = new UserModel(1, "dom", "dddddddom@mail.com" , "0921115", "$2a$10$DbEnFQQUZG.vDbrwXhru..UTjjmGGu2oV2IqpWPU0d.m1EdzVN.0a" , ERole.ROLE_CUSTOMER, "phnom penh", null, null);
        Mockito.when(userService.createUser(insertUser)).thenReturn(responseUser);
        Mockito.when(userService.isExistByPhoneNumber(insertUser)).thenReturn(false);
        Mockito.when(userService.existsByEmail(insertUser.getEmail())).thenReturn(false);
        String content = gson.toJson(insertUser);

        mvc.perform(post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isCreated());
    }

    @Test
    void getUserInformation() throws Exception {
        UserModel user = new UserModel(1, "dom", "dom@mail.com" , "0123456789", null , ERole.ROLE_CUSTOMER, "phnom penh", "2022-07-11 12:35:52", "2022-07-11 12:35:52");
        Mockito.when(userService.getUserInformation(1)).thenReturn(user);
        mvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("fullname").value("dom"));
    }

    @Test
    void updateUser() throws Exception {
        UserModel user = new UserModel();
        user.setPhone("01244556").setFullname("yim dom").setUserId(1);
        Mockito.when(this.userService.updateUser(user)).thenReturn(user);
        String content = gson.toJson(user);
        mvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("fullname").value("yim dom"));
    }

    @Test
    void deleteUser() throws Exception {
        Mockito.when(this.userService.deleteUser(1)).thenReturn(true);
        mvc.perform(delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}