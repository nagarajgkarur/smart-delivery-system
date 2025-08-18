package com.sds.customer_service.utils;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sds.customer_service.domain.Customer;
import com.sds.customer_service.dto.CustomerDTO;
import com.sds.customer_service.dto.CustomerResponseDTO;

import ch.qos.logback.core.util.StringUtil;

@Component
public class CustomerUtils {

	public Customer getCustomer(CustomerDTO customerDTO) {

		Customer customer = new Customer();
		if(!StringUtil.isNullOrEmpty(customerDTO.getName())) {
			customer.setName(customerDTO.getName());
		}
		if(!StringUtil.isNullOrEmpty(customerDTO.getEmail())) {
			customer.setEmail(customerDTO.getEmail());
		}
		if(customerDTO.getContactNumber()!=null) {
			customer.setContactNumber(customerDTO.getContactNumber());
		}
		customer.setCreatedAt(new Date().toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime());

		return customer;

	}
	
	public CustomerResponseDTO getCustomerResponseDTO(Customer customer) {
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		if(customer.getId() != null) {
			customerResponseDTO.setId(customer.getId());
		}
		if(!StringUtil.isNullOrEmpty(customer.getName())) {
			customerResponseDTO.setName(customer.getName());
		}
		if(customer.getContactNumber()!= null) {
			customerResponseDTO.setContactNumber(customer.getContactNumber());
		}
		if(!StringUtil.isNullOrEmpty(customer.getEmail())) {
			customerResponseDTO.setEmail(customer.getEmail());
		}
		if(customer.getCreatedAt() != null) {
			customerResponseDTO.setCreatedAt(customer.getCreatedAt());
		}
		return customerResponseDTO;
	}
	
	public List<CustomerResponseDTO> getAllCustomerResponseDTO(List<Customer> customers){
		List<CustomerResponseDTO> customerResponseDTOs = customers.stream().map(e->getCustomerResponseDTO(e)).collect(Collectors.toList());
		return customerResponseDTOs;
	}

}
