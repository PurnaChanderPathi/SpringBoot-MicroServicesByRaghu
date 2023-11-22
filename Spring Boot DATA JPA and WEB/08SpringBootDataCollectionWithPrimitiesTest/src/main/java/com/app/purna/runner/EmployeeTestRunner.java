package com.app.purna.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Employee;
import com.app.purna.repo.EmployeeRepository;

@Component
public class EmployeeTestRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.saveAll( Arrays.asList(
				new Employee(10, "A", 300.0, "DEV"),
				new Employee(11, "B", 400.0, "DEV"),
				new Employee(12, "C", 300.0, "QA"),
				new Employee(13, "D", 400.0, "QA"))
				);
		
		repository.getCountByDept()
		.forEach(System.out::println);

	}

}
