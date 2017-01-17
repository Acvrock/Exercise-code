package com.acvrock.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by moon on 17/01/2017.
 *
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/")
    public String index() {
        log.info("hello");
        return "biu~~~";
    }
}
