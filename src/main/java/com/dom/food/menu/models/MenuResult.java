package com.dom.food.menu.models;

import java.util.List;

import com.dom.food.ultilities.Pagination;

public class MenuResult {

    private Pagination pageInfo;
    private List<Object> menus;

    public Pagination getPageInfo() {
        return this.pageInfo;
    }

    public MenuResult setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public List<Object> getMenus() {
        return this.menus;
    }

    public MenuResult setMenus(List<Object> menus) {
        this.menus = menus;
        return this;
    }

}
