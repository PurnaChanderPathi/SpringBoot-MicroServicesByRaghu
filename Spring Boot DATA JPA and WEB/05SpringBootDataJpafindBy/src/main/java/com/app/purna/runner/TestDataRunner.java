package com.app.purna.runner;

import java.util.Arrays;
import java.util.Optional;

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
//		repository.findByAuthor("ASHOK")
//		.forEach(System.out::println);
		
//		repository.findByauthorIs("PURNA")
//		.forEach(System.out::println);
//		
//		repository.findByBookType("FRONTEND")
//		.forEach(System.out::println);
		
		//repository.findByBookCostLessThanEqual(500.0)
		//repository.findByauthorIsNull()
		//repository.findByauthorIsNotNull()
		//.forEach(System.out::println);
		
		//-------------Like Operator------------
		//repository.findByAuthorLike("P%")
		//repository.findByAuthorLike("%S")
		//repository.findByAuthorLike("%R%")
		//repository.findByAuthorLike("_____")
		
		//StartingWith
//		repository.findByAuthorStartingWith("P")
//		.forEach(System.out::println);
		
		//EndingWith
//		repository.findByAuthorEndingWith("K")
//		.forEach(System.out::println);
		
		//Containing with
//		repository.findByAuthorContaining("R")
//		.forEach(System.out::println);
		
		// OR
//		repository.findByBookIdLessThanEqualOrBookTypeLike(105, "FRONT%")
//		.forEach(System.out::println);
		
		//And
		//repository.findByBookCostGreaterThanAndAuthorNotLike(500.0, "PURNA")
		//.forEach(System.out::println);
		
		// both And OR
		
	/*	repository.findByBookCostGreaterThanAndAuthorIsNotNullOrBookTypeLike(500.0, "PURNA", "FRONTEND")
		.forEach(System.out::println);*/
		
		System.out.println("----------");
		
//		repository.findByBookCostGreaterThanAndAuthorIsNotNullOrBookTypeLike(400.0,"ASHOK")
//		.forEach(System.out::println);
		
		Optional<Book> findById = repository.findById(105);
		if(findById.isPresent())
		System.out.println(findById.get());
		else
			System.out.println("No Data Found");
		
		
	}
		

}
