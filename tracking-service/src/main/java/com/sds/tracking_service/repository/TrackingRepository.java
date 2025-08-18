package com.sds.tracking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sds.tracking_service.domain.Tracking;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long>{

}
