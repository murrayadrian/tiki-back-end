package com.tikifake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.entity.Order;
import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.OrderRequest;
import com.tikifake.model.response.creator.CartItemCheckoutResponse;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.service.CartItemService;
import com.tikifake.service.CartService;
import com.tikifake.service.OrderService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProductToCart(@RequestBody CartItemCreatorRequest cartItemCreatorRequest) {
		CartItemCreatorResponse response = cartItemService.addProductToCart(cartItemCreatorRequest);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/checkout/{cartId}")
	public ResponseEntity<Object> checkout(@PathVariable("cartId") Long cartId) {
		List<CartItemCheckoutResponse> response = cartService.checkout(cartId);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Object> order(@RequestBody OrderRequest orderRequest) {
		Order response = orderService.order(orderRequest);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/getAllCartItem/{cartId}")
	public ResponseEntity<Object> getAllCartItem(@PathVariable("cartId") Long cartId) {
		List<CartItemCreatorResponse> response = cartService.getAllItemInCart(cartId);
		return ResponseEntity.ok().body(response);

	}
	
	@PutMapping("/increaseByOne")
	public ResponseEntity<Object> increaseByOne(@RequestBody CartItemInfoRequest info) {
		CartItemCreatorResponse response = cartItemService.increaseByOne(info);
		return ResponseEntity.ok().body(response);
	}
	@PutMapping("/decreaseByOne")
	public ResponseEntity<Object> decreaseByOne(@RequestBody CartItemInfoRequest info) {
		CartItemCreatorResponse response = cartItemService.decreaseByOne(info);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/checkItem")
	public ResponseEntity<Object> checkItem(@RequestBody CartItemInfoRequest info) {
		CartItemCreatorResponse response = cartItemService.checkItem(info);
		return ResponseEntity.ok().body(response);
	}
	@PutMapping("/checkAllItem/{cartId}")
	public ResponseEntity<Object> checkAllItem(@PathVariable("cartId") Long cartId) {
		List<CartItemCreatorResponse> response = cartItemService.checkAllItem(cartId);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/unCheckAllItem/{cartId}")
	public ResponseEntity<Object> unCheckAllItem(@PathVariable("cartId") Long cartId) {
		List<CartItemCreatorResponse> response = cartItemService.unCheckAllItem(cartId);
		return ResponseEntity.ok().body(response);
	}
	
	
	@DeleteMapping("/removeProductFromCart")
	public ResponseEntity<Object> removeProductFromCart(@RequestBody CartItemInfoRequest cartItemInfoRequest) {
		cartItemService.removeProductFromCart(cartItemInfoRequest);
		return ResponseEntity.ok().body("remove successfully");

	}
	
	@DeleteMapping("/removeAllCheckedItem/{cartId}")
	public ResponseEntity<Object> removeAllCheckedItem(@PathVariable("cartId") Long cartId) {
		cartItemService.removeAllCheckedItem(cartId);
		return ResponseEntity.ok().body("remove successfully");

	}
	
	
}
