package com.vber.spfaeorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RequiredArgsConstructor
public class SpFaeOrderServiceApplication {

  private final BeanFactory beanFactory;
  
	public static void main(String[] args) {
		SpringApplication.run(SpFaeOrderServiceApplication.class, args);
	}
  
  @Bean
  public RequestInterceptor requestTokenBearerInterceptor() {
   return requestTemplate -> {
     JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
   //log.info("Bearer " + token.getToken().getTokenValue());
     requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
     };
  }

  @Bean
  public ExecutorService traceableExecutorService() {
      ExecutorService executorService = Executors.newCachedThreadPool();
      return new TraceableExecutorService(beanFactory, executorService);
  }

}
