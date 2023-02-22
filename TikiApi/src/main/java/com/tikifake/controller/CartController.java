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
import com.tikifake.model.request.creator.CartItemInfoRequest;
import com.tikifake.model.request.creator.CheckItemRequest;
import com.tikifake.model.request.creator.OrderRequest;
import com.tikifake.model.request.creator.RemoveProductRequest;
import com.tikifake.model.request.creator.ShopCheckRequest;
import com.tikifake.model.response.creator.CartDTO;
import com.tikifake.model.response.creator.CartItemCreatorResponse;
import com.tikifake.model.response.creator.ChangeQuantityResponse;
import com.tikifake.model.response.creator.FinalPriceResponse;
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
		ChangeQuantityResponse response = cartItemService.changeQuantity(info);
		return ResponseEntity.ok().body(response);
	}
	
	
	@PutMapping("/checkItem")
	public ResponseEntity<Object> checkItem(@RequestBody CheckItemRequest info) {
		FinalPriceResponse response = cartItemService.checkItem(info);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/checkAllItem/{cartId}")
	public ResponseEntity<Object> checkAllItem(@PathVariable("cartId") Long cartId) {
		FinalPriceResponse response = cartItemService.checkAllItem(cartId);
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/checkAllItemInShop")
	public ResponseEntity<Object> checkAllItemInShop(@RequestBody ShopCheckRequest info) {
		FinalPriceResponse response = cartItemService.checkAllItemInShop(info);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("/removeProductFromCart")
	public ResponseEntity<Object> removeProductFromCart(@RequestBody RemoveProductRequest removeProductRequest) {
		FinalPriceResponse response = cartItemService.removeProductFromCart(removeProductRequest);
		return ResponseEntity.ok().body(response);

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
