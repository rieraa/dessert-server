package com.example.desserts.domain;

import com.example.desserts.enums.HttpCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

// JsonInclude 注解用于在 JSON 序列化时排除空字段
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    // 默认构造函数，使用默认的成功状态码和消息
    public ResponseResult() {
        this.code = HttpCodeEnum.SUCCESS.getCode();
        this.msg = HttpCodeEnum.SUCCESS.getMsg();
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

    // 工厂方法，用于创建指定状态码和消息的错误 ResponseResult
    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    // 工厂方法，用于创建默认成功的 ResponseResult
    public static ResponseResult okResult() {
        ResponseResult result = new ResponseResult();
        return result;
    }

    // 工厂方法，用于创建指定状态码和消息的成功 ResponseResult
    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }

    // 工厂方法，用于创建包含数据的成功 ResponseResult
    public static ResponseResult okResult(Object data) {
        ResponseResult result = setAppHttpCodeEnum(HttpCodeEnum.SUCCESS, HttpCodeEnum.SUCCESS.getMsg());
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    // 工厂方法，用于根据 HttpCodeEnum 创建错误 ResponseResult
    public static ResponseResult errorResult(HttpCodeEnum enums) {
        return setAppHttpCodeEnum(enums, enums.getMsg());
    }

    // 工厂方法，用于根据 HttpCodeEnum 和自定义消息创建错误 ResponseResult
    public static ResponseResult errorResult(HttpCodeEnum enums, String msg) {
        return setAppHttpCodeEnum(enums, msg);
    }

    // 工具方法，用于设置 HttpCodeEnum 的成功 ResponseResult
    public static ResponseResult setAppHttpCodeEnum(HttpCodeEnum enums) {
        return okResult(enums.getCode(), enums.getMsg());
    }

    // 私有方法，用于设置包含自定义消息的 HttpCodeEnum 的成功 ResponseResult
    private static ResponseResult setAppHttpCodeEnum(HttpCodeEnum enums, String msg) {
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
