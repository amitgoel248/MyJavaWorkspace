package com.dodo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "zips")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTransactionData {

	@Id
	String _id;
	String city;
	List<Double> loc;
	String pop;
	String state;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Double> getLoc() {
		return loc;
	}
	public void setLoc(List<Double> loc) {
		this.loc = loc;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}