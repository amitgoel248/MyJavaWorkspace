package com.dodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.dodo.entity.ProductTransactionData;
import com.dodo.repository.ProductDataRepository;

@Service
public class MongoServiceManager {

	@Autowired
	ProductDataRepository productDataRepository;

	public void saveProductData(ProductTransactionData productTransactionData) {
		productDataRepository.save(productTransactionData);
	}
	
	public List<ProductTransactionData> findProducts(String pattern)
	{
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(pattern);
		List<ProductTransactionData> productsList =	productDataRepository.findAll(sort);
		return productsList;
	}
}
