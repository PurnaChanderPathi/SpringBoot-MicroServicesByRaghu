package com.app.purna;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class TestDataRunner implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
//		Process p1 = new Process();
//		p1.setCode("AA");
//		p1.setId(8);
//		p1.setType("MODEL");
	
		Process p1 = 
				Process.builder()
				.code("AA")
				.id(88)
				.type("MODEL")
				.build();
	}

}
