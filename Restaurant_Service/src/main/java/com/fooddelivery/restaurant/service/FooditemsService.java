package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.model.Fooditems;

import java.util.List;
import java.util.Optional;

public interface FooditemsService {

    List<Fooditems> findAll();

    Optional<Fooditems> finditemById(int id);

    Fooditems saveitem(Fooditems fooditems);

    List<Fooditems> saveAll(List<Fooditems> fooditems);

    Fooditems updateitem(Fooditems fooditems);

    void deleteById(int id);

}
