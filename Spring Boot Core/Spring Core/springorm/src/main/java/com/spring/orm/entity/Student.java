package com.spring.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@Column(name = "student_id")
	private int StudentId;
	@Column(name = "student_name")
	private String StudentName;
	@Column(name = "student_city")
	private String City;
	public Student(int studentId, String studentName, String city) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		City = city;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
