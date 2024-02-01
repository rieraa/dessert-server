package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.mapper.DeliveryAddressMapper;
import com.example.desserts.model.entity.DeliveryAddress;
import com.example.desserts.service.DeliveryAddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress> implements DeliveryAddressService {

    @Resource
    private DeliveryAddressMapper deliveryAddressMapper;


    @Override
    public List<DeliveryAddress> selectByUserId(Integer userId) {
        return deliveryAddressMapper.selectByUserId(userId);

    }

    /**
     * @param deliveryAddress
     * @return
     * @Description: 更新收货地址
     */
    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        UpdateWrapper<DeliveryAddress> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("da_id", deliveryAddress.getDaId());
        updateWrapper.eq("user_id", deliveryAddress.getUserId());
        return deliveryAddressMapper.update(deliveryAddress, updateWrapper);
    }

    @Override
    public int deleteByDeliveryAddressId(Integer deliveryAddressId) {
        return deliveryAddressMapper.deleteById(deliveryAddressId);

    }

    @Override
    public int addAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.insert(deliveryAddress);

    }
}
