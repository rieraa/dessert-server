package com.example.desserts.service.impl;

import com.example.desserts.model.dto.DessertListDTO;
import com.example.desserts.service.DessertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DessertServiceTest {

    @Autowired
    private DessertService dessertService;

    @Test
    public void testGetDessertList() {
        // 指定你期望的页码和每页大小
        Integer pageNum = 2;

        // 调用服务方法
        DessertListDTO dessertListDTO = dessertService.getDessertList(pageNum, 100);
        System.out.println("🚀 ~ file:DessertServiceTest.java method:testGetDessertList line:22 -----dessertListDTO:" + dessertListDTO);
        // 这里可以根据你的业务逻辑和期望的结果进行断言
        // 例如，你可以检查返回的 DessertListDTO 是否包含了正确的数据，总记录数是否正确等等
    }
}
