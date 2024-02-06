package com.example.desserts.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "order_id", type = IdType.AUTO)

    private Integer orderId;

    private Integer userId;

    private String orderDate;

    private BigDecimal orderTotal;

    private Integer daId;

    private String remarks;


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
