package com.fooddelivery.dto;

import lombok.Data;

import javax.persistence.*;

@Data
//@Embeddable
@Entity
@Table(name="itemsTable")
public class Items
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="product_id")
    private long productId;

    @Column(name="name")
    private String name;

    @Column(name="quantity")
    private long quantity;

    @Column(name="price")
    private Double price;
}
