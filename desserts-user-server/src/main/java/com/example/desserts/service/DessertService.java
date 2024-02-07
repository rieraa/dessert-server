package com.example.desserts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.desserts.domain.DTO.AddDessertDTO;
import com.example.desserts.model.entity.Dessert;
import com.example.desserts.model.vo.DessertDetailVO;
import com.example.desserts.model.vo.DessertListVO;

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


    void addDessert(AddDessertDTO addDessertDTO);

    void deleteDessert(Integer dessertId);
}
