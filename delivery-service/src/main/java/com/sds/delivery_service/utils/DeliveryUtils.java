package com.sds.delivery_service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sds.delivery_service.domain.Delivery;
import com.sds.delivery_service.model.DeliveryDTO;
import com.sds.delivery_service.model.DeliveryResponseDTO;
import com.sds.delivery_service.repository.DeliveryRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;


@Component
public class DeliveryUtils {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	public Delivery getDeliveryInstance(DeliveryDTO deliveryDTO,Long id) {
		Delivery delivery = null;
		if(id==null) {
			delivery = new Delivery();
		}else {
			delivery =  deliveryRepository.findById(id).get();
		}
		if(StringUtils.isNotEmpty(deliveryDTO.getDroplocation())) {
			delivery.setDroplocation(deliveryDTO.getDroplocation());
		}
		if(StringUtils.isNotBlank(deliveryDTO.getPickuplocation())) {
			delivery.setPickuplocation(deliveryDTO.getPickuplocation());
		}
		if(deliveryDTO.getDriverId() != null) {
			delivery.setDriverId(deliveryDTO.getDriverId());
		}
		if(deliveryDTO.isStatus()!=null) {
			delivery.setStatus(deliveryDTO.isStatus());
		}
		if(deliveryDTO.getDeliveryRequestId() != null) {
			delivery.setDeliveryRequestId(deliveryDTO.getDeliveryRequestId());
		}
		
		return delivery;
	}

	public DeliveryResponseDTO getDeliveryResponseInstance(Delivery delivery) {
		DeliveryResponseDTO deliveryResponseDTO = new DeliveryResponseDTO();
		deliveryResponseDTO.setId(delivery.getId());
		deliveryResponseDTO.setPickuplocation(delivery.getPickuplocation());
		deliveryResponseDTO.setDroplocation(delivery.getDroplocation());
		deliveryResponseDTO.setDriverId(delivery.getDriverId());
		deliveryResponseDTO.setStatus(delivery.isStatus());
		deliveryResponseDTO.setCreatedAt(delivery.getCreatedAt());
		deliveryResponseDTO.setDeliveryRequestId(delivery.getDeliveryRequestId());
		deliveryResponseDTO.setMessage("success");
		return deliveryResponseDTO;
	}
	
	public List<DeliveryResponseDTO> getAllDeliveryResponseInstance(List<Delivery> deliveries){
		return deliveries.stream().map(e->getDeliveryResponseInstance(e)).collect(Collectors.toList());
	}

}
