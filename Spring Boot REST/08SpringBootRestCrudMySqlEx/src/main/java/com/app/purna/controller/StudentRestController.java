package com.app.purna.controller;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;

import javax.management.ServiceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.purna.entity.Student;
import com.app.purna.exception.StudentNotFoundException;
import com.app.purna.service.IStudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	//1. create one student
	@PostMapping("/create")
	public ResponseEntity<String> createStudent( 
			@RequestBody Student student)
	{
		Integer id = service.saveStudent(student);
		String message = "Student '"+id+"' Created!";
		
		//return new ResponseEntity<String>(message,HttpStatus.OK);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	
	//2. fetch all students
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> list = service.getAllStudents();
		//return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		return ResponseEntity.ok(list);
	}
	
	//3. fetch one by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getStudentById(
			@PathVariable("id") Integer id )
	{
		ResponseEntity<Student> response =null;
		try {
			 Student s = service.getOneStudent(id);
		 response= ResponseEntity.ok(s);
			
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		return response;
	}
	
	//4. remove one by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(
			@PathVariable("id") Integer id
			)
	{
		ResponseEntity<String> response = null;
		try {
			service.deleteStudent(id);
			 response = ResponseEntity.ok("Student '"+id+"' Removed");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		return response;
	}
	
	//5. update student 
	@PutMapping("modify")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student
			)
	{
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			 response = ResponseEntity.ok("Student '"+student.getStdId()+"' updated");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
			return response;
	}
}
