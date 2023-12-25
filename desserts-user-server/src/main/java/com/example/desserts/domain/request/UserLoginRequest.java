package com.example.desserts.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 */
@Data
public class UserLoginRequest {

    private Integer userId;

    private String userName;

    private String password;

    private String token;


}
