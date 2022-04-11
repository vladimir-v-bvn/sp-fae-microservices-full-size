package com.vber.spfaeinventoryservice.service;

import org.springframework.stereotype.Service;

import com.vber.spfaeinventoryservice.model.Inventory;
import com.vber.spfaeinventoryservice.repository.InventoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryService {

  private InventoryRepository inventoryRepository;

  public Boolean isInStock(Integer eventId) {
    Inventory inventory = inventoryRepository.findById(eventId)
                                             .orElseThrow(() -> new RuntimeException("No such event " + eventId));
    return inventory.getSeatsAvailable() > 0;
  } 

}
