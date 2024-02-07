package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Taste;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  甜品口味Mapper 接口
 *
 */
@Mapper
public interface TasteMapper extends BaseMapper<Taste> {

    @Select("SELECT * FROM taste WHERE dessert_id = #{dessertId}")
    List<Taste> selectByDessertId(@Param("dessertId") int dessertId);

    @Delete("DELETE FROM taste WHERE dessert_id = #{dessertId}")
    void deleteByDessertId(@Param("dessertId") int dessertId);

}
