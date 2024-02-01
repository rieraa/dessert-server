package com.example.desserts.service.impl;

import com.example.desserts.model.entity.DeliveryAddress;
import com.example.desserts.service.DeliveryAddressService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeliveryAddressServiceImplTest {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @Test
    void selectByUserId() {
        deliveryAddressService.selectByUserId(1);
    }

    @Test
    void updateByDeliveryAddressId() {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setDaId(1);
        deliveryAddress.setContactName("test");
        deliveryAddress.setContactSex(1);
        deliveryAddress.setContactTel("123456789");
        deliveryAddress.setAddress("test");
        deliveryAddress.setUserId(1);

        deliveryAddressService.updateDeliveryAddress(deliveryAddress);
    }

    @Test
    void deleteByDeliveryAddressId() {
        deliveryAddressService.deleteByDeliveryAddressId(3);
    }

    @Test
    void insert() {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setContactName("test");
        deliveryAddress.setContactSex(1);
        deliveryAddress.setContactTel("123456789");
        deliveryAddress.setAddress("insert");
        deliveryAddress.setUserId(1);

        deliveryAddressService.addAddress(deliveryAddress);
    }
}