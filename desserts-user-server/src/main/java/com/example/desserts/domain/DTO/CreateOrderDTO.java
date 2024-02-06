package com.example.desserts.domain.DTO;

import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.entity.Orders;
import com.example.desserts.model.vo.CartListVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderDTO extends Orders {
    private List<Cart> cartItems;
}
