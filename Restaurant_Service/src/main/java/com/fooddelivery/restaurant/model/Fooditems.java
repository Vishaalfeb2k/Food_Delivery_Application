package com.fooddelivery.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_items")
public class Fooditems {

    @Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name="food_name")
    private String name;

	@Column(name="description")
    private String description;

	@Column(name="price")
    private double price;


}
