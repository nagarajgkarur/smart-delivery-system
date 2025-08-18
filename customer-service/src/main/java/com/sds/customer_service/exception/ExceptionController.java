package com.sds.customer_service.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex) {
	        Map<String, Object> error = new LinkedHashMap<>();
	        error.put("success", false);
	        error.put("message", ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred");
	        error.put("timestamp", LocalDateTime.now());

	        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
	    }

	    @ExceptionHandler(TimeoutException.class)	
	    public ResponseEntity<Map<String, Object>> handleTimeout(TimeoutException ex) {
	        Map<String, Object> error = new LinkedHashMap<>();
	        error.put("success", false);
	        error.put("message", "Delivery Service timed out. Please try again later.");
	        error.put("timestamp", LocalDateTime.now());

	        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(error);
	    }

}
