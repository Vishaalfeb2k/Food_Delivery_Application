package com.fooddelivery.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    long customerId;

    @Column(name="customer_name")
    String customerName;

    @Column(name="email_id")
    String emailId;

    @Column(name="customer_mobile_number")
    long mobileNo;

    @Column(name="customer_address")
    String address;
}
