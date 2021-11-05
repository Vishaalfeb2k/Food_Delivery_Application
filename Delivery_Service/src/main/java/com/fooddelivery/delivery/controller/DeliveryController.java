package com.fooddelivery.delivery.controller;



import com.fooddelivery.delivery.entity.Customer;
import com.fooddelivery.delivery.entity.DeliveryInfo;
import com.fooddelivery.delivery.entity.DeliveryTeam;
import com.fooddelivery.delivery.exception.CustomerNotFoundException;
import com.fooddelivery.delivery.exception.DeliveryTeamNotFoundException;
import com.fooddelivery.delivery.service.DeliveryInfoService;
import com.fooddelivery.delivery.service.DeliveryService;
import com.fooddelivery.delivery.service.DeliveryVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DeliveryController
{
    @Autowired
    public DeliveryService deliveryService;

    @PutMapping("/OrderStatus/{orderId}")
    public void updateOrderStatus(@PathVariable long orderId, @RequestBody String orderStatus)
    {
     deliveryService.updateOrderStatus(orderId,orderStatus);
    }


    @Autowired
    public DeliveryVerificationService deliveryVerificationService;

    @Autowired
    public DeliveryInfoService deliveryInfoService;


    @GetMapping("/deliveryTeam")
    public List<DeliveryTeam> getDeliveryTeamDetails() throws DeliveryTeamNotFoundException
    {
       return deliveryService.getDeliveryTeamDetails();
    }

    @GetMapping("/getDeliveryPerson/{deliveryPersonId}")
    public DeliveryTeam getDeliveryTeam(@PathVariable long deliveryPersonId) throws DeliveryTeamNotFoundException
    {
    return deliveryService.getdeliveryTeam(deliveryPersonId);
    }

    @PostMapping("/addDeliveryPerson")
    public DeliveryTeam addDeliveryPerson(@RequestBody DeliveryTeam deliveryTeam)
    {
        return deliveryService.addDeliveryPerson(deliveryTeam);
    }

    @PutMapping("/updateDeliveryPerson")
    public ResponseEntity<DeliveryTeam> updateDeliveryPerson(@RequestBody @Validated DeliveryTeam deliveryTeam) throws DeliveryTeamNotFoundException
    {
        return deliveryService.updateDeliveryPerson(deliveryTeam);
    }

    @DeleteMapping("deleteDeliveryPerson/{deliveryPersonId}")
    public Map<String,Boolean> deleteDeliveryPerson(@PathVariable long deliveryPersonId) throws DeliveryTeamNotFoundException
    {
        return deliveryService.deleteDeliveryPerson(deliveryPersonId);
    }

    @GetMapping("/getCustomerDetails")
    public List<Customer> getCustomerDetails() throws CustomerNotFoundException
    {
        return deliveryVerificationService.getCustomerDetails();
    }

    @GetMapping("/verifycustomer/{customerName}/{mobileNo}/{emailId}")
    public ResponseEntity<String> verifyCustomer(@PathVariable String customerName,@PathVariable long mobileNo,@PathVariable String emailId) throws CustomerNotFoundException
    {
        return deliveryVerificationService.verifyCustomer(customerName,mobileNo,emailId);
    }

     @GetMapping("/assignDeliveryPerson")
    public DeliveryInfo assignDeliveryPersonForOrderId(@RequestBody DeliveryInfo deliveryInfo) throws DeliveryTeamNotFoundException
     {
         return deliveryInfoService.assignDeliveryPerson(deliveryInfo);
     }

     @GetMapping("/getDeliveryStatus")
     public ResponseEntity<String> getDeliveryStatus() throws Exception
     {
         return deliveryInfoService.getDeliveryStatus();
     }

    @PutMapping("/DeliveryStatus/{deliveryPersonId}")
    public ResponseEntity<DeliveryTeam> updateDeliveryStatusById(@PathVariable long deliveryPersonId,@RequestBody String deliveryStatus)
    {
        return deliveryService.updateDeliveryStatusById(deliveryPersonId,deliveryStatus);
    }

}
