package com.app.purna.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Product;
import com.app.purna.exception.ProductNotFoundException;
import com.app.purna.repo.ProductRepository;

@Component
public class TestOperationRunner implements CommandLineRunner {
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(repo.getClass().getName());
		
		Product p1 = new Product(10,"P1",200.0);
		Product p2 = new Product(11,"V1",300.0);
		Product p3 = new Product(12,"S1",400.0);
		
		
//		  repo.save(p1);
//		  repo.save(p2);
//		  repo.save(p3);
		
		repo.saveAll(Arrays.asList(p1,p2,p3));
		
		Iterable<Product> data = repo.findAll();
		//JDK 1.5 forEach Loop
		for(Product pob: data)
		{
			System.out.println(pob);
		}
		System.out.println("----------------------");
		//JDK 1.8 Default method + Lambda Expression
		data.forEach(ob -> System.out.println(ob));
		
		System.out.println("**********************");
		//JDK 1.8 Default method + Method Reference
		data.forEach( System.out::println);
		
		System.out.println(repo.existsById(11)); //true
		System.out.println(repo.existsById(3)); //false
		
		System.out.println(repo.count()); //  long -- no.of rows
		
		//----------------------------------------------//
		//fetch one row based on id
		Optional<Product> opt = repo.findById(11);
		if(opt.isPresent())
		{
			Product p = opt.get();
			System.out.println(p);
		}
		else
		{
			System.out.println("DATA NOT FOUND");
		}
		
		Product p = repo.findById(11)
		.orElseThrow(
				()->new ProductNotFoundException("NOT EXIST"));
		System.out.println(p);
		
		//------------------------------------
		Iterable<Product> list = repo.findAllById(Arrays.asList(10, 11, 33, 45, 67, 89, 54));
		list.forEach(System.out::println);
		
		//-------------------------------------------------------------
		//repo.deleteById(99);
//		repo.delete(
//				repo.findById(44).orElseThrow(
//						() -> new ProductNotFoundException(
//								String.format("%s not having %d", Product.class.getName(),44)
//									)
//								)
//							);
		//------------------------------------------
		repo.deleteAllById(Arrays.asList(11,12));
		repo.deleteAll();
		}

}
