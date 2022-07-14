package com.dom.food.menu.models;

import com.dom.food.ultilities.Pagination;
import java.util.List;


public class MenuResult {

    private Pagination pageInfo;
    private List<MenuModel> menus;


    public MenuResult() {
    }

    public MenuResult(Pagination pageInfo, List<MenuModel> menus) {
        this.pageInfo = pageInfo;
        this.menus = menus;
    }

    
    public Pagination getPageInfo() {
        return this.pageInfo;
    }

    public MenuResult setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public List<MenuModel> getMenus() {
        return this.menus;
    }

    public MenuResult setMenus(List<MenuModel> menus) {
        this.menus = menus;
        return this;
    }

}
