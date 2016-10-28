package com.acvrock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);

//        new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");

        // Instantiate class by new'ing it up. i.e., Do not obtain from Spring context
        HelloWorldClient client = new HelloWorldClient();
        client.sayHello();
    }



}
