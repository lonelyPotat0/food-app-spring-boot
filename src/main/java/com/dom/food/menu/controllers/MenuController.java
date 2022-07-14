package com.dom.food.menu.controllers;

import com.dom.food.menu.models.MenuModel;
import com.dom.food.menu.models.MenuResult;
import com.dom.food.menu.services.MenuService;
import com.google.common.util.concurrent.RateLimiter;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    RateLimiter rateLimiter;

    @PostMapping("create")
    public ResponseEntity<?> createMenu(@Valid @RequestBody MenuModel menuModel) {
        MenuModel menu = this.menuService.createMenu(menuModel);
        return menu != null ? 
            new ResponseEntity<>(this.menuService.createMenu(menu), HttpStatus.CREATED)
            : new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public @ResponseBody MenuResult getAllMenu(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10") String perPage,
            @RequestParam(defaultValue = "") String name) {
        rateLimiter.acquire();
        return this.menuService.getAllMenu(Integer.parseInt(page), Integer.parseInt(perPage), name);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuModel> getMenu(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.menuService.getMenu(Integer.parseInt(id)), HttpStatus.OK);
    }

    @GetMapping("/shop/{id}")
    public @ResponseBody MenuResult getMenuByShop(
            @PathVariable("id") String id,
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "10") String perPage,
            @RequestParam(defaultValue = "") String name) {
        return this.menuService.getMenuByShop(Integer.parseInt(page), Integer.parseInt(perPage), name,
                Integer.parseInt(id));
    }
   
    @PutMapping()
    public ResponseEntity<?> updateMenu(@RequestBody MenuModel menuModel) {
        MenuModel menu = this.menuService.updateMenu(menuModel);
        return menu != null ? 
            new ResponseEntity<MenuModel>(this.menuService.createMenu(menu), HttpStatus.OK)
            : new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMenu(@PathVariable("id") String id) {
        return new ResponseEntity<Boolean>(this.menuService.deleteMenu(Integer.parseInt(id)), HttpStatus.OK);
    }

}
