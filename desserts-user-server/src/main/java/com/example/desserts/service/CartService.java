package com.example.desserts.service;

import com.example.desserts.model.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.desserts.model.vo.CartListVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface CartService extends IService<Cart> {

    List<CartListVo> getCartList(Integer userId);



}
