package com.app.purna.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
