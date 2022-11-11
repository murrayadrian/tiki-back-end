package com.tikifake.service;

import java.util.List;

import com.tikifake.model.request.creator.ShopCreatorRequest;
import com.tikifake.model.request.update.ShopUpdateRequest;
import com.tikifake.model.response.creator.ShopCreatorResponse;
import com.tikifake.model.response.detail.IShopDetail;
import com.tikifake.model.response.list.IShopList;
import com.tikifake.model.response.update.ShopUpdateResponse;

public interface ShopService {

	public IShopDetail getDetailById(Long shopId);

	public List<IShopList> getAllShop();

	public ShopCreatorResponse save(ShopCreatorRequest shopCreator);

	public ShopUpdateResponse update(ShopUpdateRequest shopUpdate);
}
