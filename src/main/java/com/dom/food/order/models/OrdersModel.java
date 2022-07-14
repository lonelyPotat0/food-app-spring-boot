package com.dom.food.order.models;

public class OrdersModel {
    private String image;
    private Integer quantity;
    private Integer orderId;
    private double grandTotal;
    private boolean delivered;
    private String customerName;
    private String customerPhone;
    private String deliveryAddress;
    private String customerEmail;
    private Integer customerId;
    private String name;
    private String createAt;
    private String updateAt;

    public OrdersModel() {
    }

    public OrdersModel(String image, Integer quantity, Integer orderId, double grandTotal, boolean delivered, String customerName, String customerPhone, String deliveryAddress, String customerEmail, Integer customerId, String name, String createAt, String updateAt) {
        this.image = image;
        this.quantity = quantity;
        this.orderId = orderId;
        this.grandTotal = grandTotal;
        this.delivered = delivered;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.deliveryAddress = deliveryAddress;
        this.customerEmail = customerEmail;
        this.customerId = customerId;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getGrandTotal() {
        return this.grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
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

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "{" +
            " image='" + getImage() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", grandTotal='" + getGrandTotal() + "'" +
            ", delivered='" + isDelivered() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerPhone='" + getCustomerPhone() + "'" +
            ", deliveryAddress='" + getDeliveryAddress() + "'" +
            ", customerEmail='" + getCustomerEmail() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", name='" + getName() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }



}
