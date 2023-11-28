package com.app.purna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.purna.entity.Student;
import com.app.purna.exception.StudentNotFoundException;
import com.app.purna.repo.StudentRepository;
import com.app.purna.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student s) {
		 s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		if(s.getStdId()==null || !repo.existsById(s.getStdId()))
			throw new StudentNotFoundException("STUDENT '"+s.getStdId()+"' NOT EXIST");
		else
			repo.save(s);

	}

	@Override
	public void deleteStudent(Integer id) {
		repo.delete(getOneStudent(id));

	}

	@Override
	public Student getOneStudent(Integer id) {
		return repo.findById(id)
				.orElseThrow(
				()-> new StudentNotFoundException("Student with id: '"+id+"' Not Found")
				);
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = repo.findAll();
		return list;
	}

}
