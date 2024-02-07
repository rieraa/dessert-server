package com.example.desserts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.desserts.domain.DTO.CreateOrderDTO;
import com.example.desserts.model.entity.Orders;

import java.util.List;

/**
 *
 *  订单服务类
 *
 */
public interface OrdersService extends IService<Orders> {

    void createOrderAndClearCart(CreateOrderDTO createOrderDTO);

    void createOrder(CreateOrderDTO createOrderDTO);

    List<Orders> selectOrderList(int userId);


}
