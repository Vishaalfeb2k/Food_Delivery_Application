package com.fooddelivery.payment.configuration;


import com.fooddelivery.payment.dto.NetBanking;
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
public class PaymentConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private NetBanking netBanking;
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

                .antMatchers("/pay").hasAuthority("UPI")
                .antMatchers(HttpMethod.PUT,"/OrderStatus/**").permitAll()
                .antMatchers(HttpMethod.GET,"/pay").permitAll()
                .antMatchers(HttpMethod.POST,"/NetBankinginfo").permitAll()
                .antMatchers(HttpMethod.GET,"/NetBankinginfo").permitAll()
                .antMatchers(HttpMethod.DELETE,"/Delete/**").permitAll()
                .anyRequest()
                .authenticated().and().httpBasic();

    }


}
