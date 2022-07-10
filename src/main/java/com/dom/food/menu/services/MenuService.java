package com.dom.food.menu.services;

import com.dom.food.menu.mapper.MenuMapper;
import com.dom.food.menu.models.MenuModel;
import com.dom.food.menu.models.MenuResult;
import com.dom.food.ultilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public ResponseEntity<?> createMenu(MenuModel menu) {
        if (menu.getImage().equals("")) {
            menu.setImage("https://glamtrek.com/public/assets/home/images/nocontent.jpg");
        }
        return this.menuMapper.createMenu(menu) ? ResponseEntity.ok().body("created")
                : ResponseEntity.badRequest().body("failed");
    }

    public @ResponseBody Object getAllMenu(Integer page, Integer perPage, String name) {
        Pagination pageInfo = new Pagination();
        pageInfo.setPage(page).setPerPage(perPage).setName(name);
        pageInfo.setOffset((pageInfo.getPage() * pageInfo.getPerPage()) - pageInfo.getPerPage());
        pageInfo.setTotal(this.countMenuByName(name));
        return new MenuResult().setMenus(this.menuMapper.getAllMenu(pageInfo)).setPageInfo(pageInfo);
    }

    public ResponseEntity<?> getMenu(Integer id) {
        return ResponseEntity.ok().body(this.menuMapper.getMenu(id));
    }

    public @ResponseBody Object getMenuByShop(Integer page, Integer perPage, String name, Integer shopId) {
        Pagination pageInfo = new Pagination();
        pageInfo.setPage(page).setPerPage(perPage).setName(name).setShopId(shopId)
                .setOffset((pageInfo.getPage() * pageInfo.getPerPage()) - pageInfo.getPerPage());
        pageInfo.setTotal(this.countMenuById(shopId));
        return new MenuResult().setMenus(this.menuMapper.getMenuByShopId(pageInfo)).setPageInfo(pageInfo);
    }

    public ResponseEntity<?> updateMenu(MenuModel menu) {
        System.out.println("================= :>" + menu);
        return this.menuMapper.updateMenu(menu) ? ResponseEntity.ok().body("updated")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> deleteMenu(Integer id) {
        return this.menuMapper.deleteMenu(id) ? ResponseEntity.ok().body("deleted")
                : ResponseEntity.badRequest().body("failed");
    }

    // public ResponseEntity<?> test(Integer id) {
    // return ResponseEntity.ok().body(this.countMenuById(id));
    // }

    private Integer countMenuById(Integer id) {
        return this.menuMapper.countMenuById(id);
    }

    private Integer countMenuByName(String name) {
        return this.menuMapper.countMenuByName(name);
    }
}
