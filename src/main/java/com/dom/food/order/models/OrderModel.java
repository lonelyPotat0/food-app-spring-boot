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
    private float grandTotal;
    // @Size(min = 1)
    private Integer processedBy;
    private String createAt;
    private String updateAt;

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public float getGrandTotal() {
        return this.grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Integer getProcessedBy() {
        return this.processedBy;
    }

    public void setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
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
    };

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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
