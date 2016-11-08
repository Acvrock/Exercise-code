package com.acvrock;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "my-destination") //1
	public void receiveMessage(String message) {
		System.out.println("111接受到: <" + message + ">");
	}

	@JmsListener(destination = "my-destination") //1
	public void receiveMessage2(String message) {
		System.out.println("222接受到: <" + message + ">");
	}

}
