package com.fooddelivery.customer.controller;

import com.fooddelivery.customer.dto.Customer;
import com.fooddelivery.customer.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private RegisterService registerService;
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to the fooddelivery app by team 19";
	}
	
	
	@GetMapping("/Customers")
	public List<Customer> getcust() throws Exception {
		return registerService.getcust();
		
	}

	@PostMapping("/Customers")
	public void addcust(@RequestBody Customer customer) {
		registerService.addcust(customer);
	}

    @PutMapping("/Customers/{id}")
	public Customer updatedetails(@PathVariable Long id,@RequestBody Customer customer) {
		return registerService.updatedetails(id,customer);
	}
	@DeleteMapping("/Customers/{id}")
    public void deletecust(@PathVariable Long id) {
    	registerService.deletecust(id);
    }

	
}
