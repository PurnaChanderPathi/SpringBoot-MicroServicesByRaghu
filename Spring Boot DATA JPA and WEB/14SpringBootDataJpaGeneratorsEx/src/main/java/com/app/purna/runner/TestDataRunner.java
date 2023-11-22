package com.app.purna.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.purna.entity.Product;
import com.app.purna.repo.ProductRepository;
@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*repository.save(new Product(101, "AA", 200.0));
		System.out.println("__________________________");
		
		
		  int count = repository.updateNameById("PEN", 101);
		  System.out.println(count);*/
		  
			/*
			 * int count2 = repository.removeById(101); System.out.println(count2);
			 */
		Product p1 = new Product();
		p1.setProdName("PENCIL");
		p1.setProdCost(200.0);
		
		p1 = repository.save(p1);
		System.out.println(p1.getProdId());
	}

}
