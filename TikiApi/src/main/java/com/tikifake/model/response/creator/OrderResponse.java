package com.tikifake.model.response.creator;

import java.util.List;

import com.tikifake.entity.OrderItem;

public class OrderResponse {
	
	private Long orderId;
	
	private Long userId;
	
	private String userName;
	
	private double totalCost;
	
	private String status;
	
	private List<OrderItem> orderItems;

	public Long getOrderId() {
		return orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public String getStatus() {
		return status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	
}
