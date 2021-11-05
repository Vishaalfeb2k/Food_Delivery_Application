package com.fooddelivery.service;

import com.fooddelivery.dto.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer
{
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Orders> kafkaJsonTemplate;


    public void produceMessage(String topic, String message)
    {

        kafkaTemplate.send(topic, message);
    }

    public void produceJsonMessage(String topic, Orders orders)
    {
        kafkaJsonTemplate.send(topic, orders);
    }
}
