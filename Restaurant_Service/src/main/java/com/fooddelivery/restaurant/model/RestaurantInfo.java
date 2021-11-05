package com.fooddelivery.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="restaurant_info")
public class RestaurantInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="order_id")
    long orderId;

    @Column(name = "status")
    @JoinColumn(name = "rf_fk",referencedColumnName ="id")
    private String restaurantStatus;
}
