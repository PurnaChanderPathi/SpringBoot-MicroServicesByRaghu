package com.app.purna.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Department;
import com.app.purna.entity.Employee;
import com.app.purna.repo.DepartmentRepository;
import com.app.purna.repo.EmployeeRepository;
@Component
public class TestDataInsertRunner implements CommandLineRunner {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Department d1 = new Department(1054, "DEV", "AJAY");
		Department d2 = new Department(1055, "QA", "SAM");
		Department d3 = new Department(1056, "BA", "KUMAR");
		departmentRepository.save(d1);
		departmentRepository.save(d2);
		departmentRepository.save(d3);
		
		//Department d1 = repo.findById(101).get();
		
		Employee e1 = new Employee(10, "SAM", 500.0, d1);
		Employee e2 = new Employee(11, "RAM", 600.0, d2);
		Employee e3 = new Employee(12, "SYED", 700.0, d1);
		Employee e4 = new Employee(13, "AJAY", 700.0, null);
	
		employeeRepository.save(e1);
		employeeRepository.save(e2);
		employeeRepository.save(e3);
		employeeRepository.save(e4);
		
		List<Object[]> list = employeeRepository.getEnameDeptNames();
		for(Object[] ob:list)
		{
			System.out.println(ob[0]+" --IS WORKING ON DEPT "+ob[1]);
		}
		
		List<Object[]> list2 = employeeRepository.getAllEnamesAndDeptNamesIfExist();
		for(Object[] ob:list2)
		{
			System.out.println(ob[0]+" --**************** "+ob[1]);
		}
		
		List<Object[]> list3 = employeeRepository.getAllDeptsAndENamesIfExist();
		for(Object[] ob:list3)
		{
			System.out.println(ob[0]+" --################### "+ob[1]);
		}
		
		//FUll OUTER JOIN NOT SUPPORTED
//		List<Object[]> list4 = employeeRepository.getALLData();
//		for(Object[] ob:list4)
//		{
//			System.out.println(ob[0]+" --??????---- "+ob[1]);
//		}
		
		List<Object[]> list4 = employeeRepository.getEnameDeptNames("DEV");
		for(Object[] ob:list4)
		{
			System.out.println(ob[0]+" --??????---- "+ob[1]);
		}
	}

}
