package com.fooddelivery.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@Entity
@Table(name="CustomerInfo")
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private long phoneNum;

	private String address;

	private String email;

	private String role = "CUSTOMER";


}
