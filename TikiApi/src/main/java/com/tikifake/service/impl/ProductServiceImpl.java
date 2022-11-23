package com.tikifake.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tikifake.entity.CategorySub;
import com.tikifake.entity.Product;
import com.tikifake.model.request.creator.ProductCreator;
import com.tikifake.model.request.update.ProductUpdate;
import com.tikifake.model.response.creator.ProductResponse;
import com.tikifake.model.response.detail.ICategorySubDetail;
import com.tikifake.model.response.detail.IProductDetail;

import com.tikifake.model.response.list.IProductList;

import com.tikifake.repository.CategorySubRepository;
import com.tikifake.repository.ProductRepository;
import com.tikifake.service.CategorySubService;
import com.tikifake.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final int SIZE = 5;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategorySubService categorySubService;

	@Autowired
	private CategorySubRepository categorySubRepository;

	@Override
	public IProductDetail getDetailById(Long productId) {
		return productRepository.findByIdDTO(productId);
	}

	@Override
	public List<IProductList> getAll(int page, String sort) {
		Pageable pageable;
		if (sort != null) {
			String[] partsOfSort = sort.split("_");
			String sortDirection = partsOfSort[1];
			String sortBy = partsOfSort[0];
			if (sortDirection.equalsIgnoreCase("desc")) {
				pageable = PageRequest.of(page, SIZE, Sort.by(sortBy).descending());
			} else {
				pageable = PageRequest.of(page, SIZE, Sort.by(sortBy).ascending());
			}

		} else {
			pageable = PageRequest.of(page, SIZE, Sort.by("name").descending());
		}

		List<IProductList> findAllCategory = productRepository.findAllDTO(pageable);
		return findAllCategory;
	}

	@Override
	public List<IProductDetail> getByCategorySubId(Long id, int page, String sort) {
		Pageable pageable;
		if (sort != null) {
			String[] partsOfSort = sort.split("_");
			String sortDirection = partsOfSort[1];
			String sortBy = partsOfSort[0];
			if (sortDirection.equalsIgnoreCase("desc")) {
				pageable = PageRequest.of(page, SIZE, Sort.by(sortBy).descending());
			} else {
				pageable = PageRequest.of(page, SIZE, Sort.by(sortBy).ascending());
			}

		} else {
			pageable = PageRequest.of(page, SIZE, Sort.by("name").descending());
		}

		List<IProductDetail> findByCategorySubId = productRepository.findByCategorySubId(id, pageable);
		return findByCategorySubId;
	}

	@Override

	public Map<String, List<IProductDetail>> getByCategoryId(Long id, int page, String sort) {

		List<ICategorySubDetail> iCategorySubs = categorySubService.getByCategoryId(id);
		List<IProductDetail> iProductList;
		Map<String, List<IProductDetail>> iProductMap = new HashMap<>();

		for (ICategorySubDetail iCategorySub : iCategorySubs) {
			String categorySubName = iCategorySub.getName();
			System.out.println(categorySubName);
			Long categorySubId = iCategorySub.getId();
			iProductList = new ArrayList<>();
			Pageable pageable;
			if (sort != null) {
				String[] partsOfSort = sort.split("_");
				String sortDirection = partsOfSort[1];
				String sortBy = partsOfSort[0];
				if (sortDirection.equalsIgnoreCase("desc")) {
					pageable = PageRequest.of(page, SIZE, Sort.by(sortBy).descending());
				} else {
					pageable = PageRequest.of(page, SIZE, Sort.by(sortBy).ascending());
				}

			} else {
				pageable = PageRequest.of(page, SIZE, Sort.by("name").descending());
			}
			iProductList = productRepository.findByCategorySubId(categorySubId, pageable);
			iProductMap.put(categorySubName, iProductList);
		}
		return iProductMap;
	}

	@Override
	public ProductResponse save(ProductCreator productCreator) {
		CategorySub categoryById = categorySubService.getCategoryById(productCreator.getCategorySubId());
		Product product = productCreator.convertDTOToEntity(categoryById);
		Product result = productRepository.save(product);
		ProductResponse productAdd = new ProductResponse(result);
		return productAdd;
	}

	@Override
	public void update(ProductUpdate productUpdate) {
		CategorySub categorySub = categorySubRepository.findById(productUpdate.getCategorySubId()).get();
		Product existedProduct = productRepository.findById(productUpdate.getId()).get();
		// nếu không set lại date thì date sẽ là null sau khi update
		LocalDateTime date = existedProduct.getCreatedDate();
		Product product = productUpdate.convertToEntity(categorySub, date);
		productRepository.save(product);
	}

}
