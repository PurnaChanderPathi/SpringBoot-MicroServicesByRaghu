package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Product;

public interface ProductRepository 
	extends JpaRepository<Product, Integer>{

}
