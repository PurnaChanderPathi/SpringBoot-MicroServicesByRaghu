package com.app.purna.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSal;
	
	private Address addr; //HAS-A (inner JSON)
	
	private List<String> projects;
	
	private Map<String, Integer> codes;
}
