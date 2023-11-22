package com.app.purna.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.purna.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select DEPT, Count(DEPT) from emptesttab Group by empDapt")
	List<Object> getCountByDept();
}
