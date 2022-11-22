package com.tikifake.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikifake.entity.OrderItem;
import com.tikifake.entity.embeddedid.OrderItemId;
import com.tikifake.model.response.list.IOrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
	
	public OrderItem findOrderItemByIdOrderIdAndIdProductId(Long orderId, Long productId);
	
	@Query("select o from OrderItem o where o.order.id = ?1")
	public List<IOrderItem> getOrderItem(Long orderId);
}
