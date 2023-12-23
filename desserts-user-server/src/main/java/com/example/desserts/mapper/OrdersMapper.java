package com.example.desserts.mapper;

import com.example.desserts.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-12-24
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
