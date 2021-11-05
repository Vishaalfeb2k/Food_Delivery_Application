package com.fooddelivery.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class DeliveryApplication {

	@PostConstruct
	void setUTCTimezone(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(DeliveryApplication.class, args);
	}

}
