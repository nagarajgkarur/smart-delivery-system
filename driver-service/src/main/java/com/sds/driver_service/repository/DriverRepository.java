package com.sds.driver_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sds.driver_service.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

}
