package com.example.desserts.service.impl;

import com.example.desserts.model.entity.Orders;
import com.example.desserts.mapper.OrdersMapper;
import com.example.desserts.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
