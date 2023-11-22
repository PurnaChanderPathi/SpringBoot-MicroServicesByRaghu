package com.app.purna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class RestDataRunner implements CommandLineRunner {
	@Autowired
		private MyServiceData data;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(data);

	}

}
