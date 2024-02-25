package com.example.desserts.model.vo;

import com.example.desserts.model.entity.Cart;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class CartListVO extends Cart {

    private String dessertImg;
    private String dessertName;
    private String speName;
    private String tasteName;

}
