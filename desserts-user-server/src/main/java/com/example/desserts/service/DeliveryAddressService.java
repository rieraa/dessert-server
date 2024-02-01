package com.example.desserts.service;

import com.example.desserts.model.entity.DeliveryAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface DeliveryAddressService extends IService<DeliveryAddress> {

    List<DeliveryAddress> selectByUserId(Integer userId);

    int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    int deleteByDeliveryAddressId(Integer deliveryAddressId);

    int addAddress(DeliveryAddress deliveryAddress);
}
