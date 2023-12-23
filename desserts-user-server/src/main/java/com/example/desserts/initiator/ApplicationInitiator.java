package com.example.desserts.initiator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component

public class ApplicationInitiator implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("我是自定义执行！");
    }
}
