package com.spring.jdbc.deo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDeo")
public class StudentDeoImpl implements StudentDeo {
	
	@Autowired
	private JdbcTemplate jtm;

	public int insert(Student student) {
		//insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        int r = this.jtm.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	public int change(Student student) {
	//update
		String query = "update student set name=? , city=? where id=? ";
		int update = this.jtm.update(query,student.getName(),student.getCity(),student.getId());
		return update;
	}
	
	public int delete(Student student) {
		//delete
		String query = "delete from student where id=?";
		int delete = this.jtm.update(query,student.getId());
		return delete;
	}

	public Student getStudent(int studentId) {
		//selecting single Student
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jtm.queryForObject(query, rowMapper,studentId);
		return student;
	}
	
	public List<Student> getAllStudents() {
		//selecting Multiple Students
		String query ="select * from student";
		List<Student> students = this.jtm.query(query, new RowMapperImpl());
		return students;
	}


	public JdbcTemplate getJtm() {
		return jtm;
	}

	public void setJtm(JdbcTemplate jtm) {
		this.jtm = jtm;
	}

	public StudentDeoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDeoImpl(JdbcTemplate jtm) {
		super();
		this.jtm = jtm;
	}



}
