package com.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.dto.Orders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface OrderRepository extends JpaRepository<Orders, Long>
{

    List<Orders> findBycustomerId(long customerId);



}
