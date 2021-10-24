package com.jubo.springboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/05/29
 */
@SpringBootApplication
@MapperScan("com.jubo.springboot01")
public class SpringBoot01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01Application.class, args);
    }

}
