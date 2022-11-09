package com.tikifake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.ShopCreator;
import com.tikifake.model.request.update.ShopUpdate;
import com.tikifake.model.response.creator.ShopResponse;
import com.tikifake.model.response.detail.IShopDetail;
import com.tikifake.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getShopById(@PathVariable(value = "id") Long shopId) {
		IShopDetail shop = shopService.getDetailById(shopId);
		if (shop == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shop Not Found");
		}
		return ResponseEntity.ok().body(shop);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllShop() {
		List<IShopDetail> shops = shopService.getAll();
		return ResponseEntity.ok().body(shops);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addShop(@RequestBody ShopCreator shopCreator) {
		ShopResponse shopResponse = shopService.save(shopCreator);
		return ResponseEntity.ok().body(shopResponse);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ShopUpdate shopUpdate) {
		ShopResponse shopResponse = shopService.update(shopUpdate);
		return ResponseEntity.ok().body(shopResponse);
	}
}
