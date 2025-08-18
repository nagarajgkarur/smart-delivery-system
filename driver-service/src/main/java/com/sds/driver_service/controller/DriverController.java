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

import com.sds.driver_service.domain.Driver;
import com.sds.driver_service.model.DriverDTO;
import com.sds.driver_service.model.DriverResponseDTO;
import com.sds.driver_service.service.DriverService;

@RestController
@RequestMapping(path = "/api/v1")
public class DriverController {

	@Autowired
	DriverService driverService;
	
	@PostMapping("/driver")
	public DriverResponseDTO createDriver(@RequestBody DriverDTO driverDto) {
		return driverService.createDriver(driverDto);
	}
	
	
	@GetMapping("/driver/{id}")
	public DriverResponseDTO getDriver(@PathVariable Long id) {
		return driverService.getDriver(id);
	}
	
	@GetMapping("/driver")
	public List<DriverResponseDTO> getAllDriver(){
		return driverService.getallDriver();
	}
	
	@PostMapping("/driver/{id}")
	public DriverResponseDTO updateDriver(@PathVariable Long id,@RequestBody DriverDTO driverDTO) {
		return driverService.updateDriver(id,driverDTO);
	}
	
	@DeleteMapping("/driver/{id}")
	public void deleteDriver(@PathVariable Long id) {
		driverService.deleteDriver(id);
	}
}
