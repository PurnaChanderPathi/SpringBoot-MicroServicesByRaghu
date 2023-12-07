package com.app.purna.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.app.purna.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.purna.dto.OrderLineItemsDto;
import com.app.purna.dto.OrderRequest;
import com.app.purna.entity.Order;
import com.app.purna.entity.OrderLineItems;
import com.app.purna.repository.OrderRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
public class OrderService {
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
		.stream()
		.map(this::mapToDto).toList();
		order.setOrderLineItemsList(orderLineItems);

		List<String> skuCodes = order.getOrderLineItemsList().stream()
				.map(OrderLineItems::getSkuCode)
				.toList();

		//Call Inventory Service and place order if product is in Stock
		InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get().uri("http://inventory-service/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build() )
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();

		boolean allProductsIsInStock = Arrays.stream(inventoryResponseArray)
				.allMatch(InventoryResponse::isInStock);

	if(allProductsIsInStock)
	{
		orderRepository.save(order);
	}else
	{
		throw new IllegalArgumentException("Product is not in the Stock, Please try again");
	}

	}
	

	private OrderLineItems mapToDto(OrderLineItemsDto orderlineitemsdto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderlineitemsdto.getPrice());
		orderLineItems.setQuantity(orderlineitemsdto.getQuantity());
		orderLineItems.setSkuCode(orderlineitemsdto.getSkuCode());
		return orderLineItems;		
	}
	
	
}
