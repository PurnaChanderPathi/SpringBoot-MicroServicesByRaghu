package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
