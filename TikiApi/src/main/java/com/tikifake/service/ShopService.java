package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.ShopCreator;
import com.tikifake.model.request.update.ShopUpdate;
import com.tikifake.model.response.creator.ShopResponse;
import com.tikifake.model.response.detail.IShopDetail;

public interface ShopService {

	public IShopDetail getDetailById(Long shopId);

	public List<IShopDetail> getAll();

	public ShopResponse save(ShopCreator shopCreator);

	public ShopResponse update(ShopUpdate shopUpdate);
}
