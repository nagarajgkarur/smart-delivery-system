package com.sds.tracking_service.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sds.tracking_service.domain.Tracking;
import com.sds.tracking_service.model.TrackingDTO;
import com.sds.tracking_service.model.TrackingResonseDTO;
import com.sds.tracking_service.repository.TrackingRepository;

import ch.qos.logback.core.util.StringUtil;

@Component
public class TrackingUtility {

	@Autowired
	TrackingRepository trackingRepository;
	
	public Tracking getTrackingInstance(TrackingDTO trackingDTO,Long id) {
		Tracking tracking = null;
		if(id != null) {
			tracking = trackingRepository.findById(id).get();
		}else {
			tracking = new Tracking();
		}
		
		if(!StringUtil.isNullOrEmpty(trackingDTO.getCurrentLocation())) {
			tracking.setCurrentLocation(trackingDTO.getCurrentLocation());
		}
		if(trackingDTO.getDeliveryId() != null) {
			tracking.setDeliveryId(trackingDTO.getDeliveryId());
		}
		if(!StringUtil.isNullOrEmpty(trackingDTO.getRemarks())) {
			tracking.setRemarks(trackingDTO.getRemarks());
		}
		if(!StringUtil.isNullOrEmpty(trackingDTO.getStatus())) {
			tracking.setStatus(trackingDTO.getStatus());
		}
		return tracking;
	}

	public TrackingResonseDTO getTrackingResponseInstance(Tracking tracking) {
		TrackingResonseDTO trackingResonseDTO = new TrackingResonseDTO();
		trackingResonseDTO.setCurrentLocation(tracking.getCurrentLocation());
		trackingResonseDTO.setDeliveryId(tracking.getDeliveryId());
		trackingResonseDTO.setId(tracking.getId());
		trackingResonseDTO.setRemarks(tracking.getRemarks());
		trackingResonseDTO.setTimestamp(tracking.getTimestamp());
		trackingResonseDTO.setStatus(tracking.getStatus());
		return trackingResonseDTO;
	}
	
	public List<TrackingResonseDTO> getAllTrackingResponseInstance(List<Tracking> trackings){
		return trackings.stream().map(e->getTrackingResponseInstance(e)).collect(Collectors.toList());
	}

}
