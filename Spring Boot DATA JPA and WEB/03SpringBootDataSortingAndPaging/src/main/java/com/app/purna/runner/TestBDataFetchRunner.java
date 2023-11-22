package com.app.purna.runner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


import com.app.purna.entity.Employee;
import com.app.purna.repo.EmployeeRepository;


//@Component
//@Order(20)
public class TestBDataFetchRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
	
		Iterable<Employee> list1 = repo.findAll();
		list1.forEach(System.out::println);
	 
	 
	 // case:- 1--1 column asc order
		//Iterable<Employee> list = repo.findAll(Sort.by("empSal")); //order by esal asc
		Iterable<Employee> list = repo.findAll(Sort.by(Direction.ASC,"empSal")); //order by esal asc
		 list.forEach(System.out::println);
		 
		 // case:- 2--1 column Desc order
		Iterable<Employee> list2 = repo.findAll(Sort.by(Direction.DESC,"empSal")); //order by esal Desc
			list2.forEach(System.out::println);
			
			// case:- 3--n column same order
			//Iterable<Employee> list3 = repo.findAll(Sort.by("empSal","empDept")); //order by esal asc, dept asc
			Iterable<Employee> list3 = repo.findAll( Sort.by(Direction.ASC,"empSal","empDept")); //order by esal desc, dept desc	
			list3.forEach(System.out::println);
			
			//------------------case4---- n columns -- mixed order ------
			repo.findAll(
					Sort.by(org.springframework.data.domain.Sort.Order.asc("empSal"),org.springframework.data.domain.Sort.Order.desc("empDept"))
					)
			.forEach(System.out::println);

	 
	 
	}

}
