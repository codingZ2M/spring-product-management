package com.codingz2m.productmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductNotFoundExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> productNotFound(ProductNotFoundException exception,
			WebRequest request) {
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
										exception.getMessage() ); 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	

	
	
}