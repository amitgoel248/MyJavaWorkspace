package com.dodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dodo.entity.Product;
import com.dodo.service.SolrServiceManager;

@Controller
public class MyController {

	@Autowired
	SolrServiceManager solrServiceManager;
	
	@RequestMapping("/homePage")
	public String hello() {
		return "homePage";
	}
	
	//TODO no mapping has to be provided .... only internal implementation for storing data
	
	@RequestMapping(value = "/storeData", method = RequestMethod.POST)
	public @ResponseBody String storeData(@RequestBody Product productTransactionData) {
		solrServiceManager.saveData(productTransactionData);
		return "saved successfully";
	}
	
	@RequestMapping(value = "/fetchData", method = RequestMethod.GET)
	public @ResponseBody List<Product> fetchData(@RequestParam String prefix) {
		return solrServiceManager.fetchData(prefix);
	}

}
