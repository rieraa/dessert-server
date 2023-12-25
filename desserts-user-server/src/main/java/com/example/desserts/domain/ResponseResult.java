package com.example.desserts.domain;

import com.example.desserts.enums.BusinessCode;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 通用响应结果类，用于包装 API 接口返回的数据
 *
 * @param <T> 响应数据的类型
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private Integer code;  // 响应状态码
    private String msg;    // 响应消息
    private T data;        // 响应数据

    // 默认构造函数，使用默认的成功状态码和消息
    public ResponseResult() {
        this.code = BusinessCode.SUCCESS.getCode();
        this.msg = BusinessCode.SUCCESS.getMessage();
    }

    // 带有状态码和数据的构造函数
    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    // 带有状态码、消息和数据的构造函数
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 带有状态码和消息的构造函数
    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    // 创建默认的成功ResponseResult
    public static ResponseResult okResult() {
        ResponseResult result = new ResponseResult();
        return result;
    }

    // 创建指定状态码和消息的成功ResponseResult
    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }

    // 创建指定指定数据ResponseResult
    public static ResponseResult okResult(Object data) {
        // 添加成功的默认编码和默认消息
        ResponseResult result = setBusinessCodeMessage(BusinessCode.SUCCESS, BusinessCode.SUCCESS.getMessage());
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    // 自定义数据及消息
    public static ResponseResult okResult(BusinessCode enums, String msg, Object data) {
        // 添加成功的默认编码和默认消息
        ResponseResult result = setBusinessCodeMessage(enums, msg);
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    // 创建指定状态码和消息的错误 ResponseResult
    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }


    // 根据 BusinessCode 创建错误 ResponseResult
    public static ResponseResult errorResult(BusinessCode enums) {
        return setBusinessCodeMessage(enums, enums.getMessage());
    }

    // 工厂方法，用于根据 BusinessCode 和自定义消息创建错误 ResponseResult
    public static ResponseResult errorResult(BusinessCode enums, String msg) {
        return setBusinessCodeMessage(enums, msg);
    }

    // 工具方法，用于设置 BusinessCode 的成功 ResponseResult
    public static ResponseResult setBusinessCodeMessage(BusinessCode enums) {
        return okResult(enums.getCode(), enums.getMessage());
    }

    // 私有方法，用于设置包含自定义消息的 BusinessCode 的成功 ResponseResult
    private static ResponseResult setBusinessCodeMessage(BusinessCode enums, String msg) {
        return okResult(enums.getCode(), msg);
    }

    // 方法，用于设置错误状态码和消息
    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    // 方法，用于设置成功状态码和数据
    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    // 方法，用于设置成功状态码、数据和消息
    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    // 方法，用于设置成功数据
    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    // 获取状态码的方法
    public Integer getCode() {
        return code;
    }

    // 设置状态码的方法
    public void setCode(Integer code) {
        this.code = code;
    }

    // 获取消息的方法
    public String getMsg() {
        return msg;
    }

    // 设置消息的方法
    public void setMsg(String msg) {
        this.msg = msg;
    }

    // 获取数据的方法
    public T getData() {
        return data;
    }

    // 设置数据的方法
    public void setData(T data) {
        this.data = data;
    }
}
