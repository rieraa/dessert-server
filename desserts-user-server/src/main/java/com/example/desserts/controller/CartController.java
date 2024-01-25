package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.service.CartService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getCartList")
    public ResponseResult getCartList(HttpServletRequest request) {
        int userId = UserIdExtractor.extractUserIdFromRequest(request);
        return ResponseResult.okResult(cartService.getCartList(userId));
    }
}
