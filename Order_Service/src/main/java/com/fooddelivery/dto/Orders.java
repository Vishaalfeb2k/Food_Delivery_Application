package com.fooddelivery.dto;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Orders{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private long orderId;

	@Column(name="customer_id")
	private long customerId;

	@Column(name="order_status")
	private String orderStatus;

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Items.class)
	private List<Items> items=new ArrayList<>();


}

