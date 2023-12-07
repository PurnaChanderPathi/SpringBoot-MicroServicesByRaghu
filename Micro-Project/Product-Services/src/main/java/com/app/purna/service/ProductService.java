package com.app.purna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.purna.dto.ProductRequest;
import com.app.purna.dto.ProductResponse;
import com.app.purna.entity.Product;
import com.app.purna.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public void createProduct(ProductRequest productRequest)
	{
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getName())
				.price(productRequest.getPrice())
				.build();
		repository.save(product);
		//log.info("Product '"+product.getId()+"' is saved");
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProduct() {
		
		List<Product> products = repository.findAll();	
		
		return products.stream().map(this::mapToProductResponse).toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
}
