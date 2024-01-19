package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
    //    异常处理方法的注解，当捕获到BusinessException类型的异常时，将执行这个方法
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<Object> handleBusinessException(BusinessException ex) {
        return new ResponseResult<>(ex.getCode(), ex.getDescription(), null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handleException(Exception ex) {
        return new ResponseResult<>(500, "系统异常，请联系管理员", null);
    }
}
