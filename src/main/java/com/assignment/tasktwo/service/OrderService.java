package com.assignment.tasktwo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.tasktwo.model.Address;
import com.assignment.tasktwo.model.OrderDetails;
import com.assignment.tasktwo.repository.OrderRespository;
import com.assignment.tasktwo.util.CustomApiError;

@Service
public class OrderService {
	
	@Autowired
	OrderRespository orderRespository;
	
	@Autowired
	AddressService addressService;
	
	public ResponseEntity<?> updateOrder(Long id, Address address) {


		Optional<OrderDetails> orderOptional = orderRespository.findById(id);

		if (!orderOptional.isPresent()) {
			return new ResponseEntity<CustomApiError>(
					new CustomApiError("Unable to upate. Order with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}

		OrderDetails order = orderOptional.get();
		
		Long addressCode = addressService.getAddressCode(address);
		
		if (addressCode == null || addressCode == 0) {
			return new ResponseEntity<CustomApiError>(new CustomApiError("Unable to upate. Address Code Not Found."),
					HttpStatus.NOT_FOUND);
		}
		address.setAddressCode(addressCode);
		address.setOrderDetails(order);
		order.setAddress(address);
		orderRespository.save(order);
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	
	}

}
