package com.app.purna.bean;

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
	private String empPwd;
	private String empDept;
	private String empAddr;
}
