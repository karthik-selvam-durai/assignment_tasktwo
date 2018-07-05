package com.assignment.tasktwo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long addressCode;
	private String address;
	private String city;
	private String state;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY, targetEntity = OrderDetails.class)
	private OrderDetails orderDetails;
	
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Address() {}

	public Address(String address, String city, String state) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public long getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(long addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
