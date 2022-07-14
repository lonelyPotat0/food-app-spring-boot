package com.dom.food.order.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OrderModel {

    private Integer orderId;
    @Size(min = 1)
    private Integer customerId;
    @NotBlank(message = "address must not be blank")
    private String deliveryAddress;
    // @Size(min = 1)
    private double grandTotal;
    // @Size(min = 1)
    private Integer processedBy;
    private String createAt;
    private String updateAt;

    public Integer getOrderId() {
        return this.orderId;
    }

    public OrderModel setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public OrderModel setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public double getGrandTotal() {
        return this.grandTotal;
    }

    public OrderModel setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public Integer getProcessedBy() {
        return this.processedBy;
    }

    public OrderModel setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
        return this;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public OrderModel setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public OrderModel setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
        return this;
    };

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public OrderModel setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " orderId='" + getOrderId() + "'" +
                ", customerId='" + getCustomerId() + "'" +
                ", deliveryAddress='" + getDeliveryAddress() + "'" +
                ", grandTotal='" + getGrandTotal() + "'" +
                ", processedBy='" + getProcessedBy() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                "}";
    }

}
