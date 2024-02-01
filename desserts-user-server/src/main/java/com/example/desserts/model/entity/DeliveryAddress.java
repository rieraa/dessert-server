package com.example.desserts.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@TableName("deliveryAddress")
public class DeliveryAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "da_id", type = IdType.AUTO)
    private Integer daId;

    private String contactName;

    private Integer contactSex;

    private String contactTel;

    private String address;

    private Integer userId;



    @Override
    public String toString() {
        return "DeliveryAddress{" +
        "daId = " + daId +
        ", contactName = " + contactName +
        ", contactSex = " + contactSex +
        ", contactTel = " + contactTel +
        ", address = " + address +
        ", userId = " + userId +
        "}";
    }
}
