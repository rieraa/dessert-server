package com.example.desserts.domain.DTO;

import lombok.Data;

/**
 * 用户登录请求体
 */
@Data
public class UserLoginDTO {

    private Integer userId;

    private String userName;

    private String password;

    private String token;

    private Integer isAdmin;


}
