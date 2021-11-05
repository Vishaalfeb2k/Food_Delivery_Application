package com.fooddelivery.controller;

import com.fooddelivery.exception.CustomerNotFoundException;
import com.fooddelivery.exception.OrderNotFoundException;
import com.fooddelivery.exception.SuccessfulResponse;
import com.fooddelivery.service.KafkaProducer;
import com.fooddelivery.service.OrderService;
import com.fooddelivery.dto.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
public class OrderController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/sendKafkaMessage")
    public void sendMessage(@RequestParam  String msg)
    {
        kafkaProducer.produceMessage("first_topic", msg);
        
    }

    @PostMapping("/sendJsonKafkaMessage")
    public String sendJsonMessage(@RequestBody Orders orders)
    {
        kafkaProducer.produceJsonMessage("jsontest", orders);
        return "Produced " +  orders.toString() + " Successfully";
    }
    @Autowired
    public OrderService orderService;

    @GetMapping("/orders")
    public List<Orders> getOrders() throws OrderNotFoundException
    {

        return orderService.findAllOrders();
    }

    @PostMapping("/orders")
    public Orders addOrder(@RequestBody Orders order) throws SuccessfulResponse,Exception
     {
         return orderService.addOrder(order);

     }

    @GetMapping("/orders/{customerId}")
    public ResponseEntity<List<Orders>> findByCustomerId(@PathVariable long customerId) throws OrderNotFoundException, CustomerNotFoundException {

        return orderService.findByCustomerId(customerId);
    }

    @PutMapping("/orders")
    public ResponseEntity<Orders> updateOrderById(@RequestBody @Validated Orders orderDetails) throws OrderNotFoundException {
        return orderService.updateOrderById(orderDetails);
    }

    @DeleteMapping("/orders/{orderId}")
    public Map<String,Boolean> deleteOrder(@PathVariable long orderId) throws OrderNotFoundException
    {
        return  orderService.deleteOrderById(orderId);
    }

    @PutMapping("/OrderStatus/{orderId}")
    public ResponseEntity<Orders> updateOrderStatusById(@PathVariable long orderId,@RequestBody String orderStatus) throws OrderNotFoundException
    {
        return orderService.updateOrderStatusById(orderId,orderStatus);
    }
}
