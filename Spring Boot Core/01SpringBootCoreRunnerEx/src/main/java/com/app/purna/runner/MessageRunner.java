package com.app.purna.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class MessageRunner implements CommandLineRunner {
@Override
public void run(String... args) throws Exception {
	System.out.println("FROM RUNNER");
	
}
}
