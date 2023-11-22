package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Student;

public interface StudentRepository 
	extends JpaRepository<Student, Integer> {

}
