package com.assignment.tasktwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.tasktwo.model.Address;

@Repository
public interface AddressRespository extends JpaRepository<Address, Long>{

	@Query("select a.addressCode from Address a where a.address = ?1 and a.city = ?2 and a.state = ?3")
	Long findByAddressAndCityAndState(String address, String city, String state);

}
