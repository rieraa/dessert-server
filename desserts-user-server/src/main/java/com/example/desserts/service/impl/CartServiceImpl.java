package com.example.desserts.service.impl;

import com.example.desserts.entity.Cart;
import com.example.desserts.mapper.CartMapper;
import com.example.desserts.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
