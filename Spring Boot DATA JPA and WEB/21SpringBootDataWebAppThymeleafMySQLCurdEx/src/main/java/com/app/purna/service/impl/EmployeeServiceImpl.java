package com.app.purna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.purna.entity.Employee;
import com.app.purna.exception.EmployeeNotFoundException;
import com.app.purna.repo.EmployeeRepository;
import com.app.purna.service.IEmployeeService;
import com.app.purna.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	//@Autowired
	//private EmployeeUtil util;
	
	@Override
	public Integer saveEmployee(Employee e) {
		//util.commonCal(e);
		EmployeeUtil.commonCal(e);
		e = repo.save(e);
		return e.getEmpId();
	}

	@Override
	public void updateEmployee(Employee e) {
		//util.commonCal(e);
		EmployeeUtil.commonCal(e);
		repo.save(e);

	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
		//repo.deleteById(id);
//		Optional<Employee> opt = repo.findById(id);
//		if(opt.isPresent())
//		{
//		repo.delete(opt.get());
//		} else
//		{
//			throw new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND");
//		}
//		repo.delete(repo.findById(id)
//				.orElseThrow(
//				()->new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND"))
//			);
		repo.delete(this.getOneEmployee(id));
	}

	@Override
	public Employee getOneEmployee(Integer id) throws EmployeeNotFoundException {
//		Optional<Employee> opt = repo.findById(id);
//		return opt.get();
		return repo.findById(id)
				.orElseThrow(
					()-> new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND")
						);
				
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public Page<Employee> getAllEmployee(Pageable pageable) {
		Page<Employee> pages = repo.findAll(pageable);
		return pages;
	}

}
