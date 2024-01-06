package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.model.dto.DessertListDTO;
import com.example.desserts.service.DessertService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/dessert")
public class DessertController {

    @Resource
    DessertService dessertService;


    /**
     * 获取当前页的甜品列表
     *
     * @param request  - HTTP请求对象
     * @param page     - 当前页数
     * @param pageSize - 每页显示的数据条数（可选参数，默认为15）
     * @return 甜品列表和是否还有更多数据的DTO对象
     */
    @GetMapping("/getAllDessert")
     ResponseResult currentRegistrant(HttpServletRequest request,
                                            @RequestParam("page") int page,
                                            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {

        // 调用DessertService中的方法获取甜品列表
        DessertListDTO dessertList = dessertService.getDessertList(page, pageSize);

        return ResponseResult.okResult(BusinessCode.SUCCESS, "成功", dessertList);
    }
}
