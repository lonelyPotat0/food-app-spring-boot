package com.dom.food.menu.controllers;

import com.dom.food.menu.mapper.MenuMapper;
import com.dom.food.menu.models.MenuModel;
import com.dom.food.menu.models.MenuResult;
import com.dom.food.menu.services.MenuService;
import com.dom.food.ultilities.Pagination;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class MenuControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MenuService menuService;

    @MockBean
    MenuMapper menuMapper;


    Gson gson = new Gson();

    @Test
    void createMenu() throws Exception {
        MenuModel menu = new MenuModel(1, "nugget", 1.11 , 1 , 1 , null , null , "" );
        Mockito.when(menuService.createMenu(menu)).thenReturn(menu);
        String content = gson.toJson(menu);

        mvc.perform(post("/menu/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name").value("nugget"));
    }

    @Test
    void getAllMenu() throws Exception {
        List<MenuModel> menus = new ArrayList<MenuModel>();
        menus.add(new MenuModel(1, "nugget", 1.11 , 1 , 1 , null , null , "" ));
        menus.add(new MenuModel(2, "coca", 1.11 , 1 , 1 , null , null , "" ));
        Pagination pageInfo = new Pagination();
        pageInfo.setName("").setPage(1).setPerPage(2).setOffset((pageInfo.getPage() * pageInfo.getPerPage()) - pageInfo.getPerPage()).setTotal(2);
        MenuResult menuResult = new MenuResult();
        menuResult.setMenus(menus).setPageInfo(pageInfo);
        Mockito.when(menuService.getAllMenu(1,2, "")).thenReturn(menuResult);
        mvc.perform(get("/menu?page=1&perPage=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.menus[0].name").value("nugget"));
    }

    @Test
    void getMenu() throws Exception {
        MenuModel menu = new MenuModel(1, "nugget", 1.11 , 1 , 1 , null , null , "" );
        Mockito.when(menuService.getMenu(1)).thenReturn(menu);
        mvc.perform(get("/menu/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("nugget"));
    }

    @Test
    void getMenuByShop() throws Exception {
        List<MenuModel> menus = new ArrayList<MenuModel>();
        menus.add(new MenuModel(1, "nugget", 1.11 , 1 , 1 , null , null , "" ));
        menus.add(new MenuModel(2, "coca", 1.11 , 1 , 1 , null , null , "" ));
        Pagination pageInfo = new Pagination();
        pageInfo.setName("").setPage(1).setPerPage(2).setOffset((pageInfo.getPage() * pageInfo.getPerPage()) - pageInfo.getPerPage()).setTotal(2);
        MenuResult menuResult = new MenuResult();
        menuResult.setMenus(menus).setPageInfo(pageInfo);
        Mockito.when(menuService.getMenuByShop(1,2, "", 1)).thenReturn(menuResult);
        mvc.perform(get("/menu/shop/1?page=1&perPage=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.menus[0].name").value("nugget"));
    }

    @Test
    void updateMenu() throws Exception {
        MenuModel menu = new MenuModel(1, "cold nugget", 1.11 , 1 , 1 , null , null , "" );
        Mockito.when(menuService.updateMenu(menu)).thenReturn(menu);
        Mockito.when(menuMapper.updateMenu(menu)).thenReturn(true);
        String content = gson.toJson(menu);
        mvc.perform(put("/menu")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("nugget"));
    }

    @Test
    void deleteMenu() throws Exception {
        Mockito.when(this.menuService.deleteMenu(1)).thenReturn(true);
        mvc.perform(delete("/menu/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}