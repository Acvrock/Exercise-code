package com.acvrock.eventbus;

import java.util.concurrent.CountDownLatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventBusTestApplication {
	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	public static void main(String... args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(EventBusTestApplication.class, args);

		final CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				closeLatch.countDown();
			}
		}));
		closeLatch.await();
	}

}
