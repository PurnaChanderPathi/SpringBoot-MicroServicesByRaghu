package com.app.purna.runner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Student;
import com.app.purna.repo.StudentRepository;

@Component
public class StudentTestRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		//to set format of date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String s = sdf.format(new Date());
		System.out.println(s);
		
		Student s1 = new Student();
		s1.setStdName("SAM");
		s1.setStdFee(400.0);
		s1.setStdDoj(new Date());
		repository.save(s1);
		
		List<Student> list = repository.findAll();
		System.out.println(list.getClass().getName());
		list.forEach(System.out::println);
		
		
		Student sob = new Student();
		sob.setStdFee(400.0);
		sob.setStdName("AJAY");
		Example<Student> prob = Example.of(sob);
		
		repository.findAll(prob).forEach( System.out::println);
	}

}
