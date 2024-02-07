package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.domain.DTO.CreateOrderDTO;
import com.example.desserts.mapper.CartMapper;
import com.example.desserts.mapper.OrderdetailetMapper;
import com.example.desserts.mapper.OrdersMapper;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.entity.OrderDetail;
import com.example.desserts.model.entity.Orders;
import com.example.desserts.service.OrdersService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 *  订单服务实现类
 *
 */
@Slf4j
@Transactional // 如果在任何步骤中出现错误，整个操作都会回滚
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OrderdetailetMapper orderdetailetMapper;

    @Resource
    private CartMapper cartMapper;

    /**
     * @Description: 购物车中下单
     */
    @Override
    public void createOrderAndClearCart(CreateOrderDTO createOrderDTO) {
        // 从购物车中删除已经下单的商品
        for (Cart cartItem : createOrderDTO.getCartItems()) {
            cartMapper.deleteById(cartItem.getCartId());
        }
    }

    /**
     * @param createOrderDTO
     * @Description: 商品详情中下单
     */
    @Override
    public void createOrder(CreateOrderDTO createOrderDTO) {
        createOrderFromCartItems(createOrderDTO);
    }

    /**
     * @param createOrderDTO
     * @Description: 公共方法，创建订单
     */
    private void createOrderFromCartItems(CreateOrderDTO createOrderDTO) {
        Orders orders = new Orders();
        // 所有购物车中被选中的商品
        List<Cart> cartItems = createOrderDTO.getCartItems();
        // 计算该订单总金额
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Cart item : cartItems) {
            BigDecimal subTotal = item.getUnitPrice().multiply(new BigDecimal(item.getQuantity()));
            totalAmount = totalAmount.add(subTotal);
        }
        log.info("totalAmount:{}", totalAmount);
        orders.setUserId(createOrderDTO.getUserId());
        orders.setDaId(createOrderDTO.getDaId());
        orders.setRemarks(createOrderDTO.getRemarks());
        orders.setOrderDate(createOrderDTO.getOrderDate());
        orders.setOrderTotal(totalAmount);

        // 插入订单记录
        ordersMapper.insert(orders);
        int orderId = orders.getOrderId();


        // 对于购物车中的每个商品，创建一个新的订单详情记录
        for (Cart cartItem : cartItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setDessertId(cartItem.getDessertId());
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setSpeId(cartItem.getSpeId());
            orderDetail.setTasteId(cartItem.getTasteId());
            orderdetailetMapper.insert(orderDetail);
        }

    }

    @Override
    public List<Orders> selectOrderList(int userId) {
        return ordersMapper.selectOrderList(userId);
    }
}
