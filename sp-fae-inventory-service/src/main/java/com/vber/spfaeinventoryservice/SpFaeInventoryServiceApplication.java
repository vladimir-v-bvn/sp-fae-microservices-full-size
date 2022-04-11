package com.vber.spfaeinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpFaeInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpFaeInventoryServiceApplication.class, args);
	}

}
