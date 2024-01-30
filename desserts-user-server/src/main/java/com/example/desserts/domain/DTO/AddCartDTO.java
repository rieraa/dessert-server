package com.example.desserts.domain.DTO;

import lombok.Data;

/**
 * 添加购物车请求体
 */
@Data
public class AddCartDTO {

    private Integer dessertId;

    private Integer userId;

    private Integer quantity;

    private Integer speId;

    private Integer tasteId;
}
