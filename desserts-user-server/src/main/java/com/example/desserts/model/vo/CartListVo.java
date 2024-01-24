package com.example.desserts.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartListVo {


    private Integer userId;
    private Integer cartId;
    private Integer dessertId;
    private String dessertName;
    private BigDecimal dessertPrice;
    private String specificationName;


}
