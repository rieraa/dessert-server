package com.example.desserts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.desserts.model.entity.Orders;
import com.example.desserts.model.vo.DessertDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("SELECT * FROM orders WHERE user_id = #{userId}")
    List<Orders> selectOrderList(@Param("userId") int userId);


}
