package com.example.desserts.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 */
@Data
public class UserRegisterRequest {

    private String userName;

    private String password;

    private String checkPassword;

}
