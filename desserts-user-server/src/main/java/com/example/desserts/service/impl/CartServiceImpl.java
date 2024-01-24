package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.mapper.CartMapper;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.vo.CartListVo;
import com.example.desserts.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    public List<CartListVo> getCartList(Integer userId) {

        return cartMapper.selectCartGoodsByUserId(userId);
    }
}
