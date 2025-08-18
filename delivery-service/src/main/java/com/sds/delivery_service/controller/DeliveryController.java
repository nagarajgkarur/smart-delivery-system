package com.sds.delivery_service.controller;

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

import com.sds.delivery_service.model.DeliveryDTO;
import com.sds.delivery_service.model.DeliveryResponseDTO;
import com.sds.delivery_service.service.DeliveryService;

@RestController
@RequestMapping(path = "/api/v1")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@PostMapping("/delivery")
	public DeliveryResponseDTO createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
		return deliveryService.createDelivery(deliveryDTO);
	}
	
	@GetMapping("/delivery/{id}")
	public DeliveryResponseDTO getDelivery(@PathVariable Long id) {
		return deliveryService.getDelivery(id);
	}

	@GetMapping("/delivery")
	public List<DeliveryResponseDTO> getAllDelivery(){
		return deliveryService.getAllDelivery();
	}
	
	@PutMapping("/delivery/{id}")
	public DeliveryResponseDTO updateDelivery(@PathVariable Long id, @RequestBody DeliveryDTO deliveryDTO) {
		return deliveryService.updateDelivery(id,deliveryDTO);
	}
	
	@DeleteMapping("/delivery/{id}")
	public void deleteDelivery(@PathVariable Long id) {
		deliveryService.deleteDelivery(id);
	}
	
}
