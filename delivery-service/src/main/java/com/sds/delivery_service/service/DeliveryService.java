package com.sds.delivery_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.delivery_service.domain.Delivery;
import com.sds.delivery_service.model.DeliveryDTO;
import com.sds.delivery_service.model.DeliveryResponseDTO;
import com.sds.delivery_service.repository.DeliveryRepository;
import com.sds.delivery_service.utils.DeliveryUtils;

@Service
public class DeliveryService {

	@Autowired
	DeliveryUtils deliveryUtils;
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	public DeliveryResponseDTO createDelivery(DeliveryDTO deliveryDTO) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Delivery delivery = deliveryUtils.getDeliveryInstance(deliveryDTO,null);
		delivery = deliveryRepository.save(delivery);
		DeliveryResponseDTO deliveryResponseDTO = deliveryUtils.getDeliveryResponseInstance(delivery);
		return deliveryResponseDTO;
	}

	public DeliveryResponseDTO getDelivery(Long id) {
		Delivery delivery = deliveryRepository.findById(id).get();
		DeliveryResponseDTO deliveryResponseDTO = deliveryUtils.getDeliveryResponseInstance(delivery);
		return deliveryResponseDTO;
		
	}

	public List<DeliveryResponseDTO> getAllDelivery() {
		List<Delivery> deliveries = deliveryRepository.findAll();
		List<DeliveryResponseDTO> deliveryResponseDTOs = deliveryUtils.getAllDeliveryResponseInstance(deliveries);
		return deliveryResponseDTOs;
	}

	public DeliveryResponseDTO updateDelivery(Long id, DeliveryDTO deliveryDTO) {
		Delivery delivery = deliveryUtils.getDeliveryInstance(deliveryDTO,id);
		delivery = deliveryRepository.save(delivery);
		DeliveryResponseDTO deliveryResponseDTO = deliveryUtils.getDeliveryResponseInstance(delivery);
		return deliveryResponseDTO;
	}

	public void deleteDelivery(Long id) {
		deliveryRepository.deleteById(id);
	}

}
