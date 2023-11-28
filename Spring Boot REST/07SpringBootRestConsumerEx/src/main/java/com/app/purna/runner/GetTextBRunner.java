package com.app.purna.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class GetTextBRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//1 Create URL
		String url = "http://localhost:8080/v1/api/book/showB/{id}/{name}";
		
		//2. Create Request Headers 
		
		//3. Create Request Body
		
		// 2+3
		
		// 4 create RestTemplate Object
		RestTemplate template = new RestTemplate();
		
		//5. Make HTTP call and Get Response back 
		ResponseEntity<String> responce =
				//template.getForEntity(url, String.class,101,"ABC"); // path variables
				template.exchange(url, HttpMethod.GET, null, String.class, 101,"ABC");
		//6. print details 
		System.out.println(responce.getBody());
		System.out.println(responce.getHeaders());
		System.out.println(responce.getStatusCode().toString());
		//System.out.println(responce.getStatusCode().value());
	}

}
