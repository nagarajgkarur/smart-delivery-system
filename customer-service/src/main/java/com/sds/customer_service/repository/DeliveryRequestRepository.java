package com.sds.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sds.customer_service.domain.DeliveryRequest;

@Repository
public interface DeliveryRequestRepository extends JpaRepository<DeliveryRequest, Long>{

}
