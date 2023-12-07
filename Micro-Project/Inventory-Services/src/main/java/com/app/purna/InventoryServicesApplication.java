package com.app.purna;

import com.app.purna.Entity.Inventory;
import com.app.purna.dto.InventoryResponse;
import com.app.purna.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(0);

			//inventoryRepository.save(inventory);
			//inventoryRepository.save(inventory1);
		};
	}
}
