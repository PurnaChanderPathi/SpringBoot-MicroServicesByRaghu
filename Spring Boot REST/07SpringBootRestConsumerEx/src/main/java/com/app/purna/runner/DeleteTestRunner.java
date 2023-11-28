package com.app.purna.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class DeleteTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		//URL
		String url = "http://localhost:8080/v1/api/book/showF/{id}";
		//Body, header =-> RequestEntity 
		//ResrTemplate
		RestTemplate rt = new RestTemplate();
		//make call
	//rt.delete(url,101);
		//print Response
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.DELETE, null, String.class,101);
		
		//Print Responce
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().toString());
	}

}
