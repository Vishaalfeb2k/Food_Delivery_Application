package com.fooddelivery.delivery.repository;

import com.fooddelivery.delivery.entity.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo,Long>
{

}
