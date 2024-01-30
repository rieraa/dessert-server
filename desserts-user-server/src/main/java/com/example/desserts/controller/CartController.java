package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.service.CartService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/addCart")
    public ResponseResult addCart(HttpServletRequest request, @RequestBody Cart cart) {
        int userId = UserIdExtractor.extractUserIdFromRequest(request);
        if (cartService.addCart(cart, userId) == 1)
            return ResponseResult.okResult();
        return ResponseResult.errorResult(BusinessCode.DESSERT_ADD_ERROR);
    }
}
