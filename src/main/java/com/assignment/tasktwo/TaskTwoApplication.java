package com.assignment.tasktwo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.tasktwo.model.Address;
import com.assignment.tasktwo.model.OrderDetails;
import com.assignment.tasktwo.repository.AddressRespository;
import com.assignment.tasktwo.repository.OrderRespository;

@SpringBootApplication(scanBasePackages = { "com.assignment.tasktwo" })
public class TaskTwoApplication implements CommandLineRunner {

	@Autowired
	OrderRespository orderService;
	@Autowired
	AddressRespository addressService;

	public static void main(String[] args) {
		SpringApplication.run(TaskTwoApplication.class, args);
	}

	@Transactional
	private void deleteData() {
		orderService.deleteAll();
		addressService.deleteAll();
	}

	@Transactional
	private void saveData() {
		Address address = new Address("mill road", "CBE", "TN");
		addressService.save(address);

		OrderDetails order = new OrderDetails(address);
		orderService.save(order);

		Address address1 = new Address("test", "test", "test");
		addressService.save(address1);

		OrderDetails order1 = new OrderDetails(address1);
		orderService.save(order1);

	}

	@Transactional
	private void showData() {
		// get All data
		List<OrderDetails> orders = orderService.findAll();
		List<Address> addresses = addressService.findAll();

		System.out.println("===================Orders:==================");
		orders.forEach(System.out::println);

		System.out.println("===================Address:==================");
		addresses.forEach(System.out::println);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteData();
		saveData();
		showData();

	}
}
