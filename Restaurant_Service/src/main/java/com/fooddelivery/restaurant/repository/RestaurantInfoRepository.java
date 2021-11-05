package com.fooddelivery.restaurant.repository;

import com.fooddelivery.restaurant.model.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo,Long>
{

}
