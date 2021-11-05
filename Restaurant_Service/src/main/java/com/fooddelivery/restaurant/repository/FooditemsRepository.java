package com.fooddelivery.restaurant.repository;

import com.fooddelivery.restaurant.model.Fooditems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FooditemsRepository extends JpaRepository<Fooditems,Integer> {

}
