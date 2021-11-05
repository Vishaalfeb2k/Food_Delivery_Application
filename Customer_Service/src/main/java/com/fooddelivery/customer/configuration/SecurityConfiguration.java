package com.fooddelivery.customer.configuration;

import com.fooddelivery.customer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private Customer customer;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@SuppressWarnings("deprecation")
	@Bean
	AuthenticationProvider auth() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	} 



	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
			.csrf().disable()
			.authorizeRequests()

	.antMatchers("/home").hasAuthority("CUSTOMER")
			.antMatchers(HttpMethod.GET,"/home/**").permitAll()
				  .antMatchers(HttpMethod.POST,"/Customers").permitAll()
				  .antMatchers(HttpMethod.DELETE,"/Customers/**").permitAll()
				  .antMatchers(HttpMethod.PUT,"/Customers/**").permitAll()
				  .antMatchers(HttpMethod.GET,"/Customers/**").permitAll()
			.anyRequest()
			.authenticated().and().httpBasic();

	}


}
