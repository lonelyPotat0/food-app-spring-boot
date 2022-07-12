package com.dom.food.shop.controllers;

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

import com.dom.food.shop.model.ShopModel;
import com.dom.food.shop.services.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity<?> createShop(@Valid @RequestBody ShopModel shop) {
        return this.shopService.createShop(shop);
    }

    @GetMapping()
    public ResponseEntity<?> getAllShop() {
        return this.shopService.getAllShop();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShop(@PathVariable("id") String id) {
        return this.shopService.getShop(Integer.parseInt(id));
    }

    @PutMapping()
    public ResponseEntity<?> updateShop(@RequestBody ShopModel shop) {
        return this.shopService.updateShop(shop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable("id") String id) {
        return this.shopService.deleteShop(Integer.parseInt(id));
    }

}
