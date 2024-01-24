package com.example.desserts.utils;


import com.example.desserts.enums.BusinessCode;
import com.example.desserts.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;

public class UserIdExtractor {

    public static Integer extractUserIdFromRequest(HttpServletRequest request) {
        // 从请求头中获取Authorization信息
        String authorizationHeader = request.getHeader("Authorization");

        // 从请求属性中获取userId信息
        Object userIdAttribute = request.getAttribute("userId");

        // 判断Authorization信息和userId属性是否存在
        if (authorizationHeader != null && userIdAttribute != null) {
            // 这里假设userId存储在请求属性中的时候是Integer类型
            return (Integer) userIdAttribute;
        }

        // 如果无法获取用户id，返回默认值或抛出异常
       throw new BusinessException(BusinessCode.TOKEN_INVALID);
    }
}
