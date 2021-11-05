package com.fooddelivery.customer.service;

import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.customer.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.customer.dto.Customer;
import com.fooddelivery.customer.repository.CustomerRepository;
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private CustomerRepository custRepo;
	
	public void addcust(Customer customer) {
		custRepo.save(customer);
	}



	public void deletecust(Long id) {
		custRepo.deleteById(id);
	}

	public List<Customer> getcust() throws Exception {
		
		List<Customer> customers = new ArrayList<>();
		 custRepo.findAll().forEach(customers::add);
		 if (customers.isEmpty())
			 throw new CustomerNotFoundException("not found");
		return customers;
	}


	public Customer updatedetails(Long id,Customer customer) {

		Customer customer1 = custRepo.findById(id).get();
		customer1.setAddress(customer.getAddress());
		customer1.setEmail(customer.getEmail());
		customer1.setPassword(customer.getPassword());
		customer1.setUsername(customer.getUsername());

		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		customer1.setPhoneNum(customer.getPhoneNum());
		return custRepo.save(customer1);
	}



}
