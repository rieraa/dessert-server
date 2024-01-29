package com.example.desserts.domain.DTO;

import lombok.Data;

/**
 * 用户注册请求体
 */
@Data
public class UserRegisterDTO {

    private String userName;

    private String password;

    private String checkPassword;

}
