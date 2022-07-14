package com.dom.food.menu.services;

import com.dom.food.menu.mapper.MenuMapper;
import com.dom.food.menu.models.MenuModel;
import com.dom.food.menu.models.MenuResult;
import com.dom.food.ultilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public MenuModel createMenu(MenuModel menu) {
        return this.menuMapper.createMenu(menu) ? menu : null;
    }

    public MenuResult getAllMenu(Integer page, Integer perPage, String name) {
        Pagination pageInfo = new Pagination();
        pageInfo.setPage(page).setPerPage(perPage).setName(name);
        pageInfo.setOffset((pageInfo.getPage() * pageInfo.getPerPage()) - pageInfo.getPerPage());
        pageInfo.setTotal(this.countMenuByName(name));
        return new MenuResult().setMenus(this.menuMapper.getAllMenu(pageInfo)).setPageInfo(pageInfo);
    }

    public MenuModel getMenu(Integer id) {
        return this.menuMapper.getMenu(id);
    }

    public MenuResult getMenuByShop(Integer page, Integer perPage, String name, Integer shopId) {
        Pagination pageInfo = new Pagination();
        pageInfo.setPage(page).setPerPage(perPage).setName(name).setShopId(shopId)
                .setOffset((pageInfo.getPage() * pageInfo.getPerPage()) - pageInfo.getPerPage());
        pageInfo.setTotal(this.countMenuById(shopId));
        return new MenuResult().setMenus(this.menuMapper.getMenuByShopId(pageInfo)).setPageInfo(pageInfo);
    }

    public MenuModel updateMenu(MenuModel menu) {
        return this.menuMapper.updateMenu(menu) ? menu : null ;
        // ResponseEntity.ok().body("updated")
        //         : ResponseEntity.badRequest().body("failed");
    }

    public Boolean deleteMenu(Integer id) {
        return this.menuMapper.deleteMenu(id);
        // ? ResponseEntity.ok().body("deleted")
        //         : ResponseEntity.badRequest().body("failed");
    }


    private Integer countMenuById(Integer id) {
        return this.menuMapper.countMenuByShopId(id);
    }

    private Integer countMenuByName(String name) {
        return this.menuMapper.countMenuByName(name);
    }
}
