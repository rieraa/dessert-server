package com.example.desserts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //包含所有属性的构造方法
public class Student {
    int sid;
    String name;
    String sex;
}
