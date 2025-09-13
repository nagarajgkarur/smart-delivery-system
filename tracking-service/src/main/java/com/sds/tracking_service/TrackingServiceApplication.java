package com.sds.tracking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrackingServiceApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx = SpringApplication.run(TrackingServiceApplication.class, args);
        //System.out.println("spring.application.name = " + ctx.getEnvironment().getProperty("spring.application.name"));
		SpringApplication.run(TrackingServiceApplication.class, args);
	}

}
