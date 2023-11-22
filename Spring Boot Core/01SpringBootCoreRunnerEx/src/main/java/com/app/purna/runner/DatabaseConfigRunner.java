package com.app.purna.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(15)
public class DatabaseConfigRunner implements CommandLineRunner {
@Override
public void run(String... args) throws Exception {
	System.out.println("Database Connection Runner");
	
}
}
