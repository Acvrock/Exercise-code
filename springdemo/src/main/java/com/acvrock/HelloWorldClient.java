package com.acvrock;

/**
 * Created by moon on 28/10/2016.
 *
 * @Description:
 */

//    HelloWorldClient依赖
//            HelloWorldService

public class HelloWorldClient {

    private HelloWorldService service;

    public void sayHello() {

        service.sayHello();
    }
}
