package com.sds.customer_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.customer_service.dto.CustomerDTO;
import com.sds.customer_service.dto.CustomerResponseDTO;
import com.sds.customer_service.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customer")
	public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerDTO customer){
		logger.info("Inside the create customer method ");
		return customerService.createCustomer(customer);
		
	}
	
	@GetMapping("/customer/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}
	
	@GetMapping("/customer")
	public List<CustomerResponseDTO> getCustomers(){
		return customerService.getCustomers();
	}
	
	@PutMapping("/customer/{id}")
	public CustomerResponseDTO updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO) {
		return customerService.updateCustomer(id, customerDTO);
		
	}

}
