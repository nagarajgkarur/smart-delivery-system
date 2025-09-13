package com.sds.customer_service.exception;

import java.util.Map;

public class CustomerNotFoundExcetption extends RuntimeException {
	
	private final Map<String, String> errors;

    public CustomerNotFoundExcetption(Map<String, String> errors) {
        super("Invalid input parameters");
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
	
}
