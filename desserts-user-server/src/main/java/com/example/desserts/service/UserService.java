package com.example.desserts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.desserts.domain.DTO.UserListDTO;
import com.example.desserts.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 用户模块服务
 */
public interface UserService extends IService<User> {

    /**
     * @param userName 用户名
     * @param password 用户密码
     * @description 用户登录服务
     */
    User userLogin(String userName, String password, HttpServletRequest request);

    /**
     * @param userName
     * @param password
     * @param checkPassword -确认密码
     * @return 新用户id
     */
    User userRegister(String userName, String password, String checkPassword,int userSex);


    UserListDTO allUser();

}
