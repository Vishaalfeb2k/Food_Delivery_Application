package com.fooddelivery.customer.service;

import com.fooddelivery.customer.dto.Customer;

import java.util.List;

public interface RegisterService  {

	List<Customer> getcust() throws Exception;

	void addcust(Customer customer);

	Customer updatedetails(Long id,Customer customer);

	void deletecust(Long id);

}
