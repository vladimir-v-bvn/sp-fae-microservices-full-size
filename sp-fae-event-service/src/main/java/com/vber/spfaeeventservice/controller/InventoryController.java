package com.vber.spfaeeventservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vber.spfaeeventservice.service.InventoryService;

@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {
  
  private InventoryService inventoryService;

  @GetMapping("/{eventId}")
  Boolean isInStock(@PathVariable Integer eventId) {
    return inventoryService.isInStock(eventId);
  } 

  @GetMapping()
  Boolean isInStockStub() {
    return true;
  } 
}
