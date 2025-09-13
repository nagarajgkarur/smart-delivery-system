package com.sds.customer_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.customer_service.controller.CustomerController;
import com.sds.customer_service.domain.Customer;
import com.sds.customer_service.dto.CustomerDTO;
import com.sds.customer_service.dto.CustomerResponseDTO;
import com.sds.customer_service.repository.CustomerRepository;
import com.sds.customer_service.utils.CustomerUtils;

import ch.qos.logback.core.util.StringUtil;

@Service
public class CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerUtils customerUtils;
	

	public CustomerResponseDTO createCustomer(CustomerDTO customerDTO) {
		logger.info("Inside the create customer service ");
		Customer customer = customerUtils.getCustomer(customerDTO);
		customer = customerRepository.save(customer);
		logger.info("customer service result "+customer.getId());
		CustomerResponseDTO customerResponseDTO = customerUtils.getCustomerResponseDTO(customer);
		logger.info("customer created successfull");
		return customerResponseDTO;
	}

	public CustomerResponseDTO getCustomer(Long id) {
		Customer customer = customerRepository.getReferenceById(id);
		CustomerResponseDTO customerResponseDTO = customerUtils.getCustomerResponseDTO(customer);
		return customerResponseDTO;
	}

	public List<CustomerResponseDTO> getCustomers() {
		logger.info("Inside get customers method and getting all the customers");
		List<Customer> customerList = customerRepository.findAll();
		logger.info("Got all the customers");
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
