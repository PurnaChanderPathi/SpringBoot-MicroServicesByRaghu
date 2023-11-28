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
public class PostTextARunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//1 Create URL
		//String url = "http://localhost:8080/v1/api/book/showA";
		String url = "http://localhost:8080/v1/api/book/showD";
		
		//2. Create Request Headers 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//3. Create Request Body
		String body ="{\"bid\" : 101,   \"bname\" : \"ABC\", \"auth\":\"AJ\", \"bcost\":500.0}";
		
		// 2+3 conbine both body and headers
		HttpEntity<String> requestEntity = new HttpEntity<>(body,headers);
		
		// 4 create RestTemplate Object
		RestTemplate template = new RestTemplate();
		
		//5. Make HTTP call and Get Response back 
		ResponseEntity<String> responce =
				//template.postForEntity(url, requestEntity, String.class); //URL, ResponseFormat.class
		template.exchange(url, HttpMethod.POST, requestEntity, String.class);
		//6. print details 
		System.out.println(responce.getBody());
		System.out.println(responce.getHeaders());
		System.out.println(responce.getStatusCode().toString());
		//System.out.println(responce.getStatusCode().value());
	}

}
