package com.example.desserts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.desserts.domain.DTO.AddCartDTO;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.vo.CartListVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface CartService extends IService<Cart> {

    List<CartListVO> getCartList(Integer userId);


    int addCart(Cart cart,int UserId);



}
