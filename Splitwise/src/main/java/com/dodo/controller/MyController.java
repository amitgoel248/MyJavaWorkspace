package com.dodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dodo.entity.TransactionData;
import com.dodo.service.DBServiceManager;

@Controller
public class MyController {

	@Autowired
	DBServiceManager dbServiceManager;

	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public @ResponseBody String addTransaction(@RequestBody TransactionData transactionData) {
		dbServiceManager.saveProductData(transactionData);
		return "saved successfully";
	}

	@RequestMapping(value = "/viewAllTransactions", method = RequestMethod.POST)
	public @ResponseBody String viewAllTransactions(@RequestBody TransactionData productTransactionData) {
		dbServiceManager.saveProductData(productTransactionData);
		return "saved successfully";
	}

	@RequestMapping(value = "/viewSingleTransaction", method = RequestMethod.POST)
	public @ResponseBody String viewSingleTransaction(@RequestBody TransactionData productTransactionData) {
		dbServiceManager.saveProductData(productTransactionData);
		return "saved successfully";
	}

	@RequestMapping(value = "/settleUp", method = RequestMethod.POST)
	public @ResponseBody String settleUp(@RequestBody TransactionData productTransactionData) {
		dbServiceManager.saveProductData(productTransactionData);
		return "saved successfully";
	}
	
	@RequestMapping(value = "/showMyBalances", method = RequestMethod.POST)
	public @ResponseBody String showMyBalances(@RequestBody TransactionData productTransactionData) {	
		dbServiceManager.saveProductData(productTransactionData);
		return "saved successfully";
	}
	
	@RequestMapping(value = "/createGroup", method = RequestMethod.POST)
	public @ResponseBody String createGroup(@RequestBody TransactionData productTransactionData) {	
		dbServiceManager.saveProductData(productTransactionData);
		return "saved successfully";
	}
}
