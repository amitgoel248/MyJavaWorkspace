package com.dodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodo.entity.ProductTransactionData;
import com.dodo.repository.ProductDataRepository;

@Service
public class MongoServiceManager {
	
	@Autowired
	ProductDataRepository productDataRepository;
	
	public void saveProductData(ProductTransactionData productTransactionData)
	{
		productDataRepository.save(productTransactionData);
	}
	
}
