package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.model.entity.Cart;
import com.example.desserts.service.CartService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;


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
        return ResponseResult.errorResult(BusinessCode.CART_ADD_ERROR);
    }

    @DeleteMapping("/deleteCart")
    public ResponseResult deleteCart(@RequestBody Cart cart) {
        int result = cartService.deleteCart(cart.getCartId());
        if (result == 1)
            return ResponseResult.okResult();
        else if (result == 0)
            return ResponseResult.errorResult(BusinessCode.CART_NOT_EXIST);
        else
            return ResponseResult.errorResult(BusinessCode.CART_DELETE_ERROR);
    }
}
