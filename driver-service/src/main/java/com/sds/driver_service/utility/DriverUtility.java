package com.sds.driver_service.utility;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sds.driver_service.domain.Driver;
import com.sds.driver_service.domain.DriverDelivery;
import com.sds.driver_service.model.DriverDTO;
import com.sds.driver_service.model.DriverDeliveryDTO;
import com.sds.driver_service.model.DriverDeliveryResponseDTO;
import com.sds.driver_service.model.DriverResponseDTO;
import com.sds.driver_service.repository.DriverDeliveryRepository;
import com.sds.driver_service.repository.DriverRepository;

import ch.qos.logback.core.util.StringUtil;

@Component
public class DriverUtility {

	
	@Autowired
	DriverRepository driverRepository;
	
	@Autowired
	DriverDeliveryRepository driverDeliveryRepository;
	
	public Driver getDriverInstance(DriverDTO driverDTO, Long Id) {
		Driver driver = null;
		if(Id != null) {
			driver = driverRepository.findById(Id).get();
		}else {
			driver = new Driver();
		}
		 
		if(driverDTO.getContactNumber() != null) {
			driver.setContactNumber(driverDTO.getContactNumber());
		}
		if(!StringUtil.isNullOrEmpty(driverDTO.getName())) {
			driver.setName(driverDTO.getName());
		}
		if(!StringUtil.isNullOrEmpty(driverDTO.getVehicleNumber())) {
			driver.setVehicleNumber(driverDTO.getVehicleNumber());
		}
		return driver;
	}
	
	public DriverResponseDTO getDriverDTOResponse(Driver driver) {
		DriverResponseDTO driverResponseDTO = new DriverResponseDTO();
		driverResponseDTO.setId(driver.getId());
		driverResponseDTO.setName(driver.getName());
		driverResponseDTO.setContactNumber(driver.getContactNumber());
		driverResponseDTO.setVehicleNumber(driver.getVehicleNumber());
		driverResponseDTO.setRegisteredAt(driver.getRegisteredAt());
		return driverResponseDTO;
	}
	
	public List<DriverResponseDTO> getallDriverDTOResponse(List<Driver> drivers){
		List<DriverResponseDTO> driverResponseDTOs = drivers.stream().map(e->getDriverDTOResponse(e)).collect(Collectors.toList());
		return driverResponseDTOs;
	}
	
	public DriverDelivery getDriverDeliveryInstance(DriverDeliveryDTO driverDeliveryDTO,Long Id) {
		DriverDelivery driverDelivery = null;
		if(Id != null) {
			driverDelivery = driverDeliveryRepository.findById(Id).get();
		}else {
			driverDelivery = new DriverDelivery();
		}
		
		if(driverDeliveryDTO.getDeliveryId() !=null) {
			driverDelivery.setDeliveryId(driverDeliveryDTO.getDeliveryId());
		}
		
		if(driverDeliveryDTO.getDriverId()!=null) {
			Driver driver = driverRepository.findById(driverDeliveryDTO.getDriverId()).get();
			driverDelivery.setDriver(driver);
		}
		return driverDelivery;
	}
	
	public DriverDeliveryResponseDTO getDriverDeliveryResonseDTO(DriverDelivery driverDelivery) {
		Driver driver = driverDelivery.getDriver();
		DriverResponseDTO driverResponseDTO = getDriverDTOResponse(driver);
		DriverDeliveryResponseDTO driverDeliveryResponseDTO = new DriverDeliveryResponseDTO();
		driverDeliveryResponseDTO.setDeliveryId(driverDelivery.getDeliveryId());
		driverDeliveryResponseDTO.setDriverResponseDTO(driverResponseDTO);
		driverDeliveryResponseDTO.setId(driverDelivery.getId());
		driverDeliveryResponseDTO.setAcceptedAt(driverDelivery.getAcceptedAt());
		return driverDeliveryResponseDTO;
	}
	
	public List<DriverDeliveryResponseDTO> getAllDriverDeliveryResponseDTO(List<DriverDelivery> driverDeliveries){
		return driverDeliveries.stream().map(e->getDriverDeliveryResonseDTO(e)).collect(Collectors.toList());
	}

}
