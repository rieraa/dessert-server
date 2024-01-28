package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Specification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 *  Mapper 接口
 *
 */
@Mapper
public interface SpecificationMapper extends BaseMapper<Specification> {

    @Select("SELECT * FROM specification WHERE dessert_id = #{dessertId}")
    List<Specification> selectByDessertId(@Param("dessertId") int dessertId);


}
