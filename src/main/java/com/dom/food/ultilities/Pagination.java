package com.dom.food.ultilities;

public class Pagination {
    int total;
    int page;
    int perPage;
    String search;
    int offset;
    int type;
    int category;
    int shopId;
    String name;

    public String getName() {
        return this.name;
    }

    public Pagination setName(String name) {
        this.name = name;
        return this;
    }

    public int getShopId() {
        return this.shopId;
    }

    public Pagination setShopId(int shopId) {
        this.shopId = shopId;
        return this;
    }

    public int getType() {
        return type;
    }

    public Pagination setType(int type) {
        this.type = type;
        return this;
    }

    public int getCategory() {
        return category;
    }

    public Pagination setCategory(int category) {
        this.category = category;
        return this;
    }

    public int getPage() {
        return page;
    }

    public Pagination setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPerPage() {
        return perPage;
    }

    public Pagination setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public String getSearch() {
        return search;
    }

    public Pagination setSearch(String search) {
        this.search = search;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public Pagination setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public Pagination setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public String toString() {
        return "paginate{" +
                "total=" + total +
                ", page=" + page +
                ", perPage=" + perPage +
                ", search='" + search + '\'' +
                ", offset=" + offset +
                ", type=" + type +
                ", category=" + category +
                '}';
    }
}
