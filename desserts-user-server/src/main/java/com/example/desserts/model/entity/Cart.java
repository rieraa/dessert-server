package com.example.desserts.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
public class Cart implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Setter
    @TableId(value = "custom_id", type = IdType.AUTO)

    private Integer cartId;

    private Integer dessertId;

    private String userId;

    private Integer quantity;


    private Integer speId;




    @Override
    public String toString() {
        return "Cart{" +
        "cartId = " + cartId +
        ", dessertId = " + dessertId +
        ", userId = " + userId +
        ", quantity = " + quantity +
        ", speId = " + speId +
        "}";
    }
}
