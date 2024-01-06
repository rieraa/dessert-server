package com.example.desserts.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 */
public class Orderdetailet implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "od_id", type = IdType.AUTO)
    private Integer odId;

    private Integer orderId;

    private Integer dessertId;

    private Integer quantity;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orderdetailet{" +
        "odId = " + odId +
        ", orderId = " + orderId +
        ", dessertId = " + dessertId +
        ", quantity = " + quantity +
        "}";
    }
}
