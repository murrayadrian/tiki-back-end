package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.model.response.list.IOrderItem;
import com.tikifake.repository.OrderItemRepository;
import com.tikifake.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Override
	public List<IOrderItem> getOrderItem(Long orderId) {
		return orderItemRepository.getOrderItem(orderId);
	}

}
