package com.fooddelivery.delivery.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="delivery_info")
public class DeliveryInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="order_id")
    long orderId;

    @Column(name="delivery_person_id")
    long deliveryPersonId;
    

}
