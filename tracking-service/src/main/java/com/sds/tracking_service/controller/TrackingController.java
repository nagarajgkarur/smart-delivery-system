package com.sds.tracking_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.tracking_service.domain.Tracking;
import com.sds.tracking_service.model.TrackingDTO;
import com.sds.tracking_service.service.TrackingService;

@RestController
@RequestMapping(path = "/api/v1")
public class TrackingController {

	@Autowired
	TrackingService trackingService;
	
	@PostMapping("/tracking")
	public Tracking createTracking(@RequestBody Tracking tracking) {
		return trackingService.createTracking(tracking);
	}
	
	
	@GetMapping("/tracking/{id}")
	public Tracking getTracking(@PathVariable Long id) {
		return trackingService.getTracking(id);
	}
	
	@GetMapping("/tracking")
	public List<Tracking> getAllTracking(){
		return trackingService.getallTracking();
	}
	
	@PostMapping("/tracking/{id}")
	public Tracking updateTracking(@PathVariable Long id,@RequestBody TrackingDTO trackingDTO) {
		return trackingService.updateTracking(id,trackingDTO);
	}
	
	@DeleteMapping("/tracking/{id}")
	public Boolean deleteTracking(@PathVariable Long id) {
		return trackingService.deleteTracking(id);
	}
	
}
