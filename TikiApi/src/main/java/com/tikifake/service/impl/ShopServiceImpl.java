package com.tikifake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.Shop;
import com.tikifake.model.request.creator.ShopCreatorRequest;
import com.tikifake.model.request.update.ShopUpdateRequest;
import com.tikifake.model.response.creator.ShopCreatorResponse;
import com.tikifake.model.response.detail.IShopDetail;
<<<<<<< HEAD
=======
import com.tikifake.model.response.exception.BadRequestException;
import com.tikifake.model.response.list.IShopList;
import com.tikifake.model.response.update.ShopUpdateResponse;
>>>>>>> master
import com.tikifake.repository.ShopRepository;
import com.tikifake.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public IShopDetail getDetailById(Long shopId) {
		return shopRepository.findByIdDTO(shopId);
	}

	@Override
	public List<IShopList> getAllShop() {
		return shopRepository.findAllDTO();
	}

	@Override
	public ShopCreatorResponse save(ShopCreatorRequest shopCreator) {
		if (shopRepository.existsByName(shopCreator.getName())) {
			throw new BadRequestException("Shop is already taken!");
		}
		Shop shopRequest = shopCreator.convertModelToEntity();
		Shop result = shopRepository.save(shopRequest);
		ShopCreatorResponse shopResponse = new ShopCreatorResponse().convertEntityToModel(result);
		return shopResponse;
	}

	@Override
	public ShopUpdateResponse update(ShopUpdateRequest shopUpdate) {
		boolean isExistShop = shopRepository.isExistNameUpdate(shopUpdate.getId(), shopUpdate.getName());
		if (isExistShop) {
			throw new BadRequestException("Shop is already taken!");
		}
		Shop shop = shopUpdate.convertModelToEntity();
		Shop result = shopRepository.save(shop);
		ShopUpdateResponse shopResponse = new ShopUpdateResponse().convertEntityToModel(result);
		return shopResponse;
	}

}
