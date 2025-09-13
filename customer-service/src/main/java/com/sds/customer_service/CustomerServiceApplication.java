package com.sds.customer_service;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		MDC.put("service", "customer-service");
		ConfigurableApplicationContext ctx = SpringApplication.run(CustomerServiceApplication.class, args);
        System.out.println("spring.application.name = " + ctx.getEnvironment().getProperty("spring.application.name"));
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
