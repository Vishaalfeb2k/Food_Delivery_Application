 package com.fooddelivery.customer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fooddelivery.customer.dto.Customer;
import com.fooddelivery.customer.repository.CustomerRepository;
@Service
public class LoginUserDetailService implements UserDetailsService {
	@Autowired
   private	CustomerRepository custRepo;
	
 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    Customer customer	= custRepo.findByusername(username);
	    	if(customer == null)
	    		throw new UsernameNotFoundException("not found");
	    return new LoginUserDetails(customer);
	    
	}

}
