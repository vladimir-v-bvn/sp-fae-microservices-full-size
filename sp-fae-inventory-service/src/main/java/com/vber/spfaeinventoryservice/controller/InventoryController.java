package com.vber.spfaeinventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vber.spfaeinventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
  
  @Autowired
  private InventoryService inventoryService;

//@GetMapping("/{eventId}")
//Boolean isInStock(@PathVariable Integer eventId) {
//  return inventoryService.isInStock(eventId);
//} 

  @GetMapping
  Boolean isInStock() {
    return inventoryService.isInStock(10001);
  } 
//  @GetMapping
//  public ResponseEntity<String> isInStockStub() {
//    return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "").body("false");
//  }
}
