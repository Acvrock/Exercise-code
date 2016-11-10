package com.acvrock;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@RabbitListener(queues = "my-queue1")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
