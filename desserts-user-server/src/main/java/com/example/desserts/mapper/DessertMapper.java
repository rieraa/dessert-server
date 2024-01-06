package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Dessert;
import org.apache.ibatis.annotations.Mapper;

/**
 *  Mapper 接口
 *
 */
@Mapper
public interface DessertMapper extends BaseMapper<Dessert> {
}
