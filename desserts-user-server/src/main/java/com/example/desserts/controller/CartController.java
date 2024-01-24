package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.service.CartService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    public CartService cartService;

    @GetMapping("/getAllCart")
    ResponseResult getAllCart(HttpServletRequest request) {

        return ResponseResult.okResult(cartService.getCartList(UserIdExtractor.extractUserIdFromRequest(request)));
    }


}
