package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.domain.DTO.UserLoginDTO;
import com.example.desserts.domain.DTO.UserRegisterDTO;
import com.example.desserts.model.entity.User;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.service.UserService;
import com.example.desserts.utils.JwtTokenUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 用户模块
 */

// 可处理 HTTP 请求的控制器，并且能够返回数据给客户端
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;


    @PostMapping("/register")
    ResponseResult register(@RequestBody UserRegisterDTO userRegisterRequest) {

        String userName = userRegisterRequest.getUserName();
        String password = userRegisterRequest.getPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();

        User user = userService.userRegister(userName, password, checkPassword);
        user.setPassword(null);

        return ResponseResult.okResult(BusinessCode.SUCCESS, "注册成功", user);

    }

    /**
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/login")
    ResponseResult<UserLoginDTO> login(@RequestBody UserLoginDTO userLoginRequest, HttpServletRequest request) {
        User user = new User();
        String userName = userLoginRequest.getUserName();
        String password = userLoginRequest.getPassword();

        // 获取到用户信息
        User find = userService.userLogin(userName, password, request);


        String token = JwtTokenUtils.createToken(find);
        userLoginRequest.setToken(token);
        userLoginRequest.setUserId(find.getUserId());
        userLoginRequest.setPassword(null);
        // 设置成功的响应
        return ResponseResult.okResult(BusinessCode.SUCCESS, "登录成功", userLoginRequest);

    }

    @GetMapping("/test")
    public int currentRegistrant(HttpServletRequest request) {
        // 从请求头中获取Authorization头部
        String authorizationHeader = request.getHeader("Authorization");
        int userId = (int) request.getAttribute("userId");

        return 200;

    }
}
