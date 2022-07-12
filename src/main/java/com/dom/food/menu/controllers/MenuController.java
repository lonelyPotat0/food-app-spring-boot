package com.dom.food.menu.controllers;

import com.dom.food.menu.models.MenuModel;
import com.dom.food.menu.services.MenuService;

import javax.validation.Valid;

// import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("create")
    public ResponseEntity<?> createMenu(@Valid @RequestBody MenuModel menu) {
        return this.menuService.createMenu(menu);
    }

    @GetMapping()
    public @ResponseBody Object getAllMenu(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10") String perPage,
            @RequestParam(defaultValue = "") String name) {
        return this.menuService.getAllMenu(Integer.parseInt(page), Integer.parseInt(perPage), name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMenu(@PathVariable("id") String id) {
        return this.menuService.getMenu(Integer.parseInt(id));
    }

    @GetMapping("/shop/{id}")
    public @ResponseBody Object getMenuByShop(
            @PathVariable("id") String id,
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10") String perPage,
            @RequestParam(defaultValue = "") String name) {
        return this.menuService.getMenuByShop(Integer.parseInt(page), Integer.parseInt(perPage), name,
                Integer.parseInt(id));
    }

    @PutMapping()
    public ResponseEntity<?> updateMenu(@RequestBody MenuModel menu) {
        return this.menuService.updateMenu(menu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") String id) {
        return this.menuService.deleteMenu(Integer.parseInt(id));
    }

    // @GetMapping("/test")
    // public ResponseEntity<?> test(@RequestParam(defaultValue = "0") String id) {
    // System.out.println("======================>" + id);
    // return this.menuService.test(Integer.parseInt(id));
    // }

}
