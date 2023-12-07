package com.app.purna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.app.purna.dto.ProductRequest;
import com.app.purna.dto.ProductResponse;
import com.app.purna.service.ProductService;


@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct( @RequestBody ProductRequest productrequest)
	{
		service.createProduct(productrequest);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductResponse> getAllProduct()
	{
		//@RequestHeader("loggedInUser") String username
//		System.out.println("logged in user details" +username);
		return service.getAllProduct();
	}
	
}
