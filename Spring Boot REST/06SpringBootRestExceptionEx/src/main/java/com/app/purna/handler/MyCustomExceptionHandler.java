package com.app.purna.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.purna.bean.MyErrorResponse;
import com.app.purna.exception.ProductNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {

//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<String> showCustomErrorMsg(
//			ProductNotFoundException pnfe)
//	{
//		
//		return new ResponseEntity<>(
//				pnfe.getMessage(),
//				HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showCustomErrorMsg(
			ProductNotFoundException pnfe)
	{
		
		return new ResponseEntity<MyErrorResponse>(
				new MyErrorResponse(new Date().toString(),
						"EXCEPTION IN PROCESS", 500,
						pnfe.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
