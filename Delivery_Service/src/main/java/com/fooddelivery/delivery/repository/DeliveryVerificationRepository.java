package com.fooddelivery.delivery.repository;

import com.fooddelivery.delivery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryVerificationRepository extends JpaRepository<Customer,Long>
{

    Customer findByCustomerNameAndMobileNoAndEmailId(String customerName, long mobileNo, String emailId);
}
