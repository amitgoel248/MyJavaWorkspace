package com.dodo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dodo.entity.Advertisement;
import com.dodo.entity.Product;
import com.dodo.repository.AdvertisementRepository;
import com.dodo.repository.ProductRepository;

@SpringBootApplication
public class SolrServiceManager{

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	public void saveData(Product product)
	{
		this.productRepository.save(product);
	}
	
	public List<Product> fetchData(String prefix)
	{
		List<Product> products = new ArrayList<>();
		for (Product product : this.productRepository.findByProductNameStartingWith(prefix)) {
			products.add(product);
		}
		return products;
	}
	
	public void saveAdd(Advertisement add)
	{
		this.advertisementRepository.save(add);
	}
	
	
	
}