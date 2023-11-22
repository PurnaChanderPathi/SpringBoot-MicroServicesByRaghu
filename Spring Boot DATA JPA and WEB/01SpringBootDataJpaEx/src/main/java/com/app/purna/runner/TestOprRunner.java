package com.app.purna.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Student;
import com.app.purna.repo.StudentRepository;

@Component
public class TestOprRunner implements CommandLineRunner {
	@Autowired
	private StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(repo.getClass().getName());
		
		Student sob = new Student();
		sob.setStdId(99);
		sob.setStdName("CHANDU");
		sob.setStdFee(40000.0);
		
		repo.save(sob); // INSERT OR UPDATE

	}

}
