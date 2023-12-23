package com.example.desserts.controller;

import com.example.desserts.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/")
    public Student index() {
        return new Student(1, "小明", "男");

    }
}
