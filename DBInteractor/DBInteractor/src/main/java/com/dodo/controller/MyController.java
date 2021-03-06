package com.dodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dodo.entity.ProductTransactionData;
import com.dodo.service.DBServiceManager;

@Controller
public class MyController {

	@Autowired
	DBServiceManager dbServiceManager;
	
	@RequestMapping("/homePage")
	public String hello()
	{
		return "homePage";
	}
	
	@RequestMapping(value = "/storeData", method = RequestMethod.POST)
	public @ResponseBody String storeData(@RequestBody ProductTransactionData productTransactionData) {	
		dbServiceManager.saveProductData(productTransactionData);
		return "saved successfully";
	}

}
