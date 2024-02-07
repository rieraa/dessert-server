package com.example.desserts.controller;

import com.example.desserts.domain.DTO.CreateOrderDTO;
import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.model.entity.Orders;
import com.example.desserts.service.OrdersService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 新建订单
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    OrdersService ordersService;

    @PostMapping("/createCartOrder")
    public ResponseResult createCartOrder(HttpServletRequest request, @RequestBody CreateOrderDTO createOrderDTO) {
        int userId = UserIdExtractor.extractUserIdFromRequest(request);
        createOrderDTO.setUserId(userId);
        ordersService.createOrderAndClearCart(createOrderDTO);
        return ResponseResult.okResult();
    }

    @PostMapping("/addOrder")
    public ResponseResult addOrder(HttpServletRequest request, @RequestBody CreateOrderDTO createOrderDTO) {
        int userId = UserIdExtractor.extractUserIdFromRequest(request);
        createOrderDTO.setUserId(userId);
        ordersService.createOrder(createOrderDTO);
        return ResponseResult.okResult();
    }

    @GetMapping("/getOrderList")
    public ResponseResult getOrderList(HttpServletRequest request) {
        int userId = UserIdExtractor.extractUserIdFromRequest(request);
        List<Orders> ordersList = ordersService.selectOrderList(userId);

        if (ordersList == null || ordersList.isEmpty()) {
            return ResponseResult.errorResult(BusinessCode.ORDER_NOT_FOUND);
        }

        return ResponseResult.okResult(ordersService.selectOrderList(userId));
    }
}
