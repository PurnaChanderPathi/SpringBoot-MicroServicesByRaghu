package com.app.purna.runner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.app.purna.entity.Employee;
import com.app.purna.repo.EmployeeRepository;
//@Component
public class TestCFetchDataRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		//1. select * from employee order by empsal ASC
		Iterable<Employee> findAll = repository.findAll(Sort.by("empSal"));
		findAll.forEach(System.out::println);
		
		//2 select * from employee order by asal des
		//Iterable<Employee> findAll1 = repository.findAll(Sort.by("empSal").descending());
		Iterable<Employee> findAll1 = repository.findAll(Sort.by(Direction.DESC,"empSal"));
		findAll1.forEach(System.out::println);
		
		//3. select * from employee order by esal , dept; //both ASC
		//3. select * from employee order by esal , dept; //both DESC
		Iterable<Employee> findAll2 = repository.findAll(Sort.by("empSal","empDept"));
		findAll2.forEach(System.out::println);
		Iterable<Employee> findAll3 = repository.findAll(Sort.by(Direction.DESC,"empSal","empDept"));
		findAll3.forEach(System.out::println);
		
		//4. select * from employee order by esal ASC , dept DESC;
		Iterable<Employee> findAll4 = repository.findAll(Sort.by(Order.desc("empSal"),Order.asc("empDept")));
		findAll4.forEach(System.out::println);
	}

}
