package com.sds.tracking_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.tracking_service.domain.Tracking;
import com.sds.tracking_service.model.TrackingDTO;
import com.sds.tracking_service.model.TrackingResonseDTO;
import com.sds.tracking_service.repository.TrackingRepository;
import com.sds.tracking_service.utility.TrackingUtility;

@Service
public class TrackingService {

	@Autowired
	TrackingRepository trackingRepository;
	
	@Autowired
	TrackingUtility trackingUtility;
	
	
	public TrackingResonseDTO createTracking(TrackingDTO trackingDTO) {
		Tracking tracking = trackingUtility.getTrackingInstance(trackingDTO,null);
		tracking = trackingRepository.save(tracking);
		TrackingResonseDTO trackingResonseDTO = trackingUtility.getTrackingResponseInstance(tracking);
		return trackingResonseDTO;
	}

	public TrackingResonseDTO getTracking(Long id) {
		Tracking tracking = trackingRepository.findById(id).get();
		TrackingResonseDTO trackingResonseDTO = trackingUtility.getTrackingResponseInstance(tracking);
		return trackingResonseDTO;
	}

	public List<TrackingResonseDTO> getallTracking() {
		List<Tracking> trackings  = trackingRepository.findAll();
		return trackingUtility.getAllTrackingResponseInstance(trackings);
	}

	public TrackingResonseDTO updateTracking(Long id, TrackingDTO trackingDTO) {
		Tracking tracking = trackingUtility.getTrackingInstance(trackingDTO, id);
		tracking = trackingRepository.save(tracking);
		return trackingUtility.getTrackingResponseInstance(tracking);
	}

	public void deleteTracking(Long id) {
		trackingRepository.deleteById(id);
	}

}
