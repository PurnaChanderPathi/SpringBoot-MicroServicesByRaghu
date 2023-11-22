package com.app.purna.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Employee;
import com.app.purna.repo.EmployeeRepository;

@Component
public class TestDFetchPageRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
	
		//repository.findAll().forEach(System.out::println);
		
		//input
		Pageable p = PageRequest.of(44, 4);
		
		//output
		Page<Employee> page = repository.findAll(p);
		
		//result
		page.getContent().forEach(System.out::println); //List<T>
		
		//metadata
		System.out.println(page.isFirst());
		System.out.println(page.isLast());
		System.out.println(page.isEmpty());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(page.getSize());
		System.out.println(page.hasContent());
	}

}
