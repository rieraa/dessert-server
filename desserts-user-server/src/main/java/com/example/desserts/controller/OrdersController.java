package com.example.desserts.controller;

import com.example.desserts.domain.DTO.CreateOrderDTO;
import com.example.desserts.domain.ResponseResult;
import com.example.desserts.service.OrdersService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新建订单
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    OrdersService ordersService;

    @PostMapping("/createOrder")
    public ResponseResult createOrder(HttpServletRequest request, @RequestBody CreateOrderDTO createOrderDTO) {
        int userId = UserIdExtractor.extractUserIdFromRequest(request);
        createOrderDTO.setUserId(userId);
        ordersService.createOrderAndClearCart(createOrderDTO);
        return ResponseResult.okResult();
    }

}
