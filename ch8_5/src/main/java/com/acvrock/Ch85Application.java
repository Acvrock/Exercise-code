package com.acvrock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存支持
@EnableCaching
public class Ch85Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch85Application.class, args);
    }
}
