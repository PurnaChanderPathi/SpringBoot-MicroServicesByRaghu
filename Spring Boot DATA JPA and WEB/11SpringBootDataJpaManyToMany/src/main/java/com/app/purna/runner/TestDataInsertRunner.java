package com.app.purna.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Course;
import com.app.purna.entity.Student;
import com.app.purna.repo.CourseRepository;
import com.app.purna.repo.StudentRepository;
@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Course c1 = new Course(50, "SpringBoot", 500.0);
		Course c2 = new Course(51, "Angular", 600.0);
		
		courseRepository.saveAll(Arrays.asList(c1,c2));
		
		Student s1 = new Student(10, "AJAY", "ajay@gmail.com", Arrays.asList(c1,c2));
		Student s2 = new Student(11, "SAM", "sam@gmail.com", Arrays.asList(c1,c2));
		
		studentRepository.saveAll(Arrays.asList(s1,s2));
	}

}
