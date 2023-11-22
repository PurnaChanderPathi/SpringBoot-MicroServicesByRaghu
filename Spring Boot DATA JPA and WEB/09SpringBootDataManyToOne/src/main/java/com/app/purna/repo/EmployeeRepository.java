package com.app.purna.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.purna.entity.Employee;

public interface EmployeeRepository 
	extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT emp.empName,dept.deptName FROM Employee emp INNER JOIN emp.dpt as dept ")
	List<Object[]> getEnameDeptNames();
	
	//@Query("SELECT emp.empName,dept.deptName FROM Employee emp LEFT OUTER JOIN emp.dpt as dept ")
	@Query("SELECT emp.empName,dept.deptName FROM Employee emp LEFT OUTER JOIN emp.dpt as dept WHERE dept IS NULL ")
	List<Object[]> getAllEnamesAndDeptNamesIfExist();
	
	//@Query("SELECT emp.empName,dept.deptName FROM Employee emp RIGHT OUTER JOIN emp.dpt as dept ")
	@Query("SELECT emp.empName,dept.deptName FROM Employee emp RIGHT OUTER JOIN emp.dpt as dept WHERE emp IS NULL")
	List<Object[]> getAllDeptsAndENamesIfExist();
	
	@Query("SELECT emp.empName,dept.deptName FROM Employee emp FULL JOIN emp.dpt as dept ")
	List<Object[]> getALLData();
	
	@Query("SELECT emp.empName,dept.deptName FROM Employee emp INNER JOIN emp.dpt as dept WHERE deptName=:deptName ")
	List<Object[]> getEnameDeptNames(String deptName);
	
	

}
