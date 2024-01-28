package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Dessert;
import com.example.desserts.model.vo.DessertDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *  Mapper 接口
 *
 */
@Mapper
public interface DessertMapper extends BaseMapper<Dessert> {

@Select("SELECT * FROM dessert WHERE dessert_id = #{dessertId}")
    DessertDetailVO selectDetailById(@Param("dessertId") int dessertId);
}
