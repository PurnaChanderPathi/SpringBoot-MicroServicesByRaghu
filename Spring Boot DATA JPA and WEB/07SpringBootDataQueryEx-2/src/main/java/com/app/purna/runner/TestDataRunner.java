package com.app.purna.runner;

import java.util.Arrays;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Book;
import com.app.purna.repo.BookRepository;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private BookRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.saveAll(
				Arrays.asList(
						new Book(101, "SBMS", "PURNA", 300.0, "Backend"),
						new Book(102, "Core", "PURNA", 200.0, "Backend"),
						new Book(103, "ADV", "ASHOK", 400.0, "Backend"),
						new Book(104, "REACT", null, 500.0, "FRONTEND"),
						new Book(105, "HTML", "PURNA", 600.0, "FRONTEND"),
						new Book(106, "CSS", null, 300.0, "FRONTEND"),
						new Book(107, "ANGULAR", "ASHOK", 800.0, "FRONTEND"),
						new Book(108, "SQL", "PURNA", 200.0, "Database")
						)
				);
		
//		repository.getBooksByAuthor("PURNA")
//		.forEach(System.out::println);
		
		repository.getBooksAuthorCost("PURNA",200.0)
		.forEach(System.out::println);
		
//		repository.getBooksAuthorCost("P%",200.0)
//		.forEach(System.out::println);
		
//		repository.getBookIds(Arrays.asList(101,102,103))
//		.forEach(System.out::println);
//		

		
	}
		

}
