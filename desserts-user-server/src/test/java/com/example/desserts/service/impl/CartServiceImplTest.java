package com.example.desserts.service.impl;

import com.example.desserts.model.vo.CartListVo;
import com.example.desserts.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Test
    public void testCart() {
        // 调用服务方法
        List<CartListVo> listVoList  = cartService.getCartList(1);
        System.out.println("🚀 ~ file:CartServiceImplTest.java method:testCart line:19 -----listVoList:" + listVoList);
        // 这里可以根据你的业务逻辑和期望的结果进行断言
        // 例如，你可以检查返回的 DessertListVO 是否包含了正确的数据，总记录数是否正确等等
    }
}