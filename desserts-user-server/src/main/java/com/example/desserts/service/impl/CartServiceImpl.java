package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.mapper.CartMapper;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.model.vo.CartListVO;
import com.example.desserts.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    public List<CartListVO> getCartList(Integer userId) {

        return cartMapper.selectCartGoodsByUserId(userId);
    }

    @Override
    public int addCart(Cart cart, int UserId) {
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", UserId);
        updateWrapper.eq("dessert_id", cart.getDessertId());
        updateWrapper.eq("spe_id", cart.getSpeId());
        updateWrapper.eq("taste_id", cart.getTasteId());
        updateWrapper.setSql("quantity = quantity + " + cart.getQuantity());

        int update = cartMapper.update(null, updateWrapper);
        System.out.println("🚀 ~ file:CartServiceImpl.java method:addCart line:37 -----update:" + update);
        if (update == 0) { // 如果没有更新到任何记录，那么插入新的记录
            cart.setUserId(UserId);
            return cartMapper.insert(cart);
        }
        return update;
    }

}
