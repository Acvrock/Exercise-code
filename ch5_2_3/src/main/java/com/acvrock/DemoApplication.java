package com.acvrock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    //    常规属性配置
    @Value("${book.auther}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/book")
    String book() {
        return "book name is:" + bookName + " and book author is:" + bookAuthor;
    }
}
