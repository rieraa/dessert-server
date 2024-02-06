package com.example.desserts.service;

import com.example.desserts.domain.DTO.CreateOrderDTO;
import com.example.desserts.model.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 *  订单服务类
 *
 */
public interface OrdersService extends IService<Orders> {

    void createOrderAndClearCart(CreateOrderDTO createOrderDTO);


}
