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

import com.tikifake.model.request.creator.CartItemCreatorRequest;
import com.tikifake.model.request.creator.CartItemIdRequest;
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.CheckItemRequest;
import com.tikifake.model.request.creator.OrderRequest;
import com.tikifake.model.response.creator.CartDTO;
import com.tikifake.model.response.creator.CartItemCheckoutResponse;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.list.ICartItemList;
import com.tikifake.model.response.list.IOrderItem;
import com.tikifake.service.CartItemService;
import com.tikifake.service.CartService;
import com.tikifake.service.OrderItemService;
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
	
	@Autowired
	private OrderItemService orderItemService;
	
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
	@GetMapping("/getOrderItem/{orderId}")
	public ResponseEntity<Object> getOrderItem(@PathVariable("orderId") Long orderId) {
		List<IOrderItem> response = orderItemService.getOrderItem(orderId);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Object> order(@RequestBody OrderRequest orderRequest) {
		List<IOrderItem> response = orderService.order(orderRequest);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/getAllCartItem/{cartId}")
	public ResponseEntity<Object> getAllCartItem(@PathVariable("cartId") Long cartId) {
		CartDTO response = cartService.getEverything(cartId);
		return ResponseEntity.ok().body(response);

	}
	
	@PostMapping("/changeQuantity")
	public ResponseEntity<Object> changeQuantity(@RequestBody CartItemInfoRequest info) {
		CartItemCreatorResponse response = cartItemService.changeQuantity(info);
		return ResponseEntity.ok().body(response);
	}
	
	
	@PutMapping("/checkItem")
	public ResponseEntity<Object> checkItem(@RequestBody CheckItemRequest info) {
		List<ICartItemList> response = cartItemService.checkItem(info);
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
	public ResponseEntity<Object> removeProductFromCart(@RequestBody CartItemIdRequest cartItemIdRequest) {
		cartItemService.removeProductFromCart(cartItemIdRequest);
		return ResponseEntity.ok().body(cartItemIdRequest);

	}
	
	@DeleteMapping("/removeAllCheckedItem/{cartId}")
	public ResponseEntity<Object> removeAllCheckedItem(@PathVariable("cartId") Long cartId) {
		cartItemService.removeAllCheckedItem(cartId);
		return ResponseEntity.ok().body("remove successfully");
	}
	
	@GetMapping("/getAllCheckedItem/{cartId}")
	public ResponseEntity<Object> getAllCheckedItem(@PathVariable("cartId") Long cartId) {
		List<ICartItemList> response = cartService.findAllCheckedItemInCart(cartId);
		return ResponseEntity.ok().body(response);
	}
	
}
