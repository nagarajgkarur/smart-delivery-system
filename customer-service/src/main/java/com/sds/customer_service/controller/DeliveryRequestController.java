package com.sds.customer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sds.customer_service.dto.DeliveryRequestDTO;
import com.sds.customer_service.dto.DeliveryRequestResponseDTO;
import com.sds.customer_service.service.DeliveryRequestService;

@RestController
@RequestMapping(path="/api/v1")
public class DeliveryRequestController {

	@Autowired
	DeliveryRequestService deliveryRequestService;
	
	
	@GetMapping("/deliveryRequest/{id}")
	public DeliveryRequestResponseDTO getDeliveryRequest(@PathVariable Long id) {
		return deliveryRequestService.getDeliveryRequest(id);
	}
	
	@PostMapping("/deliveryRequest")
	public DeliveryRequestResponseDTO createDeliveryRequest(@RequestBody DeliveryRequestDTO deliveryRequestDTO) {
		return deliveryRequestService.createDeliveryRequest(deliveryRequestDTO);
	}
	
	@GetMapping("/deliveryRequest")
	public List<DeliveryRequestResponseDTO> getAllDeliveryRequest(){
		return deliveryRequestService.getAllDeliveryRequest();
	}
	
	@PostMapping("/deliveryRequest/{id}")
	public DeliveryRequestResponseDTO updatqeDeliveryRequest(@PathVariable Long id, @RequestBody  DeliveryRequestDTO deliveryRequestDTO) {
		return deliveryRequestService.updateDeliveryRequest(id, deliveryRequestDTO);
	}
	
	@DeleteMapping("/deliveryRequest/{id}")
	public void deleteDeliveryRequest(@PathVariable Long id) {
		deliveryRequestService.deleteDeliveryRequest(id);
	}
}
