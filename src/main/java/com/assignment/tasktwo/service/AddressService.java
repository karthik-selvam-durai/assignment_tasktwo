package com.assignment.tasktwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.tasktwo.model.Address;
import com.assignment.tasktwo.repository.AddressRespository;

@Service
public class AddressService {

	@Autowired
	AddressRespository addressRespository;

	public Long getAddressCode(Address address) {
		return addressRespository.findByAddressAndCityAndState(address.getAddress(), address.getCity(),
				address.getState());
	}
}
