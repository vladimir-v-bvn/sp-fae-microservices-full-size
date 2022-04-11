package com.vber.spfaeorderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vber.spfaeorderservice.service.OrderService;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
  
  @Autowired
  OrderService orderService;

  @GetMapping
  public ResponseEntity<Boolean> vOrder() {
    return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "").body(orderService.vOrder());
  }


}
