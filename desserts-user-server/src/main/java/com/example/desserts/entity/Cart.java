package com.example.desserts.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 */
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "custom_id", type = IdType.AUTO)

    private Integer cartId;

    private Integer dessertId;

    private String userId;

    private Integer quantity;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
        "cartId = " + cartId +
        ", dessertId = " + dessertId +
        ", userId = " + userId +
        ", quantity = " + quantity +
        "}";
    }
}
