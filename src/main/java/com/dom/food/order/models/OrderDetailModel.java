package com.dom.food.order.models;

import javax.validation.constraints.Size;

public class OrderDetailModel {
    private Integer orderDetailId;
    @Size(min = 1)
    private Integer orderId;
    @Size(min = 1)
    private Integer menuId;
    @Size(min = 1)
    private Integer numberServed;
    private float amount;
    private float totalAmount;
    private boolean delivered;
    private Integer customerId;
    private Integer shopId;
    private String createAt;
    private String updateAt;

    public OrderDetailModel() {
    }

    public OrderDetailModel(Integer orderId, Integer menuId, Integer numberServed, float amount, Integer customerId,
            Integer shopId) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.numberServed = numberServed;
        this.amount = amount;
        this.totalAmount = amount * numberServed;
        this.customerId = customerId;
        this.shopId = shopId;
    }

    public Integer getShopId() {
        return this.shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getOrderDetailId() {
        return this.orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNumberServed() {
        return this.numberServed;
    }

    public void setNumberServed(Integer numberServed) {
        this.numberServed = numberServed;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isDelivered() {
        return this.delivered;
    }

    public boolean getDelivered() {
        return this.delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "{" +
                " orderDetailId='" + getOrderDetailId() + "'" +
                ", orderId='" + getOrderId() + "'" +
                ", menuId='" + getMenuId() + "'" +
                ", numberServed='" + getNumberServed() + "'" +
                ", amount='" + getAmount() + "'" +
                ", totalAmount='" + getTotalAmount() + "'" +
                ", delivered='" + isDelivered() + "'" +
                ", customerId='" + getCustomerId() + "'" +
                ", shopId='" + getShopId() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                "}";
    }

}
