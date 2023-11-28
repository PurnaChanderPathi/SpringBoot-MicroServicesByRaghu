package com.app.purna.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.purna.entity.Book;

@Component
public class GetTextCRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//1 Create URL
		//String url = "http://localhost:8080/v1/api/book/showA";
		String url = "http://localhost:8080/v1/api/book/showC";
		
		//2. Create Request Headers 
		
		//3. Create Request Body
		
		// 2+3
		
		// 4 create RestTemplate Object
		RestTemplate template = new RestTemplate();
		
		//5. Make HTTP call and Get Response back 
		ResponseEntity<Book> responce =
				template.getForEntity(url, Book.class); //URL, ResponseFormat.class
				
				
		//6. print details 
		System.out.println(responce.getBody());
		System.out.println(responce.getHeaders());
		System.out.println(responce.getStatusCode().toString());
		//System.out.println(responce.getStatusCode().value());
	}


}
