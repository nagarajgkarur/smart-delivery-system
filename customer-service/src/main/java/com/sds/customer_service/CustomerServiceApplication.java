package com.sds.customer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx = SpringApplication.run(CustomerServiceApplication.class, args);
        //System.out.println("spring.application.name = " + ctx.getEnvironment().getProperty("spring.application.name"));
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
