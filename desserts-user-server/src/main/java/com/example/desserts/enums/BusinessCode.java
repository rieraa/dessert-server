package com.example.desserts.enums;

/**
 * 错误码枚举类
 */
public enum BusinessCode {
    // 通用错误码
    SUCCESS(2000, "操作成功"),
    SYSTEM_ERROR(1001, "系统错误"),
    PARAMS_ERROR(1002, "参数错误"),
    BUSINESS_ERROR(1003, "业务逻辑错误"),

    // 用户相关错误码
    USER_NOT_FOUND(2001, "用户不存在"),
    WRONG_PASSWORD(2002, "用户名或密码错误"),
    USERNAME_ALREADY_EXISTS(2003, "用户名已存在"),

    // 认证和授权错误码
    UNAUTHORIZED(3001, "未经授权"),
    TOKEN_EXPIRED(3002, "Token已过期"),
    USER_NOT_LOGIN(3003, "用户未登录"),
    TOKEN_INVALID(3004, "无效的Token"),

    // 商品相关错误码
    DESSERT_ADD_ERROR(4001, "购物车添加失败"),
    INSUFFICIENT_STOCK(4002, "库存不足");




    private final int code;
    private final String message;

    BusinessCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    public String getMessage() {
        return message;
    }

    // 如果需要其他辅助方法，可以在这里添加
}
