package com.example.desserts.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class Cart implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "cart_id", type = IdType.AUTO)

    private Integer cartId;

    private Integer dessertId;

    private Integer userId;

    private Integer quantity;


    private Integer speId;

    private Integer tasteId;




    @Override
    public String toString() {
        return "Cart{" +
        "cartId = " + cartId +
        ", dessertId = " + dessertId +
        ", userId = " + userId +
        ", quantity = " + quantity +
        ", speId = " + speId +
                ", tasteId = " + tasteId +
        "}";
    }
}
