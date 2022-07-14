package com.dom.food.shop.controllers;

import com.dom.food.shop.model.ShopModel;
import com.dom.food.shop.services.ShopService;
import com.dom.food.user.models.ERole;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class ShopControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ShopService shopService;


    Gson gson = new Gson();

    @Test
    void createShop() throws Exception {
        ShopModel shopInsert = new ShopModel();
        shopInsert.setPhone("09123213").setName("shop asd").setAddress("kampong cham");
        ShopModel shopResponse = new ShopModel();
        shopResponse.setPhone("09123213").setName("shop asd").setAddress("kampong cham").setShopId(1);
        Mockito.when(shopService.createShop(shopInsert)).thenReturn(shopResponse);
        String content = gson.toJson(shopInsert);

        mvc.perform(post("/shop/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllShop() throws Exception {
        List<ShopModel> shops = new ArrayList<ShopModel>();
//        Integer shopId, String address, String phone, String userId, String name, String email
        shops.add(new ShopModel(1, "pp", "012312312", 1, "shop1", ""));
        shops.add(new ShopModel(2, "kpc", "012312312", 1, "shop1", ""));
        Mockito.when(shopService.getAllShop()).thenReturn(shops);
        mvc.perform(get("/shop")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].address").value("pp"));
    }

    @Test
    void getShop() throws Exception {
        ShopModel shop = new ShopModel(1, "kpc", "012312312", 1, "shop1", "");
        Mockito.when(shopService.getShop(1)).thenReturn(shop);
        mvc.perform(get("/shop/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("address").value("kpc"));
    }

    @Test
    void updateShop() throws Exception {
        ShopModel shop = new ShopModel(1, "kpc", "012312312", 1, "shop1", "potato@mail.com");
        Mockito.when(shopService.updateShop(shop)).thenReturn(shop);
        String content = gson.toJson(shop);
        mvc.perform(put("/shop")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("shop1"));
    }

    @Test
    void deleteShop() throws Exception {
        Mockito.when(shopService.deleteShop(1)).thenReturn(true);
        mvc.perform(delete("/shop/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}