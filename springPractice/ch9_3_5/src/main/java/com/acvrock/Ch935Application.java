package com.acvrock;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ch935Application implements CommandLineRunner{
	@Autowired
	RabbitTemplate rabbitTemplate; //1

    public static void main(String[] args) {
        SpringApplication.run(Ch935Application.class, args);
    }
    
    @Bean //2 第一次启动时定义队列，以后就不需要了
    public Queue wiselyQueue(){
        return new Queue("my-queue1");
    }
    

	@Override
	public void run(String... args) throws Exception {
		 rabbitTemplate.convertAndSend("my-queue1", "来自RabbitMQ的问候"); //3
	}
}
