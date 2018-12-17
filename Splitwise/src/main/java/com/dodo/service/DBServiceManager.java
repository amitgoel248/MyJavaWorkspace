package com.dodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodo.entity.TransactionData;
import com.dodo.repository.ProductDataRepository;

@Service
public class DBServiceManager {

	@Autowired
	ProductDataRepository productDataRepository;

	public void saveProductData(TransactionData productTransactionData) {
		productDataRepository.save(productTransactionData);
	}

}
