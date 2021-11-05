package com.fooddelivery.restaurant.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderApiClientImpl implements OrderApiClient
{
    @Autowired
    private RestTemplate restTemplate;

    public void updateOrderStatus(long orderId,String orderStatus)
    {
        String url="http://localhost:8080/OrderStatus/{orderId}";
        Map<String,Integer> urlparams=new HashMap<>();
        urlparams.put("orderId", (int) orderId);
        UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(url);
            restTemplate.exchange(builder.buildAndExpand(urlparams).toUri(), HttpMethod.PUT, new HttpEntity<>(orderStatus),String.class);

    }

}
