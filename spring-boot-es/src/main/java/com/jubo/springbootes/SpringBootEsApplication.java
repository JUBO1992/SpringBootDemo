package com.jubo.springbootes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JUBO
 */
@SpringBootApplication
@MapperScan("com.jubo.springbootes.model.mapper")
public class SpringBootEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEsApplication.class, args);
    }

}
