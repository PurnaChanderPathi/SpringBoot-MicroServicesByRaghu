package com.app.purna.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.purna.entity.Employee;
import com.app.purna.exception.EmployeeNotFoundException;

public interface IEmployeeService {

	Integer saveEmployee(Employee e);
	void updateEmployee(Employee e);
	void deleteEmployee(Integer id) throws EmployeeNotFoundException;
	Employee getOneEmployee(Integer id) throws EmployeeNotFoundException;
	List<Employee> getAllEmployee();
	Page<Employee> getAllEmployee(Pageable pageable);
}
