package com.example.desserts.exception;

import com.example.desserts.enums.BusinessCode;

/**
 * 自定义业务异常类
 */
public class BusinessException extends RuntimeException {
    private final int code;
    private final String description;

    /**
     * 构造函数
     *
     * @param errorMessage 异常消息
     * @param code         错误码
     * @param description  错误描述
     */
    public BusinessException(String errorMessage, int code, String description) {
        super(errorMessage);
        this.code = code;
        this.description = description;
    }

    /**
     * 使用 BusinessCode 构造异常
     *
     * @param businessCode 错误码枚举
     */
    public BusinessException(BusinessCode businessCode) {
        super(businessCode.getMessage());
        this.code = businessCode.getCode();
        this.description = businessCode.getMessage();
    }

    /**
     * 使用 BusinessCode 和自定义描述构造异常
     *
     * @param businessCode   错误码枚举
     * @param description 自定义错误描述
     */
    public BusinessException(BusinessCode businessCode, String description) {
        super(businessCode.getMessage());
        this.code = businessCode.getCode();
        this.description = description;
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
     * 获取错误描述
     *
     * @return 错误描述
     */
    public String getDescription() {
        return description;
    }
}
