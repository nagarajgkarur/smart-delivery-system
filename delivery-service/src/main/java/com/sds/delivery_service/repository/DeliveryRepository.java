package com.sds.delivery_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sds.delivery_service.domain.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
