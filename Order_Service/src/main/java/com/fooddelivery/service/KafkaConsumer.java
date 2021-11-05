package com.fooddelivery.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer
{
    @KafkaListener(topics = "first_topic", groupId = "group_json")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
