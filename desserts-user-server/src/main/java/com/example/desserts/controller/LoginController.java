package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.domain.request.UserLoginRequest;
import com.example.desserts.entity.User;
import com.example.desserts.enums.HttpCodeEnum;
import com.example.desserts.service.UserService;
import com.example.desserts.utils.JwtTokenUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController  // 可处理 HTTP 请求的控制器，并且能够返回数据给客户端
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    @Resource
    UserService userService;

    // 用户登录
    @PostMapping("/login")
    ResponseResult<UserLoginRequest> login(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        User user = new User();
        String userName = userLoginRequest.getUserName();
        String password = userLoginRequest.getPassword();

        // 查找是否有该用户
        User find = userService.userLogin(userName, password, request);

        // 创建 ResponseResult 对象用于响应
        ResponseResult<UserLoginRequest> responseResult = new ResponseResult<>();

        if (find == null) {
            return responseResult.errorResult(HttpCodeEnum.LOGIN_ERROR);
        } else {
            //用户密码正确
            String token = JwtTokenUtils.createToken(find);
            userLoginRequest.setToken(token);
            // 设置成功的响应
            return new ResponseResult<UserLoginRequest>(HttpCodeEnum.SUCCESS.getCode(), "登录成功", userLoginRequest);
        }
    }

    @GetMapping("/test")
    public int currentRegistrant(HttpServletRequest request) {
        // 从请求头中获取Authorization头部
        String authorizationHeader = request.getHeader("Authorization");
        int userId = (int) request.getAttribute("userId");

        return 200;

    }
}
