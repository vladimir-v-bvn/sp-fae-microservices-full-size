package com.vber.spfaeorderservice.service;

import org.springframework.stereotype.Service;

import com.vber.spfaeorderservice.client.InventoryClient;
import com.vber.spfaeorderservice.repository.OrderRepositoryJdbc;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

  private final OrderRepositoryJdbc orderRepositoryJdbc;
  private final InventoryClient inventoryClient;
  private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
  private final ExecutorService traceableExecutorService;

  private final StreamBridge streamBridge;
  
//  public String vOrder() {
//    return orderRepositoryJdbc.vOrder();
//  }
  
  public Boolean vOrder() {
    circuitBreakerFactory.configureExecutorService(traceableExecutorService);
    Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");
/*
    boolean allProductsAreInStock = orderDto.getOrderItemsList().steam().allMatch(orderItem -> inventoryClient.isInStock(orderItem.eventId));
    java.util.function.Supplier<Boolean> allProductsAreInStockBooleanSupplier = () -> 
      orderDto.getOrderItemsList().steam().allMatch(orderItem -> {
        log.info("Making call to the inventory service by eventId",
        inventoryClient.isInStock(orderItem.eventId));
        return inventoryClient.isInStock(orderItem.eventId);
    });
*/
    java.util.function.Supplier<Boolean> allProductsAreInStockBooleanSupplier = () -> inventoryClient.isInStock();
    
  //boolean allProductsAreInStock = circuitBreaker.run(allProductsAreInStockBooleanSupplier, throwable -> handleErrorCase());
    boolean allProductsAreInStock = circuitBreaker.run(allProductsAreInStockBooleanSupplier);
  //return inventoryClient.isInStock(10001);
  //circuitBreaker.run(allProductsAreInStockBooleanSupplier);
  //return inventoryClient.isInStock();
    if (allProductsAreInStock) {
    //streamBridge.send("emailEventSupplier-out-0", orderItem.eventId);
    //streamBridge.send("emailEventSupplier-out-0", "10001");
      streamBridge.send("notificationEventSupplier-out-0", MessageBuilder.withPayload("10001").build());
    }
    return allProductsAreInStock;
  }
  
  public int eventCount() {
    return orderRepositoryJdbc.orderCount();
  }
  
// this method is just for testing
  public int orderCountStub() {
    return 6;
  }

  private Boolean handleErrorCase() {
    log.info("!!!");
    return false;
  }

}
