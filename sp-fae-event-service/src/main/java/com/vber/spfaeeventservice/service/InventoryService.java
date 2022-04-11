package com.vber.spfaeeventservice.service;

import com.vber.spfaeeventservice.model.Inventory;
import com.vber.spfaeeventservice.repository.InventoryRepository;

public class InventoryService {
  
  private InventoryRepository inventoryRepository;

  public Boolean isInStock(Integer eventId) {
    Inventory inventory = inventoryRepository.findById(eventId)
                                             .orElseThrow(() -> new RuntimeException("No such event " + eventId));
    return inventory.getSeatsAvailable() > 0;
  } 

}
