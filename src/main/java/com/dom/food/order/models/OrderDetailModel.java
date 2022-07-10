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

    @Override
    public String toString() {
        return "{" +
                " orderDetailId='" + orderDetailId + "'" +
                ", orderId='" + orderId + "'" +
                ", menuId='" + menuId + "'" +
                ", numberServed='" + numberServed + "'" +
                ", amount='" + amount + "'" +
                ", totalAmount='" + totalAmount + "'" +
                "}";
    }
}
