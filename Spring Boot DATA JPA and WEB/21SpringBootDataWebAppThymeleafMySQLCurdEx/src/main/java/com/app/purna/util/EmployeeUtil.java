package com.app.purna.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;

//import org.springframework.stereotype.Component;

import com.app.purna.entity.Employee;
//after java 8 (static method and default methods)
//@Component
//public class EmployeeUtil {
public interface EmployeeUtil {
	//public void commonCal(Employee e)
	public static void commonCal(Employee e)
	{
		Double hra = e.getEmpSal()*(12.0/100);
		Double ta = e.getEmpSal()*(4.0/100);
		e.setEmpHra(hra);
		e.setEmpTa(ta);
		
	}
	public static void createDeptList(Model model)
	{
		List<String> list = Arrays.asList("DEV","QA","BA","ADMIN","IT");
		model.addAttribute("deptlist", list);
	}

}
