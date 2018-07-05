package com.assignment.tasktwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.tasktwo.model.OrderDetails;

public interface OrderRespository extends JpaRepository<OrderDetails, Long>{

}
