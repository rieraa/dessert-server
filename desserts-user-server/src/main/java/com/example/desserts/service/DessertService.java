package com.example.desserts.service;

import com.example.desserts.model.vo.DessertDetailVO;
import com.example.desserts.model.vo.DessertListVO;
import com.example.desserts.model.entity.Dessert;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface DessertService extends IService<Dessert> {
    /**
     *  获取甜品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    DessertListVO getDessertList(Integer pageNum, Integer pageSize);


    DessertDetailVO getDessertDetail(Integer dessertId);
}
