package com.vber.spfaeconfigurationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpFaeConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpFaeConfigurationServerApplication.class, args);
	}

}
