package com.fooddelivery.delivery.repository;

import com.fooddelivery.delivery.entity.DeliveryTeam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository extends JpaRepository<DeliveryTeam,Long>
{

}
