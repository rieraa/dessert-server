package com.example.desserts.enums;

/**
 * 错误码枚举类
 */
public enum BusinessCode {
    // 通用响应码
    SUCCESS(2000, "操作成功"),
    SYSTEM_ERROR(1001, "系统错误"),
    PARAMS_ERROR(1002, "参数错误"),
    BUSINESS_ERROR(1003, "业务逻辑错误"),

    // 用户相关响应码
    USER_NOT_FOUND(2001, "用户不存在"),
    WRONG_PASSWORD(2002, "用户名或密码错误"),
    USERNAME_ALREADY_EXISTS(2003, "用户名已存在"),

    // 认证和授权响应码
    UNAUTHORIZED(3001, "未经授权"),
    TOKEN_EXPIRED(3002, "Token已过期"),
    USER_NOT_LOGIN(3003, "用户未登录"),
    TOKEN_INVALID(3004, "无效的Token"),

    // 商品相关响应码
    CART_ADD_ERROR(4001, "购物车添加失败"),
    CART_DELETE_ERROR(4002, "购物车删除失败"),
    CART_NOT_EXIST(4003, "当前购物车记录不存在"),


    // 地址相关响应码
    ADDRESS_ADD_ERROR(5001, "地址添加失败"),
    ADDRESS_UPDATE_ERROR(5002, "地址更新失败"),

    ADDRESS_DELETE_ERROR(5003, "地址删除失败"),
    ADDRESS_SELECT_ERROR(5004, "地址查询失败"),


    // 订单相关响应码
    ORDER_NOT_FOUND(6001, "该用户还没有订单");




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
