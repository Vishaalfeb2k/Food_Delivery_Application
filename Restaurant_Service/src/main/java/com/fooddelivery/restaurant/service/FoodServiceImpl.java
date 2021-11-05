package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.model.Fooditems;
import com.fooddelivery.restaurant.repository.FooditemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FooditemsService{
    @Autowired
    private  FooditemsRepository fooditemsRepository;

    @Override
    public List<Fooditems> findAll() {
        return fooditemsRepository.findAll();
    }

    @Override
    public Optional<Fooditems> finditemById(int id) {
        return fooditemsRepository.findById(id);
    }

    @Override
    public Fooditems saveitem(Fooditems fooditems) {
        return fooditemsRepository.save(fooditems);
    }

    @Override
    public List<Fooditems> saveAll(List<Fooditems> fooditems) {
        return fooditemsRepository.saveAll(fooditems);
    }
    @Override
    public Fooditems updateitem(Fooditems fooditems)
    {
        Fooditems existingitem= fooditemsRepository.findById(fooditems.getId()).orElse(null);
        existingitem.setName(fooditems.getName());
        existingitem.setDescription(fooditems.getDescription());
        existingitem.setPrice(fooditems.getPrice());
        return  fooditemsRepository.save(existingitem);
    }

    @Override
    public void deleteById(int id) {
        fooditemsRepository.deleteById(id);
    }


}

