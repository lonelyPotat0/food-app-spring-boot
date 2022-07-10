package com.dom.food.menu.mapper;

import com.dom.food.menu.models.MenuModel;
import com.dom.food.ultilities.Pagination;
import java.util.List;
import javax.validation.Valid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    boolean createMenu(@Valid MenuModel menu);

    List<Object> getAllMenu(@Valid Pagination page);

    Object getMenu(Integer id);

    List<Object> getMenuByShopId(@Valid Pagination page);

    boolean updateMenu(MenuModel menu);

    boolean deleteMenu(Integer id);

    Integer countMenuById(Integer shopId);

    Integer countMenuByName(String name);
}
