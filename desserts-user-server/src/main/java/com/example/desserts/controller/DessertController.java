package com.example.desserts.controller;

import com.example.desserts.domain.DTO.AddDessertDTO;
import com.example.desserts.domain.ResponseResult;
import com.example.desserts.model.entity.Dessert;
import com.example.desserts.model.vo.DessertDetailVO;
import com.example.desserts.model.vo.DessertListVO;
import com.example.desserts.service.DessertService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 *
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
    ResponseResult getAllDessert(HttpServletRequest request, @RequestParam("page") int page, @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {

        // 调用DessertService中的方法获取甜品列表
        DessertListVO dessertList = dessertService.getDessertList(page, pageSize);

        return ResponseResult.okResult(dessertList);
    }


    @GetMapping("/getDessertById")
    ResponseResult getDessertById(HttpServletRequest request, @RequestParam("id") int dessertId) {

        // 调用DessertService中的方法获取甜品详情
        DessertDetailVO dessertList = dessertService.getDessertDetail(dessertId);

        return ResponseResult.okResult( dessertList);
    }


    @PostMapping("/addDessert")
    ResponseResult addDessert(@RequestBody AddDessertDTO addDessertDTO) {

        // 调用DessertService中的方法添加甜品
        dessertService.addDessert(addDessertDTO);

        return ResponseResult.okResult();
    }

    @PostMapping("/deleteDessert")
    ResponseResult deleteDessert(@RequestBody Dessert dessert) {

        // 调用DessertService中的方法删除甜品
        dessertService.deleteDessert(dessert.getDessertId());

        return ResponseResult.okResult();
    }
}
