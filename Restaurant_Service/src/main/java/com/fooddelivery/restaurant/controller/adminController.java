package com.fooddelivery.restaurant.controller;

import com.fooddelivery.restaurant.exception.RestaurantNotFoundException;
import com.fooddelivery.restaurant.model.Restaurant;
import com.fooddelivery.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/RestaurantsList")
    public List<Restaurant> getAll() throws Exception {
        return restaurantService.findAll();
    }

    @PostMapping("AddRestaurant")
    public Restaurant addrestaurant(@RequestBody Restaurant restaurants) throws Exception{
        return restaurantService.save(restaurants);
    }

    @DeleteMapping("/DeleteRestaurant/{id}")
    public String deleterestaurant(@PathVariable int id) throws RestaurantNotFoundException
    {
        restaurantService.deleteById(id);
        return "Restaurant deleted";
    }
}
