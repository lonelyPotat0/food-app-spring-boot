package com.dom.food.category.controllers;

import com.dom.food.category.models.CategoryModel;
import com.dom.food.category.services.CategoryService;

import com.dom.food.shop.model.ShopModel;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class CategoryControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CategoryService categoryService;


    Gson gson = new Gson();
    @Test
    void createCategory() throws Exception {
        CategoryModel category = new CategoryModel();
        category.setCategoryName("cold");
        Mockito.when(categoryService.existByName(category)).thenReturn(false);
        Mockito.when(categoryService.createCategory(category)).thenReturn(category);
        System.out.println(category);
        String content = gson.toJson(category);
        System.out.println(content);
        mvc.perform(post("/category/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("categoryName").value("cold"));
    }

    @Test
    void getAllCategory() throws Exception {

        List<CategoryModel> categories = new ArrayList<CategoryModel>();
        categories.add( new CategoryModel(1, "cold", "2022-07-10T22:03:06.000+00:00" ,  "2022-07-11T05:03:06"));
        categories.add( new CategoryModel(2, "hot", "2022-07-10T22:03:06.000+00:00" ,  "2022-07-11T05:03:06"));
        Mockito.when(categoryService.getAllCategory()).thenReturn(categories);
        mvc.perform(get("/category")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].categoryName").value("cold"));
    }

    @Test
    void getCategory() throws Exception {
        CategoryModel category = new CategoryModel(1, "cold", "2022-07-10T22:03:06.000+00:00" ,  "2022-07-11T05:03:06");
        Mockito.when(categoryService.getCategory(1)).thenReturn(category);
        mvc.perform(get("/category/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("categoryName").value("cold"));
    }

    @Test
    void updateCategory() throws Exception {
        CategoryModel category = new CategoryModel(1, "cold", "2022-07-10T22:03:06.000+00:00" ,  "2022-07-11T05:03:06");
        Mockito.when(categoryService.getCategory(1)).thenReturn(category);
        Mockito.when(categoryService.existByName(category)).thenReturn(false);
        String content = gson.toJson(category);
        System.out.println(content);
        mvc.perform(put("/category")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("categoryName").value("cold"));
    }

    @Test
    void deleteCategory() throws Exception {
        Mockito.when(categoryService.deleteCategory(1)).thenReturn(true);
        mvc.perform(get("/category/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}