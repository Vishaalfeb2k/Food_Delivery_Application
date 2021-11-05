package com.fooddelivery.restaurant.controller;

import com.fooddelivery.restaurant.exception.ItemNotFoundException;
import com.fooddelivery.restaurant.model.Fooditems;
import com.fooddelivery.restaurant.service.FooditemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class foodController {
    @Autowired
    private FooditemsService fooditemsService;

    @GetMapping("/Fooditems")
    public List<Fooditems> findAll() throws Exception {
        return fooditemsService.findAll();
    }

    @GetMapping("/fooditem/{id}")
    public Optional<Fooditems> fooditem(@PathVariable int id) throws ItemNotFoundException{
        return fooditemsService.finditemById(id);
    }

    @PostMapping("/additem")
    public Fooditems additem(@RequestBody Fooditems fooditems) throws Exception{
        return fooditemsService.saveitem(fooditems);
    }

    @PostMapping("additems")
    public List<Fooditems> additems(@RequestBody List<Fooditems> fooditems) throws Exception{
        return fooditemsService.saveAll(fooditems);
    }

    @PutMapping("/update1")
    public Fooditems updateitem(@RequestBody Fooditems fooditems) throws ItemNotFoundException{
        return fooditemsService.updateitem(fooditems);
    }

    @DeleteMapping("/deleteitem/{id}")
    public String deleteitem(@PathVariable int id) throws ItemNotFoundException{
        fooditemsService.deleteById(id);
        return "Item deleted";
    }

}
