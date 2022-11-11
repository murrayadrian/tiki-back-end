package com.tikifake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tikifake.entity.OrderItem;
import com.tikifake.entity.embeddedid.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
	
	public OrderItem findOrderItemByIdOrderIdAndIdProductId(Long orderId, Long productId);
}
