package com.fooddelivery.delivery.service;

import com.fooddelivery.delivery.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeliveryVerificationService
{

    List<Customer> getCustomerDetails();

    ResponseEntity<String> verifyCustomer(String customerName, long mobileNo, String emailId);
}
