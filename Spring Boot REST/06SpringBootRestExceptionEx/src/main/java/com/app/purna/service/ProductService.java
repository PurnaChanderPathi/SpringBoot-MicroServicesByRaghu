package com.app.purna.service;

import org.springframework.stereotype.Service;

import com.app.purna.entity.*;
import com.app.purna.exception.ProductNotFoundException;
@Service
public class ProductService {

	public Product getOneProductById(Integer id) {
		if(id==150)
			return new Product(id, "DUMMY");
		else
			throw new ProductNotFoundException("PRODUCT '"+id+"' NOT EXIST");
		

	}


	



}
