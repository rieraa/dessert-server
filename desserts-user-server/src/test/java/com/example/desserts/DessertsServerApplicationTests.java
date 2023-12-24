package com.example.desserts;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.example.desserts.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class DessertsServerApplicationTests {

    @Resource
    UserService userService;

    @Resource
    DataSource source;

    @Test
    void listAllUsers() throws Exception {
        userService.query().list();
    }


    @Test
    void generate() {
        FastAutoGenerator
                .create(new DataSourceConfig.Builder(source))
                .globalConfig(builder -> {
                    builder.outputDir("src/main/java")//输出目录设置为当前项目的目录
                            .fileOverride();

                })
                .packageConfig(builder -> builder.parent("com.example.desserts"))
                .strategyConfig(builder -> {
                    builder
                            .mapperBuilder()
                            .mapperAnnotation(Mapper.class)
                            .build();
                })
                .execute();


    }

}
