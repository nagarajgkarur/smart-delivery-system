package com.sds.customer_service.utils;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sds.customer_service.domain.Customer;
import com.sds.customer_service.domain.DeliveryRequest;
import com.sds.customer_service.dto.DeliveryDTO;
import com.sds.customer_service.dto.DeliveryRequestDTO;
import com.sds.customer_service.dto.DeliveryRequestResponseDTO;
import com.sds.customer_service.repository.CustomerRepository;

import ch.qos.logback.core.util.StringUtil;

@Component
public class DeliveryRequestUtils {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public DeliveryRequest getDeliveryRequest(DeliveryRequestDTO deliveryRequestDTO,Long customerId) {

		DeliveryRequest deliveryRequest = new DeliveryRequest();
		if(!StringUtil.isNullOrEmpty(deliveryRequestDTO.getPickupLocation())) {
			deliveryRequest.setPickupLocation(deliveryRequestDTO.getPickupLocation());
		}
		if(!StringUtil.isNullOrEmpty(deliveryRequestDTO.getDropLocation())) {
			deliveryRequest.setDropLocation(deliveryRequestDTO.getDropLocation());
		}
		if(customerId!=null) {
			Customer customer = customerRepository.findById(customerId).get();
			deliveryRequest.setCustomer(customer);
		}
		return deliveryRequest;

	}
	
	public DeliveryRequestResponseDTO getDeliveryRequestResponseDTO(DeliveryRequest deliveryRequest) {
		DeliveryRequestResponseDTO deliveryRequestResponseDTO = new DeliveryRequestResponseDTO();
		if(deliveryRequest.getId() != null) {
			deliveryRequestResponseDTO.setId(deliveryRequest.getId());
		}
		if(deliveryRequest.getCustomer().getId()!=null) {
			deliveryRequestResponseDTO.setCustomerId(deliveryRequest.getCustomer().getId());
		}
		if(!StringUtil.isNullOrEmpty(deliveryRequest.getPickupLocation())) {
			deliveryRequestResponseDTO.setPickupLocation(deliveryRequest.getPickupLocation());
		}
		if(!StringUtil.isNullOrEmpty(deliveryRequest.getDropLocation())) {
			deliveryRequestResponseDTO.setDropLocation(deliveryRequest.getDropLocation());
		}
		if(deliveryRequest.getRequestDate() != null) {
			deliveryRequestResponseDTO.setRequestDate(deliveryRequest.getRequestDate());
		}
		return deliveryRequestResponseDTO;
	}
	
	public List<DeliveryRequestResponseDTO> getAllDeliveryRequestResponseDTO(List<DeliveryRequest> deliveryRequests){
		List<DeliveryRequestResponseDTO> deliveryRequestResponseDTOs = deliveryRequests.stream()
				.map(e->getDeliveryRequestResponseDTO(e)).collect(Collectors.toList());
		return deliveryRequestResponseDTOs;
	}

	public DeliveryDTO getDeliveryDTO(DeliveryRequest deliveryRequest) {
		DeliveryDTO deliveryDTO = new DeliveryDTO();
		deliveryDTO.setDeliveryRequestId(deliveryRequest.getId());
		deliveryDTO.setDroplocation(deliveryRequest.getDropLocation());
		deliveryDTO.setPickuplocation(deliveryRequest.getPickupLocation());
		deliveryDTO.setStatus(false);
		return deliveryDTO;
	}
}
