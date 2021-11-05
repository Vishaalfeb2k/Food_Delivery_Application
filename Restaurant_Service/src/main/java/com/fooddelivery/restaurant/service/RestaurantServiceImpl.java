package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.client.OrderApiClient;
import com.fooddelivery.restaurant.model.Restaurant;
import com.fooddelivery.restaurant.repository.RestaurantInfoRepository;
import com.fooddelivery.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    private OrderApiClient orderApiClient;

    @Override
    public Optional<Restaurant> findById(int id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant save(Restaurant restaurants) {
        return restaurantRepository.save(restaurants);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> saveAll(List<Restaurant> restaurants) {
        return restaurantRepository.saveAll(restaurants);
    }
    @Override
    public  Restaurant updaterestaurant(Restaurant restaurant)
     {
          Restaurant existingrestaurant= restaurantRepository.findById(restaurant.getId()).orElse(null);
          existingrestaurant.setName(restaurant.getName());
          return  restaurantRepository.save(existingrestaurant);
     }
    @Override
    public void deleteById(int id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public void updateOrderStatus(long orderId, String orderStatus) {
        orderApiClient.updateOrderStatus(orderId,orderStatus);
    }



}