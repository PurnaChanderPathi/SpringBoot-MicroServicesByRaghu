package com.app.purna.service;

import com.app.purna.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.purna.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode)
	{
		return inventoryRepository.findBySkuCodeIn(skuCode).stream()
				.map(inventory ->
					InventoryResponse.builder()
							.skuCode(inventory.getSkuCode())
							.isInStock(inventory.getQuantity() > 0)
							.build()
					).toList();
	}
}
