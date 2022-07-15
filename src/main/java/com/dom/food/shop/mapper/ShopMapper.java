package com.dom.food.shop.mapper;

import com.dom.food.shop.model.ShopModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ShopMapper {

    boolean createShop(ShopModel shop);

    boolean updateShop(ShopModel shop);

    boolean deleteShop(ShopModel shop);

    List<ShopModel> getAllShop();

    Object getShop(Integer id);
}
