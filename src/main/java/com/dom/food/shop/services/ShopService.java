package com.dom.food.shop.services;

import com.dom.food.shop.mapper.ShopMapper;
import com.dom.food.shop.model.ShopModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public ShopModel createShop(ShopModel shop) {
        return this.shopMapper.createShop(shop) ? shop //ResponseEntity.ok().body("created")
                : null; //ResponseEntity.badRequest().body("failed");
    }

    public List<ShopModel> getAllShop() {
        return this.shopMapper.getAllShop();
    }

    public Object getShop(Integer id) {
        return this.shopMapper.getShop(id);
    }

    public ShopModel updateShop(ShopModel shop) {
        return this.shopMapper.updateShop(shop) == true ? shop : null;
    }

    public boolean deleteShop(Integer id) {
        return this.shopMapper.deleteShop(id);
        // ? ResponseEntity.ok().body("deleted")
        //         : ResponseEntity.badRequest().body("failed");
    }
}
