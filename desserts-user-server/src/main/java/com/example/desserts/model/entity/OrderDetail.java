package com.example.desserts.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
@TableName("orderDetail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "od_id", type = IdType.AUTO)
    private Integer odId;

    private Integer orderId;

    private Integer dessertId;

    private Integer quantity;

    private Integer speId;

    private Integer tasteId;

}
