package com.fooddelivery.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddelivery.customer.dto.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByusername(String username);
}
