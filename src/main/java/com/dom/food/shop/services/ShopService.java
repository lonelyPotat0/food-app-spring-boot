package com.dom.food.shop.services;

import com.dom.food.shop.mapper.ShopMapper;
import com.dom.food.shop.model.ShopModel;
import java.util.List;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public ShopModel createShop(ShopModel shop) throws HttpResponseException {
        // return this.shopMapper.createShop(shop) ? shop : null;
        if (this.shopMapper.createShop(shop)) {
            return shop;
        }
        throw new HttpResponseException(400, "fail");
    }

    public List<ShopModel> getAllShop() {
        return this.shopMapper.getAllShop();
    }

    public Object getShop(Integer id) {
        return this.shopMapper.getShop(id);
    }

    public ShopModel updateShop(ShopModel shop) throws HttpResponseException {
        if (this.shopMapper.updateShop(shop)) {
            return shop;
        }
        throw new HttpResponseException(400, "fail");
    }

    public boolean deleteShop(ShopModel shop) throws HttpResponseException {
        if (this.shopMapper.deleteShop(shop)) {
            return true;
        }
        throw new HttpResponseException(400, "fail");
    }
}
