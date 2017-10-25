package com.dodo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dodo.entity.Product;
import com.dodo.repository.ProductRepository;

@SpringBootApplication
public class SolrServiceManager{

	@Autowired
	private ProductRepository repository;

	public void saveData(Product product)
	{
		this.repository.save(product);
	}
	
	public List<Product> fetchData(String prefix)
	{
		List<Product> products = new ArrayList<>();
		for (Product product : this.repository.findByNameStartingWith(prefix)) {
			products.add(product);
		}
		return products;
	}
}