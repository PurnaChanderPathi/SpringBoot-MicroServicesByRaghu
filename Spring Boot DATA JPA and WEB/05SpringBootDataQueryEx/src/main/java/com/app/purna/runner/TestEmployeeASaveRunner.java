package com.app.purna.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Employee;
import com.app.purna.repo.EmployeeRepository;

@Component
public class TestEmployeeASaveRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.saveAll(
				Arrays.asList(
						new Employee(101, "AA", 200.0, "DEV"),
						new Employee(102, "BA", 500.0, "DEV"),
						new Employee(103, "AC", 200.0, "QA"),
						new Employee(104, "DD", 400.0, "QA"),
						new Employee(105, "EF", 600.0, "DEV")
						)
				);
		//repository.getAllEmpNames()
		//repository.fetchAllEmps()
//		repository.fetchIdAndNames() //returns Object[]
//		.stream().map(obj -> obj[0]+ " : " + obj[1])
//		.forEach(System.out::println);
//		
//		Optional<String> opt = repository.getEmpNameById(101);
//		
//		if(opt.isPresent())
//			System.out.println(opt.get());
//		else
//			System.out.println("NO DATA ");
//		
//		Employee e = repository.fetchEmployeeById(104)
//		.orElseThrow(() -> new RuntimeException("Not Found"));
//		System.out.println(e);
	}

}
