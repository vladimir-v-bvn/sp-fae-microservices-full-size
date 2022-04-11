package com.vber.spfaeinventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vber.spfaeinventoryservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

  Optional<Inventory> findById(Integer eventId);
}
