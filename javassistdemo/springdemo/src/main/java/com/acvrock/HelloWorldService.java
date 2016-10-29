package com.acvrock;

import org.springframework.stereotype.Service;

/**
 * Created by moon on 28/10/2016.
 *
 * @Description:
 */
//	HelloWorldService是被SPRING托管的Bean
@Service
public class HelloWorldService {

    public void sayHello() {
        System.out.println("Hello World!");
    }
}