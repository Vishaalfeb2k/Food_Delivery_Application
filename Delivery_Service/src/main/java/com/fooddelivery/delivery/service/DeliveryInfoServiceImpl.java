package com.fooddelivery.delivery.service;

import com.fooddelivery.delivery.entity.DeliveryInfo;
import com.fooddelivery.delivery.repository.DeliveryInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService
{
    @Autowired
    public DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public DeliveryInfo assignDeliveryPerson(DeliveryInfo deliveryInfo)
    {

        deliveryInfoRepository.save(deliveryInfo);
        return deliveryInfo;
    }

    @Override
    public ResponseEntity<String> getDeliveryStatus() {
        return ResponseEntity.ok().body("Food Delivered");
    }
}
