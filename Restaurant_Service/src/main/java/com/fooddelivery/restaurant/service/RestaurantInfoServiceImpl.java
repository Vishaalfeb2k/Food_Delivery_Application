package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.exception.InvalidStatementException;
import com.fooddelivery.restaurant.model.RestaurantInfo;
import com.fooddelivery.restaurant.repository.RestaurantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService
{
    @Autowired
    private RestaurantInfoRepository restaurantInfoRepository;

    @Override
    public RestaurantInfo restaurantStatusByOrderId(RestaurantInfo restaurantInfo) {
        return restaurantInfoRepository.save(restaurantInfo);
    }

    @Override
    public ResponseEntity<RestaurantInfo> updateRestaurantStatusById(long id, String status) {
        RestaurantInfo restaurant=restaurantInfoRepository.findById(id).get();
        Map<String,String> hm=new HashMap<>();
        hm.put("ACCEPTED_BY_RESTAURANT","FOOD_READY");
        if(hm.get(restaurant.getRestaurantStatus()).equals(status))
        {
            restaurant.setRestaurantStatus(status);
            final RestaurantInfo updatedStatus=restaurantInfoRepository.save(restaurant);
            return ResponseEntity.ok(updatedStatus);
        }
        throw new InvalidStatementException("invalid");
    }

}
