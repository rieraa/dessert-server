package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseResult<Object> handleBusinessException(BusinessException ex) {
        return new ResponseResult<>(ex.getCode(), ex.getDescription(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult<Object> handleException(Exception ex) {
        return new ResponseResult<>(500, "Internal Server Error", null);
    }
}
