package com.sds.customer_service.controller;

import java.util.List;

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

@RestController
@RequestMapping(path = "/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customer")
	public CustomerResponseDTO createCustomer(@RequestBody CustomerDTO customer){
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
