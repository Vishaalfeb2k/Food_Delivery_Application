package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.model.Restaurant;

import java.util.List;
import java.util.Optional;


public interface RestaurantService {

     List<Restaurant> findAll();

     Optional<Restaurant> findById(int id);

     Restaurant save(Restaurant restaurants);

     List<Restaurant> saveAll(List<Restaurant> restaurants);

     Restaurant updaterestaurant(Restaurant restaurant);

     void deleteById(int id);

     void updateOrderStatus(long orderId, String orderStatus);

}

