package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.purna.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	  @Transactional //we need to define on top of service layer
	  @Modifying	  
	  @Query("UPDATE Product SET prodName=:pn WHERE prodId=:pid ")
	  int updateNameById(String pn, Integer pid);
	  
	  @Transactional //we need to define on top of service layer
	  @Modifying	  
	  @Query("DELETE Product WHERE prodId=:pid ")
	  int removeById(Integer pid);
	 
	
}
