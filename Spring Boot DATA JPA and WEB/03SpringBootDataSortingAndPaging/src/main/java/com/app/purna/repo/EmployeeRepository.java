package com.app.purna.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.purna.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

	Iterable<Employee> findAll();


	

}
