package com.sds.driver_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.driver_service.domain.DriverDelivery;
import com.sds.driver_service.model.DriverDeliveryDTO;
import com.sds.driver_service.model.DriverDeliveryResponseDTO;
import com.sds.driver_service.repository.DriverDeliveryRepository;
import com.sds.driver_service.utility.DriverUtility;

@Service
public class DriverDeliveryService {

	@Autowired
	DriverUtility driverUtility;
	
	@Autowired
	DriverDeliveryRepository driverDeliveryRepository;
	
	public DriverDeliveryResponseDTO createDriverDelivery(DriverDeliveryDTO driverDeliveryDto) {
		DriverDelivery driverDelivery = driverUtility.getDriverDeliveryInstance(driverDeliveryDto,null);
		driverDelivery = driverDeliveryRepository.save(driverDelivery);
		DriverDeliveryResponseDTO driverDeliveryResponseDTO =driverUtility.getDriverDeliveryResonseDTO(driverDelivery);
		return driverDeliveryResponseDTO;
	}

	public DriverDeliveryResponseDTO getDriverDelivery(Long id) {
		DriverDelivery driverDelivery = driverDeliveryRepository.findById(id).get();
		DriverDeliveryResponseDTO driverDeliveryResponseDTO = driverUtility.getDriverDeliveryResonseDTO(driverDelivery);
		return driverDeliveryResponseDTO;
	}

	public List<DriverDeliveryResponseDTO> getallDriverDelivery() {
		List<DriverDelivery> driverDeliverys = driverDeliveryRepository.findAll();
		List<DriverDeliveryResponseDTO> driverDeliveryResponseDTOs = driverUtility.getAllDriverDeliveryResponseDTO(driverDeliverys);
		return driverDeliveryResponseDTOs;
	}

	public DriverDeliveryResponseDTO updateDriverDelivery(Long id, DriverDeliveryDTO driverDeliveryDTO) {
		DriverDelivery driverDelivery =  driverUtility.getDriverDeliveryInstance(driverDeliveryDTO, id);
		driverDelivery = driverDeliveryRepository.save(driverDelivery);
		return driverUtility.getDriverDeliveryResonseDTO(driverDelivery);
	}

	public void deleteDriverDelivery(Long id) {
		driverDeliveryRepository.deleteById(id);
	}

}
