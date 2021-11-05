package com.fooddelivery.service;

import com.fooddelivery.dto.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;


public interface OrderService
{

List<Orders> findAllOrders();

Orders addOrder(Orders order);


ResponseEntity<List<Orders>> findByCustomerId(long customerId);


ResponseEntity<Orders> updateOrderById(Orders orderDetails);

Map<String, Boolean> deleteOrderById(long orderId);

ResponseEntity<Orders> updateOrderStatusById(long orderId,String orderStatus);
}
