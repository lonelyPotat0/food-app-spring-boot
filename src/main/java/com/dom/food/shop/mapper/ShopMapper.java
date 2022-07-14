package com.dom.food.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.shop.model.ShopModel;

@Mapper
public interface ShopMapper {

    boolean createShop(ShopModel shop);

    boolean updateShop(ShopModel shop);

    boolean deleteShop(Integer id);

    List<ShopModel> getAllShop();

    Object getShop(Integer id);
}
