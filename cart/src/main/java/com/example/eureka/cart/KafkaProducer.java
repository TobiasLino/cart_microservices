package com.example.eureka.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KafkaProducer {

    @Value("${order.topic}")
    private String orderTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        final var mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(orderTopic, mensageKey, message);
    }
}
