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

import com.tikifake.model.request.creator.ShopCreatorRequest;
import com.tikifake.model.request.update.ShopUpdateRequest;
import com.tikifake.model.response.creator.ShopCreatorResponse;
import com.tikifake.model.response.detail.IShopDetail;
import com.tikifake.model.response.list.IShopList;
import com.tikifake.model.response.update.ShopUpdateResponse;
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
		List<IShopList> shops = shopService.getAllShop();
		return ResponseEntity.ok().body(shops);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addShop(@RequestBody ShopCreatorRequest shopCreator) {
		ShopCreatorResponse shopResponse = shopService.save(shopCreator);
		return ResponseEntity.ok().body(shopResponse);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ShopUpdateRequest shopUpdate) {
		ShopUpdateResponse shopResponse = shopService.update(shopUpdate);
		return ResponseEntity.ok().body(shopResponse);
	}
}
