package com.sds.driver_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.driver_service.model.DriverDeliveryDTO;
import com.sds.driver_service.model.DriverDeliveryResponseDTO;
import com.sds.driver_service.service.DriverDeliveryService;


@RestController
@RequestMapping(path = "/api/v1/")
public class DriverDeliveryController {
	
	
	@Autowired
	DriverDeliveryService driverDeliveryService;
	
	@PostMapping("/driverDelivery")
	public DriverDeliveryResponseDTO createDriverDelivery(@RequestBody DriverDeliveryDTO driverDeliveryDto) {
		return driverDeliveryService.createDriverDelivery(driverDeliveryDto);
	}
	
	
	@GetMapping("/driverDelivery/{id}")
	public DriverDeliveryResponseDTO getDriverDelivery(@PathVariable Long id) {
		return driverDeliveryService.getDriverDelivery(id);
	}
	
	@GetMapping("/driverDelivery")
	public List<DriverDeliveryResponseDTO> getAllDriverDelivery(){
		return driverDeliveryService.getallDriverDelivery();
	}
	
	@PostMapping("/driverDelivery/{id}")
	public DriverDeliveryResponseDTO updateDriverDelivery(@PathVariable Long id,@RequestBody DriverDeliveryDTO driverDeliveryDTO) {
		return driverDeliveryService.updateDriverDelivery(id,driverDeliveryDTO);
	}
	
	@DeleteMapping("/driverDelivery/{id}")
	public void deleteDriverDelivery(@PathVariable Long id) {
		driverDeliveryService.deleteDriverDelivery(id);
	}

}
