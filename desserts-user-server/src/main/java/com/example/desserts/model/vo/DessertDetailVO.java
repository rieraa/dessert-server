package com.example.desserts.model.vo;

import com.example.desserts.model.entity.Dessert;
import com.example.desserts.model.entity.Specification;
import com.example.desserts.model.entity.Taste;
import lombok.Data;

import java.util.List;

@Data
public class DessertDetailVO extends Dessert {
    // 甜品规格列表
    List<Specification> specificationList;
    // 甜品口味列表
    List<Taste> tasteList;
}
