package com.dom.food.order.models;

import javax.validation.constraints.Size;

public class PaymentModel {
    private Integer paymentId;
    private float amount;
    @Size(min = 1)
    private Integer paidBy;
    @Size(min = 1)
    private Integer processedBy;
    private String createAt;
    private String updateAt;
    private boolean isPaid;
    private Integer orderId;

    public boolean isIsPaid() {
        return this.isPaid;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public PaymentModel setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public boolean getIsPaid() {
        return this.isPaid;
    }

    public PaymentModel setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
        return this;
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    public PaymentModel setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public float getAmount() {
        return this.amount;
    }

    public PaymentModel setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public Integer getPaidBy() {
        return this.paidBy;
    }

    public PaymentModel setPaidBy(Integer paidBy) {
        this.paidBy = paidBy;
        return this;
    }

    public Integer getProcessedBy() {
        return this.processedBy;
    }

    public PaymentModel setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
        return this;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public PaymentModel setCreateAt(String createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public PaymentModel setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " paymentId='" + getPaymentId() + "'" +
                ", amount='" + getAmount() + "'" +
                ", paidBy='" + getPaidBy() + "'" +
                ", processedBy='" + getProcessedBy() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                ", isPaid='" + getIsPaid() + "'" +
                "}";
    }

}
