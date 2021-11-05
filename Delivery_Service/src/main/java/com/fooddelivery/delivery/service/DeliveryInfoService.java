package com.fooddelivery.delivery.service;

import com.fooddelivery.delivery.entity.DeliveryInfo;
import org.springframework.http.ResponseEntity;

public interface DeliveryInfoService
{



    ResponseEntity<String> getDeliveryStatus();

    DeliveryInfo assignDeliveryPerson(DeliveryInfo deliveryInfo);
}
