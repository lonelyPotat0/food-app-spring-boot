package com.dom.food.menu.services;

import com.dom.food.menu.mapper.MenuMapper;
import com.dom.food.menu.models.MenuModel;
import com.dom.food.menu.models.MenuResult;
import com.dom.food.ultilities.Pagination;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public MenuModel createMenu(MenuModel menu) throws HttpResponseException {
        if (this.menuMapper.createMenu(menu)) {
            return menu;
        }
        throw new HttpResponseException(400, "fail");
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

    public MenuModel updateMenu(MenuModel menu) throws HttpResponseException {
        if (this.menuMapper.updateMenu(menu)) {
            return menu;
        }
        throw new HttpResponseException(400, "fail");
    }

    public Boolean deleteMenu(Integer id) throws HttpResponseException {
        if (this.menuMapper.deleteMenu(id)) {
            return true;
        }
        throw new HttpResponseException(400, "fail");
    }


    private Integer countMenuById(Integer id) {
        return this.menuMapper.countMenuByShopId(id);
    }

    private Integer countMenuByName(String name) {
        return this.menuMapper.countMenuByName(name);
    }
}
