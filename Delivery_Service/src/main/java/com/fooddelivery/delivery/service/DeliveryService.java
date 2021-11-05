package com.fooddelivery.delivery.service;

import com.fooddelivery.delivery.entity.DeliveryTeam;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DeliveryService
{

    DeliveryTeam getdeliveryTeam(long deliveryPersonId);

    List<DeliveryTeam> getDeliveryTeamDetails();

    Map<String, Boolean> deleteDeliveryPerson(long deliveryPersonId);

    DeliveryTeam addDeliveryPerson(DeliveryTeam deliveryTeam);

    ResponseEntity<DeliveryTeam> updateDeliveryPerson(DeliveryTeam deliveryTeam);

    void updateOrderStatus(long orderId, String orderStatus);

    ResponseEntity<DeliveryTeam> updateDeliveryStatusById(long deliveryPersonId, String deliveryStatus);
}

