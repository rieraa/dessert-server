package com.example.desserts.service;

import com.example.desserts.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 *  用户模块服务
 *
 */
public interface UserService extends IService<User> {

    /**
     * @description 用户登录服务
     * @param userName  用户名
     * @param password 用户密码
     */
    User userLogin(String userName, String password, HttpServletRequest request);

}
