package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Employee;

public interface EmployeCrudRepo extends JpaRepository<Employee, Integer> {

}
