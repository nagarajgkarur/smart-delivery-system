package com.sds.customer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.customer_service.domain.Customer;
import com.sds.customer_service.dto.CustomerDTO;
import com.sds.customer_service.dto.CustomerResponseDTO;
import com.sds.customer_service.repository.CustomerRepository;
import com.sds.customer_service.utils.CustomerUtils;

import ch.qos.logback.core.util.StringUtil;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerUtils customerUtils;
	

	public CustomerResponseDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = customerUtils.getCustomer(customerDTO);
		customer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = customerUtils.getCustomerResponseDTO(customer);
		return customerResponseDTO;
	}

	public CustomerResponseDTO getCustomer(Long id) {
		Customer customer = customerRepository.getReferenceById(id);
		CustomerResponseDTO customerResponseDTO = customerUtils.getCustomerResponseDTO(customer);
		return customerResponseDTO;
	}

	public List<CustomerResponseDTO> getCustomers() {
		List<Customer> customerList = customerRepository.findAll();
		return customerUtils.getAllCustomerResponseDTO(customerList);
	}
	
	
	public CustomerResponseDTO updateCustomer(Long id,CustomerDTO customerDTO) {
		Customer customer = customerRepository.getReferenceById(id);
		if(!StringUtil.isNullOrEmpty(customerDTO.getName())) {
			customer.setName(customerDTO.getName());
		}
		if(customerDTO.getContactNumber()!=null) {
			customer.setContactNumber(customerDTO.getContactNumber());
		}
		if(!StringUtil.isNullOrEmpty(customerDTO.getEmail())) {
			customer.setEmail(customerDTO.getEmail());
		}
		customer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = customerUtils.getCustomerResponseDTO(customer);
		return customerResponseDTO;
	}
}
