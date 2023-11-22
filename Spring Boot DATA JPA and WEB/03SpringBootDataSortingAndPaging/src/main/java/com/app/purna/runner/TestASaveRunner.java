package com.app.purna.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Employee;
import com.app.purna.repo.EmployeCrudRepo;


@Component
@Order(10)
public class TestASaveRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeCrudRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		

		repo.saveAll(Arrays.asList(
				new Employee(10, "PS" ,200.0, "DEV"),
				new Employee(11, "PS" ,200.0, "QA"),
				new Employee(12, "PS" ,200.0, "BA"),
				new Employee(13, "PS" ,300.0, "DEV"),
				new Employee(14, "PS" ,300.0, "QA"),
				new Employee(15, "PS" ,300.0, "BA"),
				new Employee(16, "PS" ,400.0, "DEV"),
				new Employee(17, "PS" ,400.0, "QA"),
				new Employee(18, "PS" ,400.0, "DEV")
				)
			);
	}
		
	

}
