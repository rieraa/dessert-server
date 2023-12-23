package com.example.desserts.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-12-24
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private String userId;

    private String orderDate;

    private BigDecimal orderTotal;

    private Integer daId;

    private String remarks;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Orders{" +
        "orderId = " + orderId +
        ", userId = " + userId +
        ", orderDate = " + orderDate +
        ", orderTotal = " + orderTotal +
        ", daId = " + daId +
        ", remarks = " + remarks +
        "}";
    }
}
