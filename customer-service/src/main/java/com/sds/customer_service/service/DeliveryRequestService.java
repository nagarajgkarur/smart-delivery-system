package com.sds.customer_service.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sds.customer_service.domain.Customer;
import com.sds.customer_service.domain.DeliveryRequest;
import com.sds.customer_service.dto.DeliveryDTO;
import com.sds.customer_service.dto.DeliveryRequestDTO;
import com.sds.customer_service.dto.DeliveryRequestResponseDTO;
import com.sds.customer_service.dto.DeliveryResponseDTO;
import com.sds.customer_service.dto.DriverDeliveryDTO;
import com.sds.customer_service.dto.NotificationDTO;
import com.sds.customer_service.dto.NotificationResponseDTO;
import com.sds.customer_service.dto.TrackingDTO;
import com.sds.customer_service.dto.TrackingResonseDTO;
import com.sds.customer_service.repository.CustomerRepository;
import com.sds.customer_service.repository.DeliveryRequestRepository;
import com.sds.customer_service.utils.DeliveryRequestUtils;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import jakarta.transaction.Transactional;


@Service
public class DeliveryRequestService {

	@Autowired
	DeliveryRequestRepository deliveryRequestRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	DeliveryRequestUtils deliveryRequestUtils;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${delivery.service.url}")
    private String gatewayUrl;
	
	public DeliveryRequestResponseDTO createDeliveryRequest(DeliveryRequestDTO deliveryRequestDTO,Long customerId) {
		System.out.println("Creating Delivery Request");
		DeliveryRequest deliveryRequest = deliveryRequestUtils.getDeliveryRequest(deliveryRequestDTO,customerId);
		deliveryRequest = deliveryRequestRepository.save(deliveryRequest);
		System.out.println("Completed Delivery Request");
		// Call Delivery service
		DeliveryRequestResponseDTO deliveryRequestResponseDTO = createDelivery(deliveryRequest);
		return deliveryRequestResponseDTO;
	}

	@Transactional
	@CircuitBreaker(name = "deliveryServiceCB", fallbackMethod = "fallbackForDelivery")
    @Retry(name = "deliveryServiceRetry")
    @TimeLimiter(name = "deliveryServiceTimeout")
	private DeliveryRequestResponseDTO createDelivery(DeliveryRequest deliveryRequest) {
		DeliveryDTO deliveryDTO = deliveryRequestUtils.getDeliveryDTO(deliveryRequest);
		DeliveryRequestResponseDTO deliveryRequestResponseDTO = deliveryRequestUtils.getDeliveryRequestResponseDTO(deliveryRequest);
		DeliveryResponseDTO deliveryResponseDTO = restTemplate.postForObject(gatewayUrl+"/api/v1/delivery", deliveryDTO, DeliveryResponseDTO.class);
		if(deliveryResponseDTO.getMessage().equals("success")) {
			TrackingDTO trackingDTO = new TrackingDTO();
			trackingDTO.setDeliveryId(deliveryRequest.getId());
			trackingDTO.setCurrentLocation("BTM");
			trackingDTO.setStatus("IN_PROGRESS");
			trackingDTO.setRemarks("Delivery request created");
			TrackingResonseDTO trackingResonseDTO = restTemplate.postForObject(gatewayUrl+"/api/v1/tracking", trackingDTO, TrackingResonseDTO.class);
			deliveryRequestResponseDTO.setTrackingResonseDTO(trackingResonseDTO);
			NotificationDTO notificationDTO = new NotificationDTO();
			notificationDTO.setDeliveryId(deliveryDTO.getDeliveryRequestId());
			notificationDTO.setMessage("Delivery Created");
			NotificationResponseDTO notificationResponseDTO = restTemplate.postForObject(gatewayUrl+"/api/v1/notification", notificationDTO, NotificationResponseDTO.class);
			deliveryRequestResponseDTO.setNotificationResponseDTO(notificationResponseDTO);
		}
		
		deliveryRequestResponseDTO.setDeliveryResponseDTO(deliveryResponseDTO);
		return deliveryRequestResponseDTO;
	}
	public DeliveryRequestResponseDTO fallbackForDelivery(DeliveryRequest deliveryRequest, Throwable t) {
        System.out.println("Delivery Service is down, using fallback: " + t.getMessage());

		/*
		 * DeliveryResponseDTO fallbackDelivery = new DeliveryResponseDTO();
		 * fallbackDelivery.setStatus(false);
		 * fallbackDelivery.setPickuplocation(deliveryRequest.getPickupLocation());
		 * fallbackDelivery.setDroplocation(deliveryRequest.getDropLocation());
		 * DeliveryRequestResponseDTO response =
		 * deliveryRequestUtils.getDeliveryRequestResponseDTO(deliveryRequest);
		 * response.setDeliveryResponseDTO(fallbackDelivery);
		 */
        throw new RuntimeException("Delivery Service unavailable. Rolling back request."); 
       // return response;
    }

	public DeliveryRequestResponseDTO getDeliveryRequest(Long id) {
		DeliveryRequest deliveryRequest =  deliveryRequestRepository.findById(id).get();
		return deliveryRequestUtils.getDeliveryRequestResponseDTO(deliveryRequest);
	}

	public List<DeliveryRequestResponseDTO> getAllDeliveryRequest() {
		List<DeliveryRequest> deliveryRequests =  deliveryRequestRepository.findAll();
		return deliveryRequestUtils.getAllDeliveryRequestResponseDTO(deliveryRequests);
	}

	public DeliveryRequestResponseDTO updateDeliveryRequest(Long id, DeliveryRequestDTO deliveryRequestDTO,Long customerId) {
		DeliveryRequest deliveryRequest = deliveryRequestRepository.findById(id).get();
		Customer customer =  customerRepository.findById(customerId).get();
		if(StringUtils.isNotBlank(deliveryRequestDTO.getDropLocation())) {
			deliveryRequest.setDropLocation(deliveryRequestDTO.getDropLocation());
		}
		if(StringUtils.isNotBlank(deliveryRequestDTO.getPickupLocation())) {
			deliveryRequest.setPickupLocation(deliveryRequestDTO.getPickupLocation());
		}
		if(customer != null) {
			deliveryRequest.setCustomer(customer);
		}
		deliveryRequest =  deliveryRequestRepository.save(deliveryRequest);
		return deliveryRequestUtils.getDeliveryRequestResponseDTO(deliveryRequest);
	}

	public void deleteDeliveryRequest(Long id) {
		deliveryRequestRepository.deleteById(id);
	}

}
