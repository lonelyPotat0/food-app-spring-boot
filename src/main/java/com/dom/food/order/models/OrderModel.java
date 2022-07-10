package com.dom.food.order.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OrderModel {

    private Integer ordeId;
    @Size(min = 1)
    private Integer customerId;
    @NotBlank(message = "address must not be blank")
    private String deleiveryAddress;
    // @Size(min = 1)
    private float grandTotal;
    @Size(min = 1)
    private Integer processedBy;
    private String createAt;
    private String updateAt;

    public Integer getOrdeId() {
        return this.ordeId;
    }

    public void setOrdeId(Integer ordeId) {
        this.ordeId = ordeId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDeleiveryAddress() {
        return this.deleiveryAddress;
    }

    public void setDeleiveryAddress(String deleiveryAddress) {
        this.deleiveryAddress = deleiveryAddress;
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

    @Override
    public String toString() {
        return "{" +
                " ordeId='" + getOrdeId() + "'" +
                ", customerId='" + getCustomerId() + "'" +
                ", deleiveryAddress='" + getDeleiveryAddress() + "'" +
                ", grandTotal='" + getGrandTotal() + "'" +
                ", processedBy='" + getProcessedBy() + "'" +
                ", createAt='" + getCreateAt() + "'" +
                ", updateAt='" + getUpdateAt() + "'" +
                "}";
    }

}
