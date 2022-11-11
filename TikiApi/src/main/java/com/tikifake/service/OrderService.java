package com.tikifake.service;

import com.tikifake.entity.Order;
import com.tikifake.model.request.creator.OrderRequest;

public interface OrderService {
	
	public Order order(OrderRequest orderRequest);
}
