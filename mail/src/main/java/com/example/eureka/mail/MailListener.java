package com.example.eureka.mail;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailListener {

    @Autowired
    private MailService mailService;

    @KafkaListener(topics = "topico.comando.teste", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("HEADERS: {}", payload.headers());
        log.info("Order: {}", payload.value());
    }
}
