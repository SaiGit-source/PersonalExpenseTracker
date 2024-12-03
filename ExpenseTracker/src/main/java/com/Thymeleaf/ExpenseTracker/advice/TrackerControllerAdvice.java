package com.Thymeleaf.ExpenseTracker.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Thymeleaf.ExpenseTracker.exception.RecordNotFoundException;

@RestControllerAdvice
public class TrackerControllerAdvice {
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handleRecordNotFound(RecordNotFoundException rnf){
		ErrorMsg error = new ErrorMsg("404 not found", rnf.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMsg>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralException(Exception e){
		ErrorMsg error = new ErrorMsg("404 not found", e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMsg>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
