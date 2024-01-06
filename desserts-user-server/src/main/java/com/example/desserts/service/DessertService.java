package com.example.desserts.service;

import com.example.desserts.model.dto.DessertListDTO;
import com.example.desserts.model.entity.Dessert;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface DessertService extends IService<Dessert> {
    DessertListDTO getDessertList(Integer pageNum, Integer pageSize);
}
