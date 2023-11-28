package com.app.purna.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class PustTestARunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		String url = "http://localhost:8080/v1/api/book/showE";
		
		String body ="{\"bid\" : 101,   \"bname\" : \"ABC\", \"auth\":\"AJ\", \"bcost\":500.0}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> requesyEntity = new HttpEntity<String>(body, headers);
		
		RestTemplate rt = new RestTemplate();
		//this method makes request no body (void)
		//rt.put(url, requestEnitity);
		
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.PUT, requesyEntity, String.class);
		
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().toString());
	}

}
