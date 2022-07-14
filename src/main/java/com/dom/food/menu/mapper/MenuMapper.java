package com.dom.food.menu.mapper;

import com.dom.food.menu.models.MenuModel;
import com.dom.food.ultilities.Pagination;
import java.util.List;
import javax.validation.Valid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    boolean createMenu(@Valid MenuModel menu);

    List<MenuModel> getAllMenu(@Valid Pagination page);

    MenuModel getMenu(Integer id);

    List<MenuModel> getMenuByShopId(@Valid Pagination page);

    boolean updateMenu(MenuModel menu);

    boolean deleteMenu(Integer id);

    Integer countMenuByShopId(Integer shopId);

    Integer countMenuByName(String name);
}
