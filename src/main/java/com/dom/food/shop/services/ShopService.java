package com.dom.food.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dom.food.shop.mapper.ShopMapper;
import com.dom.food.shop.model.ShopModel;

@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public ResponseEntity<?> createShop(ShopModel shop) {
        return this.shopMapper.createShop(shop) ? ResponseEntity.ok().body("created")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> getAllShop() {
        return ResponseEntity.ok().body(this.shopMapper.getAllShop());
    }

    public ResponseEntity<?> getShop(Integer id) {
        return ResponseEntity.ok().body(this.shopMapper.getShop(id));
    }

    public ResponseEntity<?> updateShop(ShopModel shop) {
        return this.shopMapper.updateShop(shop) ? ResponseEntity.ok().body("updated")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> deleteShop(Integer id) {
        return this.shopMapper.deleteShop(id) ? ResponseEntity.ok().body("deleted")
                : ResponseEntity.badRequest().body("failed");
    }
}
