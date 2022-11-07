package com.tikifake.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tikifake.entity.CategorySub;
import com.tikifake.entity.Product;
import com.tikifake.model.ICategorySub;
import com.tikifake.model.IProduct;
import com.tikifake.model.creator.ProductCreator;
import com.tikifake.model.response.ProductResponse;
import com.tikifake.model.update.ProductUpdate;
import com.tikifake.repositoty.CategorySubRepository;
import com.tikifake.repositoty.ProductRepository;
import com.tikifake.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategorySubRepository categorySubRepository;

	@Override
	public IProduct getDetailById(Long productId) {
		return productRepository.findByIdDTO(productId);
	}

	@Override
	public List<IProduct> getAll() {
		return productRepository.findAllDTO();
	}

	@Override
	public List<IProduct> getByCategorySubId(Long id) {
		return productRepository.findByCategorySubId(id);
	}

	@Override
	public Map<String,List<IProduct>> getByCategoryId(Long id) {
		
		List<ICategorySub> iCategorySubs = categorySubRepository.findByCategoryId(id);
		List<IProduct> iProductList = new ArrayList<>();
		Map<String, List<IProduct>> iProductMap = new HashMap<>();
		
		for(int i = 0; i < iCategorySubs.size(); i++) {
			String categorySubName = iCategorySubs.get(i).getName();
			Long categorySubId = iCategorySubs.get(i).getId();
			
			iProductList = productRepository.findByCategorySubId(categorySubId);
			iProductMap.putIfAbsent(categorySubName, iProductList);
		}
		
		return iProductMap;
	}

//	@Override
//	public ProductResponse save(ProductCreator productCreator) {
//		CategorySub categoryModel = categorySubRepository.findById(productCreator.getCategorySubId()).get();
////		Product product = productCreator.convertDTOToEntity(categoryModel);
//		Product result = productRepository.save(product);
//		ProductResponse productAdd = new ProductResponse(result);
//		return productAdd;
//	}

	@Override
	public void update(ProductUpdate productUpdate) {
		CategorySub categorySub = categorySubRepository.findById(productUpdate.getCategorySubId()).get();
		Product existedProduct = productRepository.findById(productUpdate.getId()).get();
		// nếu không set lại date thì date sẽ là null sau khi update
		LocalDateTime date = existedProduct.getCreatedDate();
		Product product = productUpdate.convertToEntity(categorySub, date);
		productRepository.save(product);
	}

	@Override
	public ProductResponse save(ProductCreator productcreator) {
		// TODO Auto-generated method stub
		return null;
	}

}
