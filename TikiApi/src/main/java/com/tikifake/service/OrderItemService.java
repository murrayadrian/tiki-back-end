package com.tikifake.service;

import java.util.List;

import com.tikifake.model.response.list.IOrderItem;

public interface OrderItemService {
	
	public List<IOrderItem> getOrderItem(Long orderId);
}
