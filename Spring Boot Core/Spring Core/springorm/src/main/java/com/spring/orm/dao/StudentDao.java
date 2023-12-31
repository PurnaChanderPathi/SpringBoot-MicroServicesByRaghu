package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.spring.orm.entity.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//save Student
	@Transactional
	public int insert(Student student)
	{
		//insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i; 
	}
	
	//get the single data(object)
	public Student getStudent(int StudentId)
	{
		Student student=  this.hibernateTemplate.get(Student.class,StudentId);
		return student;
		
	}
	
	//get all Students
	public List<Student> getAllStudents()
	{
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	//delete single student
	@Transactional
	public void deleteStudent(int StudentId)
	{
		Student student = this.hibernateTemplate.get(Student.class,StudentId);
		this.hibernateTemplate.delete(student);
	}
	
	//update Student
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
