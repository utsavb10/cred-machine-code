package com.test.controller;


import com.test.domain.response.ExceptionResponse;
import com.test.exception.RequestException;
import com.test.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity handleResourceNotFoundException(Exception e, WebRequest req){
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({RequestException.class})
	public ResponseEntity<ExceptionResponse> handleRequestException(Exception e, WebRequest req){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus("failure");
		exceptionResponse.setReason(e.getMessage());
		return ResponseEntity.status(400).body(exceptionResponse);
	}
}
