package com.sds.customer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.customer_service.dto.DeliveryRequestDTO;
import com.sds.customer_service.dto.DeliveryRequestResponseDTO;
import com.sds.customer_service.service.DeliveryRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/v1")
public class DeliveryRequestController {

	@Autowired
	DeliveryRequestService deliveryRequestService;
	
	
	@GetMapping("/deliveryRequest/{id}")
	public DeliveryRequestResponseDTO getDeliveryRequest(@PathVariable Long id) {
		return deliveryRequestService.getDeliveryRequest(id);
	}
	
	@PostMapping("/customer/{customerId}/deliveryRequest")
	public DeliveryRequestResponseDTO createDeliveryRequest(@Valid @RequestBody DeliveryRequestDTO deliveryRequestDTO,@PathVariable Long customerId) {
		return deliveryRequestService.createDeliveryRequest(deliveryRequestDTO,customerId);
	}
	
	@GetMapping("/deliveryRequest")
	public List<DeliveryRequestResponseDTO> getAllDeliveryRequest(){
		return deliveryRequestService.getAllDeliveryRequest();
	}
	
	@PutMapping("/customer/{customerId}/deliveryRequest/{deliveryRequestId}")
	public DeliveryRequestResponseDTO updatqeDeliveryRequest(@PathVariable Long deliveryRequestId,@PathVariable Long customerId, @RequestBody  DeliveryRequestDTO deliveryRequestDTO) {
		return deliveryRequestService.updateDeliveryRequest(deliveryRequestId, deliveryRequestDTO,customerId);
	}
	
	@DeleteMapping("/deliveryRequest/{id}")
	public void deleteDeliveryRequest(@PathVariable Long id) {
		deliveryRequestService.deleteDeliveryRequest(id);
	}
}
