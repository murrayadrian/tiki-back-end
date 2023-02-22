package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.OrderRequest;
import com.tikifake.model.response.list.IOrderItem;

public interface OrderService {
	
	public List<IOrderItem> order(OrderRequest orderRequest);
	
}
