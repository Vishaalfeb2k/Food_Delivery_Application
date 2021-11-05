package com.fooddelivery.customer.configuration;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fooddelivery.customer.dto.Customer;

public class LoginUserDetails implements UserDetails{



	
	private Customer customer;
	public LoginUserDetails(Customer customer) {
	super();
	this.customer = customer;
}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.customer.getRole()));

		return set;
	}

	@Override
	public String getPassword() {
		return this.customer.getPassword();
	}

	@Override
	public String getUsername() {
		return this.customer.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	


}
