package com.sds.customer_service.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	 

	    @ExceptionHandler(TimeoutException.class)	
	    public ResponseEntity<Map<String, Object>> handleTimeout(TimeoutException ex) {
	        Map<String, Object> error = new LinkedHashMap<>();
	        error.put("success", false);
	        error.put("message", "Delivery Service timed out. Please try again later.");
	        error.put("timestamp", LocalDateTime.now());

	        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(error);
	    }
	    
	    @ExceptionHandler(value = CustomerNotFoundExcetption.class)
	    public ResponseEntity<Map<String, Object>> handleValidationException(CustomerNotFoundExcetption ex) {
	        Map<String, Object> error = new LinkedHashMap<>();
	        error.put("success", false);
	        error.put("message", "Validation failed");
	        error.put("errors", ex.getErrors());
	        error.put("timestamp", LocalDateTime.now());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	    }


	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex) {
	        Map<String, Object> error = new LinkedHashMap<>();
	        error.put("success", false);
	        error.put("message", ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred");
	        error.put("timestamp", LocalDateTime.now());

	        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
	    }
	    
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, Object> errors = new LinkedHashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	                errors.put(error.getField(), error.getDefaultMessage())
	        );

	        Map<String, Object> response = new LinkedHashMap<>();
	        response.put("success", false);
	        response.put("message", "Validation failed");
	        response.put("errors", errors);
	        response.put("timestamp", LocalDateTime.now());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
	    
}
