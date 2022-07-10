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

    public boolean getIsPaid() {
        return this.isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Integer getPaidBy() {
        return this.paidBy;
    }

    public void setPaidBy(Integer paidBy) {
        this.paidBy = paidBy;
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
