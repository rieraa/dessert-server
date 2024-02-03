package com.example.desserts.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartListVO {


    private Integer userId;
    private Integer cartId;
    private Integer dessertId;
    private String dessertName;
    private BigDecimal unitPrice;
    private String speName;
    private String tasteName;


}
