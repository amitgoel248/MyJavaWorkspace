package com.dodo.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "adds")
public class Advertisement {

	@Id
	@Field
	private String addId;
	@Field
	private String productId;
	@Field
	private String quantity;
	@Field
	private Integer pricePerItem;
	@Field
	private String mobileNo;
	@Field
	private String address;
	@Field
	private String State;
	@Field
	private String pincode;

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(Integer pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
