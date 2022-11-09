package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Shop;
import com.tikifake.model.request.creator.ShopCreator;
import com.tikifake.model.request.update.ShopUpdate;
import com.tikifake.model.response.creator.ShopResponse;
import com.tikifake.model.response.detail.IShopDetail;
import com.tikifake.repositoty.ShopRepository;
import com.tikifake.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public IShopDetail getDetailById(Long shopId) {
		return shopRepository.findByIdDTO(shopId);
	}

	@Override
	public List<IShopDetail> getAll() {
		return shopRepository.findAllDTO();
	}

	@Override
	public ShopResponse save(ShopCreator shopCreator) {
		Shop shop = shopCreator.convertModelToEntity();
		Shop result = shopRepository.save(shop);
		ShopResponse shopResponse = new ShopResponse().convertEntityToModel(result);
		return shopResponse;
	}

	@Override
	public ShopResponse update(ShopUpdate shopUpdate) {
		Shop shop = shopUpdate.convertModelToEntity();
		Shop result = shopRepository.save(shop);
		ShopResponse shopResponse = new ShopResponse().convertEntityToModel(result);
		return shopResponse;
	}

}
