package com.fooddelivery.delivery.service;

import com.fooddelivery.delivery.client.OrderApiClient;
import com.fooddelivery.delivery.entity.DeliveryTeam;
import com.fooddelivery.delivery.exception.InvalidStatementException;
import com.fooddelivery.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryServiceImpl implements DeliveryService
{
    @Autowired
    public DeliveryRepository deliveryRepository;

    @Autowired
    public OrderApiClient orderApiClient;

    @Override
    public DeliveryTeam getdeliveryTeam(long deliveryPersonId)
    {
       DeliveryTeam person= deliveryRepository.findById(deliveryPersonId).get();
       return person;
    }

    @Override
    public List<DeliveryTeam> getDeliveryTeamDetails()
    {

        return deliveryRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteDeliveryPerson(long deliveryPersonId) {
        deliveryRepository.deleteById(deliveryPersonId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DeliveryPerson deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public DeliveryTeam addDeliveryPerson(@Validated DeliveryTeam deliveryTeam) {
       return deliveryRepository.save(deliveryTeam);
    }

    @Override
    public ResponseEntity<DeliveryTeam> updateDeliveryPerson(DeliveryTeam deliveryTeam) {

        DeliveryTeam deliveryTeam1=deliveryRepository.findById(deliveryTeam.getDeliveryPersonId()).get();
        deliveryTeam1.setDeliveryPersonName(deliveryTeam.getDeliveryPersonName());
        deliveryTeam1.setDeliveryDate(deliveryTeam.getDeliveryDate());
        deliveryTeam1.setDeliveryTime(deliveryTeam.getDeliveryTime());
        deliveryTeam1.setMobileNumber(deliveryTeam.getMobileNumber());
        deliveryTeam1.setDeliveryStatus(deliveryTeam.getDeliveryStatus());
        final DeliveryTeam updated=deliveryRepository.save(deliveryTeam1);
        return ResponseEntity.ok(updated);
    }

    @Override
    public void updateOrderStatus(long orderId, String orderStatus) {
        orderApiClient.updateOrderStatus(orderId,orderStatus);
    }

    @Override
    public ResponseEntity<DeliveryTeam> updateDeliveryStatusById(long deliveryPersonId, String deliveryStatus)
    {
     DeliveryTeam deliveryTeam=deliveryRepository.findById(deliveryPersonId).get();
     Map<String,String> hm=new HashMap<>();
     hm.put("DELIVERY_PERSON_ASSIGNED","DELIVERED");
     if(hm.get(deliveryTeam.getDeliveryStatus()).equals(deliveryStatus))
     {
      deliveryTeam.setDeliveryStatus(deliveryStatus);
      final DeliveryTeam updatedStatus=deliveryRepository.save(deliveryTeam);
      return ResponseEntity.ok(updatedStatus);
     }
    throw new InvalidStatementException("invalid");
    }


}
