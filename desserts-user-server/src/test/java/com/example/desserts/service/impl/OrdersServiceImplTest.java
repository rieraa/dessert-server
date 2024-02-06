package com.example.desserts.service.impl;

import com.example.desserts.domain.DTO.CreateOrderDTO;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.vo.CartListVO;
import com.example.desserts.service.OrdersService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrdersServiceImplTest {

    @Resource
    private OrdersService ordersService;

    @Test
    void createOrderAndClearCart() {
        // 订单请求
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setUserId(1);
        createOrderDTO.setDaId(1);
        createOrderDTO.setRemarks("备注1");

        // 被选中的购物车商品列表
        List<Cart> cartItems = new ArrayList<>();

        Cart item1 = new Cart();
        item1.setUserId(1);
        item1.setCartId(1);
        item1.setDessertId(1);
        item1.setQuantity(15);
        item1.setSpeId(1);
        item1.setUnitPrice(new BigDecimal("1.10"));
        cartItems.add(item1);

        Cart item2 = new Cart();
        item2.setUserId(1);
        item2.setCartId(3);
        item2.setDessertId(2);
        item2.setQuantity(15);
        item2.setTasteId(1);
        item2.setUnitPrice(new BigDecimal("1.30"));

        cartItems.add(item2);


        createOrderDTO.setCartItems(cartItems);

        ordersService.createOrderAndClearCart(createOrderDTO);

    }
}