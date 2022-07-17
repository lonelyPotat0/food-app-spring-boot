package com.dom.food.order.models;

public class OrderListModel {
    private Integer orderId;
    private Integer customerId;
    private String deliveryAddress;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String menuId;
    private Integer quantity;
    private Integer amount;
    private double totalAmount;

    private String image;
    private boolean delivered;
    private String name;
    private String createAt;
    private String updateAt;
    public OrderListModel() {
    }

    public OrderListModel(String image, Integer quantity, Integer orderId, double totalAmount, boolean delivered, String customerName, String customerPhone, String deliveryAddress, String customerEmail, Integer customerId, String name, String createAt, String updateAt) {
        this.image = image;
        this.quantity = quantity;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
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


    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
            " orderId='" + getOrderId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", deliveryAddress='" + getDeliveryAddress() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerPhone='" + getCustomerPhone() + "'" +
            ", customerEmail='" + getCustomerEmail() + "'" +
            ", menuId='" + getMenuId() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", amount='" + getAmount() + "'" +
            ", totalAmount='" + getTotalAmount() + "'" +
            ", image='" + getImage() + "'" +
            ", delivered='" + isDelivered() + "'" +
            ", name='" + getName() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }
   



}
