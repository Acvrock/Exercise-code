package com.acvrock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by moon on 17/01/2017.
 *
 * @Description:
 */
@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

    /**
     * 入口函数.
     * @param args args
     */
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public void run(String... args) throws Exception {
        log.info("  --- --- --- [ web started ] --- --- ---  ");
    }
}