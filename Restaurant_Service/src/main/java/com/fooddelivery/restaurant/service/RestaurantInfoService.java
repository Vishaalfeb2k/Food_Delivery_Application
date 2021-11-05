package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.model.RestaurantInfo;
import org.springframework.http.ResponseEntity;

public interface RestaurantInfoService 
{

    RestaurantInfo restaurantStatusByOrderId(RestaurantInfo restaurantInfo);

    ResponseEntity<RestaurantInfo> updateRestaurantStatusById(long id, String status);
}
