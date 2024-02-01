package com.example.desserts.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.desserts.model.entity.DeliveryAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 收货地址 Mapper 接口
 *
 */
@Mapper
public interface DeliveryAddressMapper extends BaseMapper<DeliveryAddress> {
    // 通过用户id查询收货地址
    @Select("SELECT * FROM deliveryAddress where user_id = #{userId}")
    List<DeliveryAddress> selectByUserId(Integer userId);
}
