package com.fooddelivery.delivery.service;

import com.fooddelivery.delivery.entity.Customer;
import com.fooddelivery.delivery.repository.DeliveryVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryVerificationServiceImpl implements DeliveryVerificationService
{
    @Autowired
    public DeliveryVerificationRepository deliveryVerificationRepository;


    @Override
    public List<Customer> getCustomerDetails() {
        return deliveryVerificationRepository.findAll();
    }

    @Override
    public ResponseEntity<String> verifyCustomer(String CustomerName, long mobileNo, String emailId)
    {

        if(deliveryVerificationRepository.findByCustomerNameAndMobileNoAndEmailId(CustomerName,mobileNo,emailId)!=null)
        {
            return ResponseEntity.ok().body("Verification successful");
        }
        return  ResponseEntity.notFound().build();
    }
}
