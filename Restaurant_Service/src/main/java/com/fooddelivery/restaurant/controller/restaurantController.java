package com.fooddelivery.restaurant.controller;

import com.fooddelivery.restaurant.exception.RestaurantNotFoundException;
import com.fooddelivery.restaurant.exception.SuccessfulReponse;
import com.fooddelivery.restaurant.model.Restaurant;
import com.fooddelivery.restaurant.model.RestaurantInfo;
import com.fooddelivery.restaurant.service.RestaurantInfoService;
import com.fooddelivery.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class restaurantController {

    @Autowired
    private  RestaurantService restaurantService;

    @Autowired
    private RestaurantInfoService restaurantInfoService;

    @PutMapping("/OrderStatus/{orderId}")
    public void updateOrderStatus(@PathVariable long orderId, @RequestBody String orderStatus) throws Exception
    {
        restaurantService.updateOrderStatus(orderId,orderStatus);
    }

    @GetMapping("/Restaurants")
    public List<Restaurant> getAll() throws RestaurantNotFoundException, SuccessfulReponse {
        return restaurantService.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> restaurant(@PathVariable ("id") int id) throws RestaurantNotFoundException,SuccessfulReponse
    {
        return restaurantService.findById(id);
    }

   @PostMapping("/addrestaurant")
    public Restaurant addirestaurant(@RequestBody Restaurant restaurants) throws Exception {
        return restaurantService.save(restaurants);
    }

    @PostMapping("addrestaurants")
    public List<Restaurant> addrestaurants(@RequestBody List<Restaurant> restaurants) throws Exception{
        return restaurantService.saveAll(restaurants);
    }

    @PutMapping("/update")
    public Restaurant updaterestaurant(@RequestBody Restaurant restaurants) throws RestaurantNotFoundException
    {
        return restaurantService.updaterestaurant(restaurants);
    }

    @DeleteMapping("/deleterestaurant/{id}")
    public String deleterestaurant(@PathVariable int id) throws RestaurantNotFoundException{
        restaurantService.deleteById(id);
        return "Restaurant deleted";
    }

    @PutMapping("/RestaurantStatus/{id}")
    public ResponseEntity<RestaurantInfo> updateRestaurantStatusById(@PathVariable long id, @RequestBody String status)
    {
        return restaurantInfoService.updateRestaurantStatusById(id,status);
    }

    @PostMapping("/restaurantInfo")
    public RestaurantInfo RestaurantStatusByOrderId(@RequestBody RestaurantInfo restaurantInfo)
    {
        return restaurantInfoService.restaurantStatusByOrderId(restaurantInfo);
    }

}
