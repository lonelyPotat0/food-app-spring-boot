package com.dom.food.shop.controllers;

import com.dom.food.shop.model.ShopModel;
import com.dom.food.shop.services.ShopService;
import java.util.List;
import javax.validation.Valid;
import org.apache.http.client.HttpResponseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity<?> createShop(@Valid @RequestBody ShopModel shop) throws HttpResponseException {
        return new ResponseEntity<>(this.shopService.createShop(shop), HttpStatus.CREATED);
    }

    @GetMapping()
    public @ResponseBody List<ShopModel> getAllShop() {
        return this.shopService.getAllShop();
    }

    @GetMapping("/{id}")
    public @ResponseBody Object getShop(@PathVariable("id") String id) {
        return this.shopService.getShop(Integer.parseInt(id));
    }

    @PutMapping()
    public ResponseEntity<?> updateShop(@RequestBody ShopModel shop) throws HttpResponseException {
        return new ResponseEntity<ShopModel>(this.shopService.updateShop(shop), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteShop(@RequestBody ShopModel shop) throws HttpResponseException, NumberFormatException {
        return ResponseEntity.ok().body(this.shopService.deleteShop(shop));
    }

}
