package com.vber.spfaeeventservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vber.spfaeeventservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

  Optional<Inventory> findById(Integer eventId);
}
