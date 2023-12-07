package com.app.purna.controller;

import com.app.purna.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.app.purna.service.InventoryService;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	//http://localhost:9092/Inventory/iphone13,iphone13-red

	//http://localhost:9092/Inventory?skuCode=iphone13&sku-Code=iphone13-red
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode)

	{
		return inventoryService.isInStock(skuCode);
	}
}