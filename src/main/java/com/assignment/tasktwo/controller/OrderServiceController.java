package com.assignment.tasktwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.tasktwo.model.Address;
import com.assignment.tasktwo.service.OrderService;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/orders/{orderId}/address", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOrder(@PathVariable("orderId") Long id, @RequestBody Address address) {
		return orderService.updateOrder(id, address);
	}

}
