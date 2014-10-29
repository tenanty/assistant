package com.channelsoft.assistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.assistant.entity.Customer;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Long> {

	public List<Customer> findByCustName(String custName);

	@Modifying
	@Transactional(timeout = 10)
	@Query("delete from Customer customer where customer.custName = ?1 ")
	public void deleteByCustName(String custName);

}
