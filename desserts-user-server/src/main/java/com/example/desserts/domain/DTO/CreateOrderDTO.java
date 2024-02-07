package com.example.desserts.domain.DTO;

import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO extends Orders {
    private List<Cart> cartItems;
}
