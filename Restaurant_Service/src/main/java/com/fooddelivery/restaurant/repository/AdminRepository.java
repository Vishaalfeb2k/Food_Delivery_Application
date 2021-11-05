package com.fooddelivery.restaurant.repository;

import com.fooddelivery.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Restaurant, Integer> {
}
