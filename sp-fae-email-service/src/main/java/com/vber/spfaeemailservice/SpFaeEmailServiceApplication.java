package com.vber.spfaeemailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

import com.vber.spfaeemailservice.service.EmailSender;

@SpringBootApplication
@EnableEurekaClient
public class SpFaeEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpFaeEmailServiceApplication.class, args);
	}
	
  @Bean
  public Consumer<Message<String>> emailEventSupplier() {
      return message -> new EmailSender().sendEmail(message.getPayload());
  }

}
