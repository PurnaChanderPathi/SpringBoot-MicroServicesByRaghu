package com.app.purna.repo;


import org.springframework.data.repository.CrudRepository;

import com.app.purna.entity.Product;

public interface ProductRepository 
	extends CrudRepository<Product, Integer> {

}
